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

import org.sonar.api.web.Dashboard;
import org.sonar.api.web.DashboardLayout;
import org.sonar.api.web.DashboardTemplate;

/**
 * Tattletale dashboard
 */
public class TattletaleDashboard extends DashboardTemplate {

  private static final int FIRST_COLUMN_INDEX = 1;
  private static final int SECOND_COLUMN_INDEX = 2;
  private static final int THIRD_COLUMN_INDEX = 3;

  /**
   * Creates the dashboard
   */
  @Override
  public final Dashboard createDashboard() {
    Dashboard dashboard = Dashboard.create();
    dashboard.setLayout(DashboardLayout.TREE_COLUMNS);

    // FIRST COLUMN
    dashboard.addWidget("tattletaleunusedjarswidget", FIRST_COLUMN_INDEX);
    dashboard.addWidget("tattletaleinvalidversionjarswidget", FIRST_COLUMN_INDEX);
    dashboard.addWidget("tattletalenoversionjarswidget", FIRST_COLUMN_INDEX);

    // SECOND COLUMN
    dashboard.addWidget("tattletaleduplicatedjarswidget", SECOND_COLUMN_INDEX);
    dashboard.addWidget("tattletalerepeatedpackageswidget", SECOND_COLUMN_INDEX);
    dashboard.addWidget("tattletalerepeatedclasseswidget", SECOND_COLUMN_INDEX);

    // THIRD COLUMN
    dashboard.addWidget("tattletalecirculardependencieswidget", THIRD_COLUMN_INDEX);
    dashboard.addWidget("tattletaledifferentversionsjarswidget", THIRD_COLUMN_INDEX);
    dashboard.addWidget("tattletalesignedjarswidget", THIRD_COLUMN_INDEX);

    return dashboard;
  }

  /**
   * Dashboard name
   */
  @Override
  public final String getName() {
    return "Tattletale";
  }
}