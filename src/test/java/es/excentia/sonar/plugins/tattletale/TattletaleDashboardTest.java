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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.sonar.api.web.Dashboard;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Dashboard.class })
public class TattletaleDashboardTest {

  private final TattletaleDashboard tDashboard = new TattletaleDashboard();

  @Test
  public void testCreateDashboard() {
    Dashboard dashboard = mock(Dashboard.class);
    Dashboard.Widget widget1 = mock(Dashboard.Widget.class);
    Dashboard.Widget widget2 = mock(Dashboard.Widget.class);
    Dashboard.Widget widget3 = mock(Dashboard.Widget.class);
    Dashboard.Widget widget4 = mock(Dashboard.Widget.class);
    Dashboard.Widget widget5 = mock(Dashboard.Widget.class);
    Dashboard.Widget widget6 = mock(Dashboard.Widget.class);
    Dashboard.Widget widget7 = mock(Dashboard.Widget.class);
    Dashboard.Widget widget8 = mock(Dashboard.Widget.class);
    Dashboard.Widget widget9 = mock(Dashboard.Widget.class);

    PowerMockito.mockStatic(Dashboard.class);
    when(Dashboard.create()).thenReturn(dashboard);

    when(dashboard.addWidget("tattletaleunusedjarswidget", 1)).thenReturn(widget1);
    when(dashboard.addWidget("tattletaleinvalidversionjarswidget", 1)).thenReturn(widget2);
    when(dashboard.addWidget("tattletalenoversionjarswidget", 1)).thenReturn(widget3);
    when(dashboard.addWidget("tattletaleduplicatedjarswidget", 2)).thenReturn(widget4);
    when(dashboard.addWidget("tattletalerepeatedpackageswidget", 2)).thenReturn(widget5);
    when(dashboard.addWidget("tattletalerepeatedclasseswidget", 2)).thenReturn(widget6);
    when(dashboard.addWidget("tattletalecirculardependencieswidget", 3)).thenReturn(widget7);
    when(dashboard.addWidget("tattletaledifferentversionsjarswidget", 3)).thenReturn(widget8);
    when(dashboard.addWidget("tattletalesignedjarswidget", 3)).thenReturn(widget9);

    assertEquals("A dashboard must exist", tDashboard.createDashboard(), dashboard);
  }

  @Test
  public void testGetName() {
    assertEquals("Dashboard name must be Tattletale", tDashboard.getName(), "Tattletale");
  }
}