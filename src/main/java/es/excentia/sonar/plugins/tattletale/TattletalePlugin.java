package es.excentia.sonar.plugins.tattletale;

import java.util.ArrayList;
import java.util.List;

import org.sonar.api.Extension;
import org.sonar.api.SonarPlugin;

import es.excentia.sonar.plugins.tattletale.widget.TattletaleNoVersionJarsWidget;
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

    return extensions;
  }

}
