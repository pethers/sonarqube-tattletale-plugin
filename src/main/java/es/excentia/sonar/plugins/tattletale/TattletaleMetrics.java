package es.excentia.sonar.plugins.tattletale;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metric.ValueType;
import org.sonar.api.measures.Metrics;

/**
 * Defines Tattletale plugin metrics
 */
public class TattletaleMetrics implements Metrics {

  private static final String DOMAIN = "Tattletale";

  /**
   * Total jars
   */
  public static final Metric TOTALJARS = new Metric.Builder("totaljars", "Total JARs", ValueType.INT).setDescription("Total JARs number")
      .setDirection(Metric.DIRECTION_NONE).setQualitative(false).setDomain(DOMAIN).create();

  /******************************************************* UNUSED JARS *************************************************************/

  /**
   * Unused jars
   */
  public static final Metric UNUSEDJARS = new Metric.Builder("unusedjars", "Unused JARs", ValueType.INT)
      .setDescription("Unused JARs number").setDirection(Metric.DIRECTION_WORST).setQualitative(false).setDomain(DOMAIN).create();

  /**
   * Unused jars HTML
   */
  public static final Metric HTMLUNUSEDJARS = new Metric.Builder("html_unusedjars", "HTML Unused JARs", ValueType.DATA)
      .setDescription("Unused JARs HTML code").setDirection(Metric.DIRECTION_NONE).setQualitative(false).setDomain(DOMAIN).create();

  /******************************************************* SIGNED JARS *************************************************************/

  /**
   * Signed jars
   */
  public static final Metric SIGNEDJARS = new Metric.Builder("signedjars", "Signed JARs", ValueType.INT)
      .setDescription("Signed JARs number").setDirection(Metric.DIRECTION_WORST).setQualitative(false).setDomain(DOMAIN).create();

  /**
   * Signed jars HTML
   */
  public static final Metric HTMLSIGNEDJARS = new Metric.Builder("html_signedjars", "HTML Signed JARs", ValueType.DATA)
      .setDescription("Signed JARs HTML code").setDirection(Metric.DIRECTION_NONE).setQualitative(false).setDomain(DOMAIN).create();

  /******************************************************* NO VERSION JARS **********************************************************/

  /**
   * Signed jars
   */
  public static final Metric NOVERSIONJARS = new Metric.Builder("noversionjars", "No version JARs", ValueType.INT)
      .setDescription("No version JARs number").setDirection(Metric.DIRECTION_WORST).setQualitative(false).setDomain(DOMAIN).create();

  /**
   * Signed jars HTML
   */
  public static final Metric HTMLNOVERSIONJARS = new Metric.Builder("html_noversionjars", "HTML No version JARs", ValueType.DATA)
      .setDescription("No version JARs HTML code").setDirection(Metric.DIRECTION_NONE).setQualitative(false).setDomain(DOMAIN).create();

  /************************************************** INVALID VERSION JARS **********************************************************/

  /**
   * Signed jars
   */
  public static final Metric INVALIDVERSIONJARS = new Metric.Builder("invalidversionjars", "Invalid version JARs", ValueType.INT)
      .setDescription("Invalid version JARs number").setDirection(Metric.DIRECTION_WORST).setQualitative(false).setDomain(DOMAIN).create();

  /**
   * Signed jars HTML
   */
  public static final Metric HTMLINVALIDVERSIONJARS = new Metric.Builder("html_invalidversionjars", "HTML Invalid version JARs",
      ValueType.DATA).setDescription("Invalid version JARs HTML code").setDirection(Metric.DIRECTION_NONE).setQualitative(false)
      .setDomain(DOMAIN).create();

  /**
   * getMetrics Static method
   * 
   * @return metrics defined list
   */
  public static List<Metric> getMetricsStatic() {
    return Arrays.asList(TOTALJARS, UNUSEDJARS, SIGNEDJARS, NOVERSIONJARS, INVALIDVERSIONJARS, HTMLUNUSEDJARS, HTMLSIGNEDJARS,
        HTMLNOVERSIONJARS, HTMLINVALIDVERSIONJARS);
  }

  /**
   * Calls to getMetricsStatic
   */
  public final List<Metric> getMetrics() {
    return getMetricsStatic();
  }

}
