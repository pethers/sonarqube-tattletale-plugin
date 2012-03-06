package es.excentia.sonar.plugins.tattletale.widget;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.Description;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.UserRole;
import org.sonar.api.web.WidgetCategory;

/**
 * Tattletale Different versions libraries Widget
 * 
 */
@UserRole(UserRole.USER)
@Description("Shows duplicated libraries with different versions")
@WidgetCategory("Tattletale")
public class TattletaleDifferentVersionsJarsWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  /**
   * Returns Widget ID
   */
  public final String getId() {
    return "tattletaledifferentversionsjarswidget";
  }

  /**
   * Returns Widget Title
   */
  public final String getTitle() {
    return "Tattletale Different Versions libraries";
  }

  /**
   * Returns Template Path
   */
  @Override
  protected final String getTemplatePath() {
    return "/TattletaleDifferentVersionsJarsWidget.html.erb";
  }
}
