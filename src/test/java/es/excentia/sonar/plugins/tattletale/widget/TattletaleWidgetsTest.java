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
  private static TattletaleRepeatedClassesWidget repeatedClassesWidget;
  private static TattletaleRepeatedPackagesWidget repeatedPackagesWidget;
  private static TattletaleCircularDependenciesWidget circularDependenciesWidget;
  private static TattletaleDifferentVersionsJarsWidget differentVersionsJarsWidget;
  private static TattletaleDuplicatedJarsWidget duplicatedJarsWidget;

  /**
   * Called once before test methods
   */
  @BeforeClass
  public static void setUp() {
    unusedJarsWidget = new TattletaleUnusedJarsWidget();
    signedJarsWidget = new TattletaleSignedJarsWidget();
    noVersionJarsWidget = new TattletaleNoVersionJarsWidget();
    invalidVersionJarsWidget = new TattletaleInvalidVersionJarsWidget();
    repeatedClassesWidget = new TattletaleRepeatedClassesWidget();
    repeatedPackagesWidget = new TattletaleRepeatedPackagesWidget();
    circularDependenciesWidget = new TattletaleCircularDependenciesWidget();
    differentVersionsJarsWidget = new TattletaleDifferentVersionsJarsWidget();
    duplicatedJarsWidget = new TattletaleDuplicatedJarsWidget();
  }

  @Test
  public void testWidgetsId() {
    assertEquals(unusedJarsWidget.getId(), "tattletaleunusedjarswidget");
    assertEquals(signedJarsWidget.getId(), "tattletalesignedjarswidget");
    assertEquals(noVersionJarsWidget.getId(), "tattletalenoversionjarswidget");
    assertEquals(invalidVersionJarsWidget.getId(), "tattletaleinvalidversionjarswidget");
    assertEquals(repeatedClassesWidget.getId(), "tattletalerepeatedclasseswidget");
    assertEquals(repeatedPackagesWidget.getId(), "tattletalerepeatedpackageswidget");
    assertEquals(circularDependenciesWidget.getId(), "tattletalecirculardependencieswidget");
    assertEquals(differentVersionsJarsWidget.getId(), "tattletaledifferentversionsjarswidget");
    assertEquals(duplicatedJarsWidget.getId(), "tattletaleduplicatedjarswidget");
  }

  @Test
  public void testWidgetsTitle() {
    assertEquals(unusedJarsWidget.getTitle(), "Tattletale Unused libraries");
    assertEquals(signedJarsWidget.getTitle(), "Tattletale Signed libraries");
    assertEquals(noVersionJarsWidget.getTitle(), "Tattletale No Version libraries");
    assertEquals(invalidVersionJarsWidget.getTitle(), "Tattletale Invalid Version libraries");
    assertEquals(repeatedClassesWidget.getTitle(), "Tattletale Repeated Classes");
    assertEquals(repeatedPackagesWidget.getTitle(), "Tattletale Repeated Packages");
    assertEquals(circularDependenciesWidget.getTitle(), "Tattletale Circular Dependencies libraries");
    assertEquals(differentVersionsJarsWidget.getTitle(), "Tattletale Different Versions libraries");
    assertEquals(duplicatedJarsWidget.getTitle(), "Tattletale Duplicated libraries");
  }

  @Test
  public void testWidgetsPath() {
    assertEquals(unusedJarsWidget.getTemplatePath(), "/TattletaleUnusedJarsWidget.html.erb");
    assertEquals(signedJarsWidget.getTemplatePath(), "/TattletaleSignedJarsWidget.html.erb");
    assertEquals(noVersionJarsWidget.getTemplatePath(), "/TattletaleNoVersionJarsWidget.html.erb");
    assertEquals(invalidVersionJarsWidget.getTemplatePath(), "/TattletaleInvalidVersionJarsWidget.html.erb");
    assertEquals(repeatedClassesWidget.getTemplatePath(), "/TattletaleRepeatedClassesWidget.html.erb");
    assertEquals(repeatedPackagesWidget.getTemplatePath(), "/TattletaleRepeatedPackagesWidget.html.erb");
    assertEquals(circularDependenciesWidget.getTemplatePath(), "/TattletaleCircularDependenciesWidget.html.erb");
    assertEquals(differentVersionsJarsWidget.getTemplatePath(), "/TattletaleDifferentVersionsJarsWidget.html.erb");
    assertEquals(duplicatedJarsWidget.getTemplatePath(), "/TattletaleDuplicatedJarsWidget.html.erb");
  }
}
