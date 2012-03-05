package es.excentia.sonar.plugins.tattletale.widget;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import es.excentia.sonar.plugins.tattletale.widget.TattletaleUnusedJarsWidget;

public class TattletaleWidgetsTest {

  private static TattletaleUnusedJarsWidget unusedJarsWidget;
  private static TattletaleSignedJarsWidget signedJarsWidget;

  /**
   * Called once before test methods
   */
  @BeforeClass
  public static void setUp() {
    unusedJarsWidget = new TattletaleUnusedJarsWidget();
    signedJarsWidget = new TattletaleSignedJarsWidget();
  }

  @Test
  public void testWidgetsId() {
    assertEquals(unusedJarsWidget.getId(), "tattletaleunusedjarswidget");
    assertEquals(signedJarsWidget.getId(), "tattletalesignedjarswidget");
  }

  @Test
  public void testWidgetsTitle() {
    assertEquals(unusedJarsWidget.getTitle(), "Tattletale Unused JARs");
    assertEquals(signedJarsWidget.getTitle(), "Tattletale Signed JARs");
  }

  @Test
  public void testWidgetsPath() {
    assertEquals(unusedJarsWidget.getTemplatePath(), "/TattletaleUnusedJarsWidget.html.erb");
    assertEquals(signedJarsWidget.getTemplatePath(), "/TattletaleSignedJarsWidget.html.erb");
  }
}
