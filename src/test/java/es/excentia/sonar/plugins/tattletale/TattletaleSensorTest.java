/*
 * Sonar Tattletale Plugin
 * Copyright (C) 2012 excentia
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;
import org.sonar.api.CoreProperties;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.config.Settings;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metric.ValueType;
import org.sonar.api.resources.Project;

import es.excentia.sonar.plugins.tattletale.util.TattletaleUtil;

public class TattletaleSensorTest {

  private TattletaleSensor sensor;
  private Settings settings;
  private SensorContextSupport context;
  private String fileName;
  private String htmlCode;
  private FileSystem fileSystem;

  @Before
  public void setUp() {
    settings = new Settings();
    settings.setProperty(CoreProperties.SERVER_BASE_URL, "http://localhost:9000");

    fileName = System.getProperty("user.dir") + "/src/test/resources/unusedjars.html";
    htmlCode = TattletaleUtil.fileToString(fileName);

    SortedSet<String> langs = new TreeSet<String>();
    langs.add(TattletaleUtil.JAVA_LANGUAGE_KEY);

    fileSystem = mock(FileSystem.class);

    when(fileSystem.languages()).thenReturn(langs);

    // sensor context
    context = spy(new SensorContextSupport());

    sensor = new TattletaleSensor(settings, fileSystem);
  }

  @Test
  public void testShouldExecuteOnProject() {
    Project project = new Project("prueba");
    assertTrue("Execute project!", sensor.shouldExecuteOnProject(project));
  }

  @Test
  public void testGetMetrics() {
    List<Metric> dependedMetrics = sensor.getDependedMetrics();

    assertTrue("Depended metrics", dependedMetrics.containsAll(Arrays.asList(TattletaleMetrics.HTMLUNUSEDJARS,
        TattletaleMetrics.HTMLNOVERSIONJARS, TattletaleMetrics.HTMLSIGNEDJARS, TattletaleMetrics.NOVERSIONJARS,
        TattletaleMetrics.SIGNEDJARS, TattletaleMetrics.UNUSEDJARS, TattletaleMetrics.TOTALJARS, TattletaleMetrics.INVALIDVERSIONJARS,
        TattletaleMetrics.HTMLINVALIDVERSIONJARS, TattletaleMetrics.REPEATEDCLASSES, TattletaleMetrics.HTMLREPEATEDCLASSES,
        TattletaleMetrics.REPEATEDPACKAGES, TattletaleMetrics.HTMLREPEATEDPACKAGES, TattletaleMetrics.CIRCULARDEPENDENCIES,
        TattletaleMetrics.HTMLCIRCULARDEPENDENCIES, TattletaleMetrics.DIFFERENTVERSIONSJARS, TattletaleMetrics.DUPLICATEDJARS,
        TattletaleMetrics.HTMLDIFFERENTVERSIONSJARS, TattletaleMetrics.HTMLDUPLICATEDJARS)));
  }

  @Test
  public void testSaveTotalJars() {
    sensor.saveTotalJars(context, htmlCode);
    assertEquals("Total JARs", context.getValue(), Double.valueOf(74.0));
  }

  @Test
  public void testSaveTattletaleMetric() {
    Metric htmlMetric = new Metric.Builder("html_metric", "HTML Metric", ValueType.DATA).setDescription("HTML Metric")
        .setDirection(Metric.DIRECTION_NONE).setQualitative(false).create();

    Metric valueMetric = mock(Metric.class);

    sensor.saveTattletaleMetric(context, htmlCode, htmlMetric, valueMetric, "No");

    assertEquals("Measure value", context.getValue(), Double.valueOf(14.0));
  }
}