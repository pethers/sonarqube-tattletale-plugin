package es.excentia.sonar.plugins.tattletale;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.sonar.api.CoreProperties;
import org.sonar.api.config.Settings;
import org.sonar.api.measures.Metric;
import org.sonar.api.resources.Language;
import org.sonar.api.resources.Project;

public class TattletaleSensorTest {

  private static TattletaleSensor sensor;
  private static Settings settings;

  @BeforeClass
  public static void setUp() {
    settings = new Settings();
    settings.setProperty(CoreProperties.SERVER_BASE_URL, "http://localhost:9000");

    sensor = new TattletaleSensor(settings);
  }

  @Test
  public void testShouldExecuteOnProject() {

    Project project = new Project("prueba");
    Language language = mock(Language.class);

    project.setLanguage(language);

    when(language.getKey()).thenReturn("java");
    assertTrue(sensor.shouldExecuteOnProject(project));

    when(language.getKey()).thenReturn("c++");
    assertFalse(sensor.shouldExecuteOnProject(project));
  }

  @Test
  public void testGetMetrics() {

    List<Metric> dependedMetrics = sensor.getDependedMetrics();

    assertTrue(dependedMetrics.containsAll(Arrays.asList(TattletaleMetrics.HTMLUNUSEDJARS, TattletaleMetrics.HTMLNOVERSIONJARS,
        TattletaleMetrics.HTMLSIGNEDJARS, TattletaleMetrics.NOVERSIONJARS, TattletaleMetrics.SIGNEDJARS, TattletaleMetrics.UNUSEDJARS,
        TattletaleMetrics.TOTALJARS, TattletaleMetrics.INVALIDVERSIONJARS, TattletaleMetrics.HTMLINVALIDVERSIONJARS)));
  }
}