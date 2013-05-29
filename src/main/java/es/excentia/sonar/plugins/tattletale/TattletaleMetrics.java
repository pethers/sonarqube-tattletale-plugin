/*
 * Sonar Tattletale Plugin
 * Copyright (C) 2012 eXcentia
 * contact@excentia.es
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
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

  /******************************************************* UNUSED JARS ***********************************************************/

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

  /******************************************************* SIGNED JARS ************************************************************/

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

  /******************************************************* NO VERSION JARS *********************************************************/

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

  /************************************************** REPEATED CLASSES *************************************************************/

  /**
   * Repeated classes
   */
  public static final Metric REPEATEDCLASSES = new Metric.Builder("repeatedclasses", "Repeated classes", ValueType.INT)
      .setDescription("Repeated classes number").setDirection(Metric.DIRECTION_WORST).setQualitative(false).setDomain(DOMAIN).create();

  /**
   * Repeated classes HTML
   */
  public static final Metric HTMLREPEATEDCLASSES = new Metric.Builder("html_repeatedclasses", "HTML Repeated classes", ValueType.DATA)
      .setDescription("Repeated classes HTML code").setDirection(Metric.DIRECTION_NONE).setQualitative(false).setDomain(DOMAIN).create();

  /************************************************** REPEATED PACKAGES ************************************************************/

  /**
   * Repeated packages
   */
  public static final Metric REPEATEDPACKAGES = new Metric.Builder("repeatedpackages", "Repeated packages", ValueType.INT)
      .setDescription("Repeated packages number").setDirection(Metric.DIRECTION_WORST).setQualitative(false).setDomain(DOMAIN).create();

  /**
   * Repeated packages HTML
   */
  public static final Metric HTMLREPEATEDPACKAGES = new Metric.Builder("html_repeatedpackages", "HTML Repeated packages", ValueType.DATA)
      .setDescription("Repeated packages HTML code").setDirection(Metric.DIRECTION_NONE).setQualitative(false).setDomain(DOMAIN).create();

  /************************************************** CIRCULAR DEPENDENCIES ************************************************************/

  /**
   * Circular dependencies
   */
  public static final Metric CIRCULARDEPENDENCIES = new Metric.Builder("circulardependencies", "Circular dependencies", ValueType.INT)
      .setDescription("Circular dependencies number").setDirection(Metric.DIRECTION_WORST).setQualitative(false).setDomain(DOMAIN).create();

  /**
   * Circular dependencies HTML
   */
  public static final Metric HTMLCIRCULARDEPENDENCIES = new Metric.Builder("html_circulardependencies", "HTML Circular dependencies",
      ValueType.DATA).setDescription("Circular dependencies HTML code").setDirection(Metric.DIRECTION_NONE).setQualitative(false)
      .setDomain(DOMAIN).create();

  /************************************************** DIFFERENT VERSIONS JARS *********************************************************/

  /**
   * Different versions JARs
   */
  public static final Metric DIFFERENTVERSIONSJARS = new Metric.Builder("differentversionsjars", "Different versions JARs", ValueType.INT)
      .setDescription("Different versions JARs number").setDirection(Metric.DIRECTION_WORST).setQualitative(false).setDomain(DOMAIN)
      .create();

  /**
   * Different versions JARs HTML
   */
  public static final Metric HTMLDIFFERENTVERSIONSJARS = new Metric.Builder("html_differentversionsjars", "HTML Different versions JARs",
      ValueType.DATA).setDescription("Different versions JARs HTML code").setDirection(Metric.DIRECTION_NONE).setQualitative(false)
      .setDomain(DOMAIN).create();

  /************************************************** DUPLICATED JARS ******************************************************************/

  /**
   * Different versions JARs
   */
  public static final Metric DUPLICATEDJARS = new Metric.Builder("duplicatedjars", "Duplicated JARs", ValueType.INT)
      .setDescription("Duplicated JARs number").setDirection(Metric.DIRECTION_WORST).setQualitative(false).setDomain(DOMAIN).create();

  /**
   * Different versions JARs HTML
   */
  public static final Metric HTMLDUPLICATEDJARS = new Metric.Builder("html_duplicatedjars", "HTML Duplicated JARs", ValueType.DATA)
      .setDescription("Duplicated JARs HTML code").setDirection(Metric.DIRECTION_NONE).setQualitative(false).setDomain(DOMAIN).create();

  /**
   * getMetrics Static method
   * 
   * @return metrics defined list
   */
  public static List<Metric> getMetricsStatic() {
    return Arrays.asList(TOTALJARS, UNUSEDJARS, SIGNEDJARS, NOVERSIONJARS, INVALIDVERSIONJARS, REPEATEDCLASSES, REPEATEDPACKAGES,
        CIRCULARDEPENDENCIES, DIFFERENTVERSIONSJARS, DUPLICATEDJARS, HTMLUNUSEDJARS, HTMLSIGNEDJARS, HTMLNOVERSIONJARS,
        HTMLINVALIDVERSIONJARS, HTMLREPEATEDCLASSES, HTMLREPEATEDPACKAGES, HTMLCIRCULARDEPENDENCIES, HTMLDIFFERENTVERSIONSJARS,
        HTMLDUPLICATEDJARS);
  }

  /**
   * Calls to getMetricsStatic
   */
  public final List<Metric> getMetrics() {
    return getMetricsStatic();
  }
}