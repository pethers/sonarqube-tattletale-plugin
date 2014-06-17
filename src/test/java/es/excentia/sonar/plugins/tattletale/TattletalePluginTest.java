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

import java.util.Arrays;

import org.junit.Test;

import es.excentia.sonar.plugins.tattletale.widget.TattletaleCircularDependenciesWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleDifferentVersionsJarsWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleDuplicatedJarsWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleInvalidVersionJarsWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleNoVersionJarsWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleRepeatedClassesWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleRepeatedPackagesWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleSignedJarsWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleUnusedJarsWidget;

public class TattletalePluginTest {

  private final TattletalePlugin plugin = new TattletalePlugin();

  @Test
  public void testGetExtensions() {
    assertEquals("Plugin extensions must contain all extensions created", plugin.getExtensions(), Arrays.asList(TattletaleDashboard.class,
        TattletaleMetrics.class, TattletaleSensor.class, TattletaleUnusedJarsWidget.class, TattletaleSignedJarsWidget.class,
        TattletaleNoVersionJarsWidget.class, TattletaleInvalidVersionJarsWidget.class, TattletaleRepeatedClassesWidget.class,
        TattletaleRepeatedPackagesWidget.class, TattletaleCircularDependenciesWidget.class, TattletaleDifferentVersionsJarsWidget.class,
        TattletaleDuplicatedJarsWidget.class));
  }
}