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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package es.excentia.sonar.plugins.tattletale;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.SonarPlugin;

import es.excentia.sonar.plugins.tattletale.widget.TattletaleCircularDependenciesWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleDifferentVersionsJarsWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleDuplicatedJarsWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleInvalidVersionJarsWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleNoVersionJarsWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleRepeatedClassesWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleRepeatedPackagesWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleSignedJarsWidget;
import es.excentia.sonar.plugins.tattletale.widget.TattletaleUnusedJarsWidget;

/**
 * Implements Tattletale Plugin for Sonar
 * 
 */
public class TattletalePlugin extends SonarPlugin {

  /**
   * Returns Classes to use into the plugin List
   * 
   * @return the classes to use into the plugin List
   */
  @Override
  public final List getExtensions() {
	return Arrays.asList(TattletaleDashboard.class,
			TattletaleMetrics.class,
			TattletaleSensor.class,
    		TattletaleUnusedJarsWidget.class,
    		TattletaleSignedJarsWidget.class,
    		TattletaleNoVersionJarsWidget.class,
    		TattletaleInvalidVersionJarsWidget.class,
    		TattletaleRepeatedClassesWidget.class,
    		TattletaleRepeatedPackagesWidget.class,
    		TattletaleCircularDependenciesWidget.class,
    		TattletaleDifferentVersionsJarsWidget.class,
    		TattletaleDuplicatedJarsWidget.class);
  }

}