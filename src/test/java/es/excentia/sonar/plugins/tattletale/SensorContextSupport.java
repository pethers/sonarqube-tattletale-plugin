/*
 * Sonar Tattletale Plugin
 * Copyright (C) 2012 excentia
 * contact@excentia.es
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package es.excentia.sonar.plugins.tattletale;

import java.io.Serializable;
import java.util.Collection;

import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.fs.InputModule;
import org.sonar.api.batch.fs.InputPath;
import org.sonar.api.batch.rule.ActiveRules;
import org.sonar.api.batch.sensor.coverage.NewCoverage;
import org.sonar.api.batch.sensor.cpd.NewCpdTokens;
import org.sonar.api.batch.sensor.highlighting.NewHighlighting;
import org.sonar.api.batch.sensor.issue.NewIssue;
import org.sonar.api.batch.sensor.measure.NewMeasure;
import org.sonar.api.batch.sensor.symbol.NewSymbolTable;
import org.sonar.api.config.Settings;
import org.sonar.api.design.Dependency;
import org.sonar.api.measures.Measure;
import org.sonar.api.measures.MeasuresFilter;
import org.sonar.api.measures.Metric;
import org.sonar.api.resources.Resource;
import org.sonar.api.utils.Version;

/**
 * Implements a Sensor Context to be used in the test
 */
public class SensorContextSupport implements SensorContext {

  private Metric metric;
  private Double value;
  private String data;

  /**
   * Returns the metric
   * 
   * @return the metric
   */
  public Metric getMetric() {
    return metric;
  }

  /**
   * Returns the metric's value
   * 
   * @return the metric's value
   */
  public Double getValue() {
    return value;
  }

  /**
   * Returns the metric's string value
   * 
   * @return the metric's string value
   */
  public String getData() {
    return data;
  }

  @Override
  public Measure saveMeasure(Measure measure) {

    if (measure.hasData()) {
      saveMeasure(measure.getMetric(), measure.getData());
    } else {
      saveMeasure(measure.getMetric(), measure.getValue());
    }

    return null;
  }
  
  @Override
  public Measure saveMeasure(Metric metric, Double value) {
    this.metric = metric;
    this.value = value;
    return null;
  }

  public Measure saveMeasure(Metric metric, String data) {
    this.metric = metric;
    this.data = data;
    return null;
  }

  @Override
  public Measure saveMeasure(Resource resource, Measure measure) {
    return null;
  }

  @Override
  public Measure saveMeasure(Resource resource, Metric metric, Double value) {
    return null;
  }
  
  @Override
  public Collection<Resource> getChildren(Resource resource) {
    return null;
  }

  @Override
  public Measure getMeasure(Metric metric) {
    return null;
  }
  
  @Override
  public Measure getMeasure(Resource resource, Metric metric) {
    return null;
  }
  
  @Override
  public <M> M getMeasures(MeasuresFilter<M> measuresFilter) {
    return null;
  }
  
  @Override
  public <M> M getMeasures(Resource resource, MeasuresFilter<M> measuresFilter) {
    return null;
  }
  
  @Override
  public Resource getParent(Resource resource) {
    return null;
  }

  @Override
  public <R extends Resource> R getResource(R arg0) {
    return null;
  }

  @Override
  public boolean index(Resource resource) {
    return false;
  }

  @Override
  public boolean index(Resource resource, Resource resource1) {
    return false;
  }

  @Override
  public boolean isExcluded(Resource resource) {
    return false;
  }

  @Override
  public boolean isIndexed(Resource resource, boolean arg1) {
    return false;
  }

  @Override
  public Dependency saveDependency(Dependency dependency) {
    return null;
  }
  
  @Override
  public String saveResource(Resource resource) {
    return null;
  }

  @Override
  public void saveSource(Resource resource, String source) {
  }

  @Override
  public Measure saveMeasure(InputFile inputFile, Measure measure) {
    return null;
  }
  
  @Override
  public Measure saveMeasure(InputFile inputFile, Metric metric, Double value) {
    return null;
  }

	@Override
	public Settings settings() {
		return null;
	}
	
	@Override
	public FileSystem fileSystem() {
		return null;
	}
	
	@Override
	public ActiveRules activeRules() {
		return null;
	}
	
	@Override
	public InputModule module() {
		return null;
	}
	
	@Override
	public Version getSonarQubeVersion() {
		return null;
	}
	
	@Override
	public <G extends Serializable> NewMeasure<G> newMeasure() {
		return null;
	}
	
	@Override
	public NewIssue newIssue() {
		return null;
	}
	
	@Override
	public NewHighlighting newHighlighting() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public NewSymbolTable newSymbolTable() {
		return null;
	}
	
	@Override
	public NewCoverage newCoverage() {
		return null;
	}
	
	@Override
	public NewCpdTokens newCpdTokens() {
		return null;
	}
	
	@Override
	public Resource getResource(InputPath inputPath) {
		return null;
	}
}