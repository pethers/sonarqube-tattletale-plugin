package es.excentia.sonar.plugins.tattletale;

import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.CoreProperties;
import org.sonar.api.batch.DependedUpon;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.config.Settings;
import org.sonar.api.measures.Measure;
import org.sonar.api.measures.Metric;
import org.sonar.api.resources.Project;

import es.excentia.sonar.plugins.tattletale.util.TattletaleUtil;

/**
 * This class implements a Sensor to calculate the TattletaleMetrics metrics
 */
public class TattletaleSensor implements Sensor {

  private static final Logger LOG = LoggerFactory.getLogger(TattletaleUtil.class);

  private final String serverURL;

  private static final int TWO = 2;
  private static final int FOUR = 4;
  private static final String JAREXTENSION = ".jar";

  /**
   * @return the serverURL
   */
  public final String getServerURL() {
    return serverURL;
  }

  /**
   * Constructor
   * 
   * @param settings
   *          Sonar settings
   */
  public TattletaleSensor(Settings settings) {
    this.serverURL = settings.getString(CoreProperties.SERVER_BASE_URL);
  }

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
   * Stores into the context the total number of JARs
   * 
   * @param context
   *          Sensor context
   * @param htmlData
   *          HTML generated by Tattletale
   */
  public final void saveTotalJars(SensorContext context, String htmlData) {
    // Creates the parser
    Parser parser = Parser.createParser(htmlData, null);

    try {
      // Parses all HTML page
      NodeList page = parser.parse(null);

      NodeFilter filter = new TagNameFilter("td");
      Integer total = TattletaleUtil.removeNodesThatMatch(page, filter, false);

      total = (total - FOUR) / TWO;

      // save measure
      context.saveMeasure(TattletaleMetrics.TOTALJARS, total.doubleValue());

    } catch (ParserException exception) {
      LOG.error(exception.getMessage());
    }
  }

  /**
   * Stores into the context 2 metrics: HTML generated by Tattletale as a DATA metric (after processing), and the metric value associated
   * 
   * @param context
   *          Sensor context
   * @param htmlData
   *          HTML generated by Tattletale
   * @param htmlMetric
   *          HTML metric
   * @param valueMetric
   *          Metric associated
   * @param expression
   *          String to find into the HTML to calculate the metric associated
   */
  public final void saveTattletaleMetric(SensorContext context, String htmlData, Metric htmlMetric, Metric valueMetric, String expression) {
    // Creates the parser
    Parser parser = Parser.createParser(htmlData, null);

    String data = "";

    try {
      // Parses all HTML page
      NodeList page = parser.parse(null);

      // Puts CSS style
      NodeFilter filter = new TagNameFilter("link");
      String style = getServerURL() + "/static/sonarTattletalePlugin/tattletale-style.css";
      TattletaleUtil.putCssStyle(page, filter, style);

      // Removing title
      filter = new TagNameFilter("h1");
      TattletaleUtil.removeNodesThatMatch(page, filter, true);

      // Removing Main link
      filter = new TagNameFilter("a");
      TattletaleUtil.removeNodesThatMatch(page, filter, true);

      // Removing links
      TattletaleUtil.changeNodesToText(page, filter);

      // after removing
      if (valueMetric.equals(TattletaleMetrics.REPEATEDCLASSES) || valueMetric.equals(TattletaleMetrics.REPEATEDPACKAGES)
          || valueMetric.equals(TattletaleMetrics.CIRCULARDEPENDENCIES)) {
        data = page.toHtml().replaceAll(", ", "");
      } else {
        data = page.toHtml();
      }

      // save measure
      context.saveMeasure(new Measure(htmlMetric, data));

      if (valueMetric.equals(TattletaleMetrics.NOVERSIONJARS) || valueMetric.equals(TattletaleMetrics.INVALIDVERSIONJARS)
          || valueMetric.equals(TattletaleMetrics.DIFFERENTVERSIONSJARS) || valueMetric.equals(TattletaleMetrics.DUPLICATEDJARS)) {
        filter = new TagNameFilter("p");
      } else if (valueMetric.equals(TattletaleMetrics.REPEATEDCLASSES) || valueMetric.equals(TattletaleMetrics.REPEATEDPACKAGES)
          || valueMetric.equals(TattletaleMetrics.CIRCULARDEPENDENCIES)) {
        filter = new TagNameFilter("tr");
      } else {
        filter = new TagNameFilter("td");
      }

      // obtaining metric
      Integer metricValue = TattletaleUtil.countNumberOfTimesAppearsText(page, filter, expression);

      // in some cases there is one more expression in the code
      if (valueMetric.equals(TattletaleMetrics.SIGNEDJARS) || valueMetric.equals(TattletaleMetrics.REPEATEDCLASSES)
          || valueMetric.equals(TattletaleMetrics.REPEATEDPACKAGES) || valueMetric.equals(TattletaleMetrics.CIRCULARDEPENDENCIES)) {
        metricValue--;
      }

      // save measure
      context.saveMeasure(valueMetric, metricValue.doubleValue());

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

      // TOTAL JARs
      String data = TattletaleUtil.fileToString(directory + "/unusedjar/index.html");
      saveTotalJars(context, data);

      // UNUSED JARs
      data = TattletaleUtil.fileToString(directory + "/unusedjar/index.html");
      saveTattletaleMetric(context, data, TattletaleMetrics.HTMLUNUSEDJARS, TattletaleMetrics.UNUSEDJARS, "No");

      // SIGNED JARs
      data = TattletaleUtil.fileToString(directory + "/sign/index.html");
      saveTattletaleMetric(context, data, TattletaleMetrics.HTMLSIGNEDJARS, TattletaleMetrics.SIGNEDJARS, "Signed");

      // NO VERSION JARs
      data = TattletaleUtil.fileToString(directory + "/noversion/index.html");
      saveTattletaleMetric(context, data, TattletaleMetrics.HTMLNOVERSIONJARS, TattletaleMetrics.NOVERSIONJARS, JAREXTENSION);

      // INVALID VERSION JARs
      data = TattletaleUtil.fileToString(directory + "/invalidversion/index.html");
      saveTattletaleMetric(context, data, TattletaleMetrics.HTMLINVALIDVERSIONJARS, TattletaleMetrics.INVALIDVERSIONJARS, JAREXTENSION);

      // REPEATED CLASSES
      data = TattletaleUtil.fileToString(directory + "/multiplejars/index.html");
      saveTattletaleMetric(context, data, TattletaleMetrics.HTMLREPEATEDCLASSES, TattletaleMetrics.REPEATEDCLASSES, "");

      // REPEATED PACKAGES
      data = TattletaleUtil.fileToString(directory + "/multiplejarspackage/index.html");
      saveTattletaleMetric(context, data, TattletaleMetrics.HTMLREPEATEDPACKAGES, TattletaleMetrics.REPEATEDPACKAGES, "");

      // CIRCULAR DEPENDENCIES
      data = TattletaleUtil.fileToString(directory + "/circulardependency/index.html");
      saveTattletaleMetric(context, data, TattletaleMetrics.HTMLCIRCULARDEPENDENCIES, TattletaleMetrics.CIRCULARDEPENDENCIES, "");

      // DIFFERENT VERSIONS JARs
      data = TattletaleUtil.fileToString(directory + "/eliminatejars/index.html");
      saveTattletaleMetric(context, data, TattletaleMetrics.HTMLDIFFERENTVERSIONSJARS, TattletaleMetrics.DIFFERENTVERSIONSJARS,
          JAREXTENSION);

      // DUPLICATED JARs
      data = TattletaleUtil.fileToString(directory + "/multiplelocations/index.html");
      saveTattletaleMetric(context, data, TattletaleMetrics.HTMLDUPLICATEDJARS, TattletaleMetrics.DUPLICATEDJARS, JAREXTENSION);
    }
  }
}
