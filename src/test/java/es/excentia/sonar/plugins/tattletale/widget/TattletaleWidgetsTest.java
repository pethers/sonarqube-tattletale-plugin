package es.excentia.sonar.plugins.tattletale.widget;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import es.excentia.sonar.plugins.tattletale.widget.TattletaleUnusedJarsWidget;

public class TattletaleWidgetsTest {

  private static TattletaleUnusedJarsWidget unusedJarsWidget;
  private static TattletaleSignedJarsWidget signedJarsWidget;
  private static TattletaleNoVersionJarsWidget noVersionJarsWidget;
  private static TattletaleInvalidVersionJarsWidget invalidVersionJarsWidget;

  /**
   * Called once before test methods
   */
  @BeforeClass
  public static void setUp() {
    unusedJarsWidget = new TattletaleUnusedJarsWidget();
    signedJarsWidget = new TattletaleSignedJarsWidget();
    noVersionJarsWidget = new TattletaleNoVersionJarsWidget();
    invalidVersionJarsWidget = new TattletaleInvalidVersionJarsWidget();
  }

  @Test
  public void testWidgetsId() {
    assertEquals(unusedJarsWidget.getId(), "tattletaleunusedjarswidget");
    assertEquals(signedJarsWidget.getId(), "tattletalesignedjarswidget");
    assertEquals(noVersionJarsWidget.getId(), "tattletalenoversionjarswidget");
    assertEquals(invalidVersionJarsWidget.getId(), "tattletaleinvalidversionjarswidget");
  }

  @Test
  public void testWidgetsTitle() {
    assertEquals(unusedJarsWidget.getTitle(), "Tattletale Unused JARs");
    assertEquals(signedJarsWidget.getTitle(), "Tattletale Signed JARs");
    assertEquals(noVersionJarsWidget.getTitle(), "Tattletale No Version JARs");
    assertEquals(invalidVersionJarsWidget.getTitle(), "Tattletale Invalid Version JARs");
  }

  @Test
  public void testWidgetsPath() {
    assertEquals(unusedJarsWidget.getTemplatePath(), "/TattletaleUnusedJarsWidget.html.erb");
    assertEquals(signedJarsWidget.getTemplatePath(), "/TattletaleSignedJarsWidget.html.erb");
    assertEquals(noVersionJarsWidget.getTemplatePath(), "/TattletaleNoVersionJarsWidget.html.erb");
    assertEquals(invalidVersionJarsWidget.getTemplatePath(), "/TattletaleInvalidVersionJarsWidget.html.erb");
  }
}
