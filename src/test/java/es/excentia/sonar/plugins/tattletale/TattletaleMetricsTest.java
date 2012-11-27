package es.excentia.sonar.plugins.tattletale;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class TattletaleMetricsTest {

  private final TattletaleMetrics metrics = new TattletaleMetrics();

  @Test
  public void testGetMetrics() {
    assertEquals(TattletaleMetrics.getMetricsStatic(), Arrays.asList(TattletaleMetrics.TOTALJARS, TattletaleMetrics.UNUSEDJARS,
        TattletaleMetrics.SIGNEDJARS, TattletaleMetrics.NOVERSIONJARS, TattletaleMetrics.INVALIDVERSIONJARS,
        TattletaleMetrics.REPEATEDCLASSES, TattletaleMetrics.REPEATEDPACKAGES, TattletaleMetrics.CIRCULARDEPENDENCIES,
        TattletaleMetrics.DIFFERENTVERSIONSJARS, TattletaleMetrics.DUPLICATEDJARS, TattletaleMetrics.HTMLUNUSEDJARS,
        TattletaleMetrics.HTMLSIGNEDJARS, TattletaleMetrics.HTMLNOVERSIONJARS, TattletaleMetrics.HTMLINVALIDVERSIONJARS,
        TattletaleMetrics.HTMLREPEATEDCLASSES, TattletaleMetrics.HTMLREPEATEDPACKAGES, TattletaleMetrics.HTMLCIRCULARDEPENDENCIES,
        TattletaleMetrics.HTMLDIFFERENTVERSIONSJARS, TattletaleMetrics.HTMLDUPLICATEDJARS));

    assertEquals(metrics.getMetrics(), Arrays.asList(TattletaleMetrics.TOTALJARS, TattletaleMetrics.UNUSEDJARS,
        TattletaleMetrics.SIGNEDJARS, TattletaleMetrics.NOVERSIONJARS, TattletaleMetrics.INVALIDVERSIONJARS,
        TattletaleMetrics.REPEATEDCLASSES, TattletaleMetrics.REPEATEDPACKAGES, TattletaleMetrics.CIRCULARDEPENDENCIES,
        TattletaleMetrics.DIFFERENTVERSIONSJARS, TattletaleMetrics.DUPLICATEDJARS, TattletaleMetrics.HTMLUNUSEDJARS,
        TattletaleMetrics.HTMLSIGNEDJARS, TattletaleMetrics.HTMLNOVERSIONJARS, TattletaleMetrics.HTMLINVALIDVERSIONJARS,
        TattletaleMetrics.HTMLREPEATEDCLASSES, TattletaleMetrics.HTMLREPEATEDPACKAGES, TattletaleMetrics.HTMLCIRCULARDEPENDENCIES,
        TattletaleMetrics.HTMLDIFFERENTVERSIONSJARS, TattletaleMetrics.HTMLDUPLICATEDJARS));
  }
}