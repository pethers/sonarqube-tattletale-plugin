package es.excentia.sonar.plugins.tattletale.widget;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.Description;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.UserRole;
import org.sonar.api.web.WidgetCategory;

/**
 * Tattletale Unused libraries Widget
 * 
 */
@UserRole(UserRole.USER)
@Description("Shows the unused libraries")
@WidgetCategory("Tattletale")
public class TattletaleUnusedJarsWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  /**
   * Returns Widget ID
   */
  public final String getId() {
    return "tattletaleunusedjarswidget";
  }

  /**
   * Returns Widget Title
   */
  public final String getTitle() {
    return "Tattletale Unused libraries";
  }

  /**
   * Returns Template Path
   */
  @Override
  protected final String getTemplatePath() {
    return "/TattletaleUnusedJarsWidget.html.erb";
  }
}
