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
    assertEquals(plugin.getExtensions(), Arrays.asList(TattletaleMetrics.class, TattletaleSensor.class, TattletaleUnusedJarsWidget.class,
        TattletaleSignedJarsWidget.class, TattletaleNoVersionJarsWidget.class, TattletaleInvalidVersionJarsWidget.class,
        TattletaleRepeatedClassesWidget.class, TattletaleRepeatedPackagesWidget.class, TattletaleCircularDependenciesWidget.class,
        TattletaleDifferentVersionsJarsWidget.class, TattletaleDuplicatedJarsWidget.class));
  }
}