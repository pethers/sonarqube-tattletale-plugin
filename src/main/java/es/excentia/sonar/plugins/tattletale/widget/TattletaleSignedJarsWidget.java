package es.excentia.sonar.plugins.tattletale.widget;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.Description;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.UserRole;
import org.sonar.api.web.WidgetCategory;

/**
 * Tattletale Signed libraries Widget
 * 
 */
@UserRole(UserRole.USER)
@Description("Shows the signed libraries")
@WidgetCategory("Tattletale")
public class TattletaleSignedJarsWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  /**
   * Returns Widget ID
   */
  public final String getId() {
    return "tattletalesignedjarswidget";
  }

  /**
   * Returns Widget Title
   */
  public final String getTitle() {
    return "Tattletale Signed libraries";
  }

  /**
   * Returns Template Path
   */
  @Override
  protected final String getTemplatePath() {
    return "/TattletaleSignedJarsWidget.html.erb";
  }
}
