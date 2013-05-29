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

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class TattletaleMetricsTest {

  private final TattletaleMetrics metrics = new TattletaleMetrics();

  @Test
  public void testGetMetrics() {
    assertEquals("Metrics list must contain all metrics created", metrics.getMetrics(), Arrays.asList(TattletaleMetrics.TOTALJARS,
        TattletaleMetrics.UNUSEDJARS, TattletaleMetrics.SIGNEDJARS, TattletaleMetrics.NOVERSIONJARS, TattletaleMetrics.INVALIDVERSIONJARS,
        TattletaleMetrics.REPEATEDCLASSES, TattletaleMetrics.REPEATEDPACKAGES, TattletaleMetrics.CIRCULARDEPENDENCIES,
        TattletaleMetrics.DIFFERENTVERSIONSJARS, TattletaleMetrics.DUPLICATEDJARS, TattletaleMetrics.HTMLUNUSEDJARS,
        TattletaleMetrics.HTMLSIGNEDJARS, TattletaleMetrics.HTMLNOVERSIONJARS, TattletaleMetrics.HTMLINVALIDVERSIONJARS,
        TattletaleMetrics.HTMLREPEATEDCLASSES, TattletaleMetrics.HTMLREPEATEDPACKAGES, TattletaleMetrics.HTMLCIRCULARDEPENDENCIES,
        TattletaleMetrics.HTMLDIFFERENTVERSIONSJARS, TattletaleMetrics.HTMLDUPLICATEDJARS));
  }
}