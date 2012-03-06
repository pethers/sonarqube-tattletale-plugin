package es.excentia.sonar.plugins.tattletale;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.sonar.api.CoreProperties;
import org.sonar.api.config.Settings;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metric.ValueType;
import org.sonar.api.resources.Language;
import org.sonar.api.resources.Project;

import es.excentia.sonar.plugins.tattletale.util.TattletaleUtil;

public class TattletaleSensorTest {

  private TattletaleSensor sensor;
  private Settings settings;
  private SensorContextSupport context;
  private String fileName;
  private String htmlCode;

  @Before
  public void setUp() {
    settings = new Settings();
    settings.setProperty(CoreProperties.SERVER_BASE_URL, "http://localhost:9000");

    fileName = System.getProperty("user.dir") + "/src/test/resources/unusedjars.html";
    htmlCode = TattletaleUtil.fileToString(fileName);

    // sensor context
    context = spy(new SensorContextSupport());

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
        TattletaleMetrics.TOTALJARS, TattletaleMetrics.INVALIDVERSIONJARS, TattletaleMetrics.HTMLINVALIDVERSIONJARS,
        TattletaleMetrics.REPEATEDCLASSES, TattletaleMetrics.HTMLREPEATEDCLASSES, TattletaleMetrics.REPEATEDPACKAGES,
        TattletaleMetrics.HTMLREPEATEDPACKAGES, TattletaleMetrics.CIRCULARDEPENDENCIES, TattletaleMetrics.HTMLCIRCULARDEPENDENCIES,
        TattletaleMetrics.DIFFERENTVERSIONSJARS, TattletaleMetrics.DUPLICATEDJARS, TattletaleMetrics.HTMLDIFFERENTVERSIONSJARS,
        TattletaleMetrics.HTMLDUPLICATEDJARS)));
  }

  @Test
  public void testSaveTotalJars() {
    sensor.saveTotalJars(context, htmlCode);
    assertTrue(context.getValue() == 74);
  }

  @Test
  public void testSaveTattletaleMetric() {
    Metric htmlMetric = new Metric.Builder("html_metric", "HTML Metric", ValueType.DATA).setDescription("HTML Metric")
        .setDirection(Metric.DIRECTION_NONE).setQualitative(false).create();

    Metric valueMetric = mock(Metric.class);

    sensor.saveTattletaleMetric(context, htmlCode, htmlMetric, valueMetric, "No");

    assertTrue(context.getValue() == 14);
  }
}