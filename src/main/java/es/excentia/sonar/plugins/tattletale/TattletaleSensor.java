package es.excentia.sonar.plugins.tattletale;

import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.DependedUpon;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.measures.Measure;
import org.sonar.api.measures.Metric;
import org.sonar.api.resources.Project;

import es.excentia.sonar.plugins.tattletale.util.TattletaleUtil;

/**
 * This class implements a Sensor to calculate the TattletaleMetrics metrics
 */
public class TattletaleSensor implements Sensor {

  private static final Logger LOG = LoggerFactory.getLogger(TattletaleUtil.class);

  /**
   * Should this sensor be executed on Sonar?
   */
  public final boolean shouldExecuteOnProject(Project project) {
    boolean execute = false;

    // only if it's a java project
    if (project.getLanguage().getKey().equals("java")) {
      execute = true;
    }
    return execute;
  }

  /**
   * 
   * @return Metrics list implemented
   */
  @DependedUpon
  public final List<Metric> getDependedMetrics() {
    return TattletaleMetrics.getMetricsStatic();
  }

  /**
   * 
   * @param context
   * @param htmlData
   * @param htmlMetric
   * @param valueMetric
   * @param expression
   */
  public final void saveTattletaleMetric(SensorContext context, String htmlData, Metric htmlMetric, Metric valueMetric, String expression) {
    // Creates the parser
    Parser parser = Parser.createParser(htmlData, null);

    String data = "";

    try {
      // Parses all HTML page
      NodeList page = parser.parse(null);

      // Applying Sonar CSS
      NodeFilter filter = new TagNameFilter("link");
      TattletaleUtil.putSonarCssStyle(page, filter);

      // Removing title
      filter = new TagNameFilter("h1");
      TattletaleUtil.removeNodesThatMatch(page, filter, true);

      // Removing Main link
      filter = new TagNameFilter("a");
      TattletaleUtil.removeNodesThatMatch(page, filter, true);

      // Removing links
      TattletaleUtil.changeNodesToText(page, filter);

      // after removing
      data = page.toHtml();

      // save measure
      context.saveMeasure(new Measure(htmlMetric, data));

      // obtaining metric
      filter = new TagNameFilter("td");
      Integer unusedJarsNumber = TattletaleUtil.countNumberOfTimesAppearsText(page, filter, expression);

      // save measure
      context.saveMeasure(valueMetric, unusedJarsNumber.doubleValue());

    } catch (ParserException exception) {
      LOG.error(exception.getMessage());
    }
  }

  /**
   * Obtains information about the Sonar project and used to save measures
   * 
   * @param resource
   *          the resource where the method is executed (project, class...)
   * @param context
   *          the decorator context
   */
  public final void analyse(Project project, SensorContext context) {

    String directory = (String) project.getProperty("tattletale-destination-directory");

    if (directory != null) {

      // UNUSED JARs
      String data = TattletaleUtil.fileToString(directory + "/unusedjar/index.html");
      saveTattletaleMetric(context, data, TattletaleMetrics.HTMLUNUSEDJARS, TattletaleMetrics.UNUSEDJARS, "No");

      // SIGNED JARs
      data = TattletaleUtil.fileToString(directory + "/sign/index.html");
      saveTattletaleMetric(context, data, TattletaleMetrics.HTMLSIGNEDJARS, TattletaleMetrics.SIGNEDJARS, "Unsigned");
    }
  }
}
