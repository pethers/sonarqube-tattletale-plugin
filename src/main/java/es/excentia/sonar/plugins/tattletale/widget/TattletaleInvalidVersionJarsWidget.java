package es.excentia.sonar.plugins.tattletale.widget;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.Description;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.UserRole;
import org.sonar.api.web.WidgetCategory;

/**
 * Tattletale Invalid version libraries Widget
 * 
 */
@UserRole(UserRole.USER)
@Description("Shows invalid version libraries")
@WidgetCategory("Tattletale")
public class TattletaleInvalidVersionJarsWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  /**
   * Returns Widget ID
   */
  public final String getId() {
    return "tattletaleinvalidversionjarswidget";
  }

  /**
   * Returns Widget Title
   */
  public final String getTitle() {
    return "Tattletale Invalid Version libraries";
  }

  /**
   * Returns Template Path
   */
  @Override
  protected final String getTemplatePath() {
    return "/TattletaleInvalidVersionJarsWidget.html.erb";
  }
}
