package es.excentia.sonar.plugins.tattletale;

import java.util.ArrayList;
import java.util.List;

import org.sonar.api.Extension;
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
  public final List<Class<? extends Extension>> getExtensions() {
    List<Class<? extends Extension>> extensions = new ArrayList<Class<? extends Extension>>();

    extensions.add(TattletaleMetrics.class);
    extensions.add(TattletaleSensor.class);
    extensions.add(TattletaleUnusedJarsWidget.class);
    extensions.add(TattletaleSignedJarsWidget.class);
    extensions.add(TattletaleNoVersionJarsWidget.class);
    extensions.add(TattletaleInvalidVersionJarsWidget.class);
    extensions.add(TattletaleRepeatedClassesWidget.class);
    extensions.add(TattletaleRepeatedPackagesWidget.class);
    extensions.add(TattletaleCircularDependenciesWidget.class);
    extensions.add(TattletaleDifferentVersionsJarsWidget.class);
    extensions.add(TattletaleDuplicatedJarsWidget.class);

    return extensions;
  }

}
