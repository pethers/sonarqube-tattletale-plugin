package es.excentia.sonar.plugins.tattletale.widget;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.Description;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.UserRole;
import org.sonar.api.web.WidgetCategory;

/**
 * Tattletale Duplicated libraries Widget
 * 
 */
@UserRole(UserRole.USER)
@Description("Shows duplicated libraries with different versions")
@WidgetCategory("Tattletale")
public class TattletaleDuplicatedJarsWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  /**
   * Returns Widget ID
   */
  public final String getId() {
    return "tattletaleduplicatedjarswidget";
  }

  /**
   * Returns Widget Title
   */
  public final String getTitle() {
    return "Tattletale Duplicated libraries";
  }

  /**
   * Returns Template Path
   */
  @Override
  protected final String getTemplatePath() {
    return "/TattletaleDuplicatedJarsWidget.html.erb";
  }
}
