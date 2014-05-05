/*
 * Sonar Tattletale Plugin
 * Copyright (C) 2012 eXcentia
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
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package es.excentia.sonar.plugins.tattletale;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.sonar.api.batch.Event;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.design.Dependency;
import org.sonar.api.measures.Measure;
import org.sonar.api.measures.MeasuresFilter;
import org.sonar.api.measures.Metric;
import org.sonar.api.resources.ProjectLink;
import org.sonar.api.resources.Resource;
import org.sonar.api.rules.Violation;

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

  public Measure saveMeasure(Measure measure) {

    if (measure.hasData()) {
      saveMeasure(measure.getMetric(), measure.getData());
    } else {
      saveMeasure(measure.getMetric(), measure.getValue());
    }

    return null;
  }

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

  public Measure saveMeasure(Resource resource, Measure measure) {
    return null;
  }

  public Measure saveMeasure(Resource resource, Metric metric, Double value) {
    return null;
  }

  public Event createEvent(Resource resource, String arg1, String arg2, String arg3, Date arg4) {
    return null;
  }

  public void deleteEvent(Event event) {
  }

  public void deleteLink(String arg0) {
  }

  public Collection<Resource> getChildren(Resource resource) {
    return null;
  }

  public Set<Dependency> getDependencies() {
    return null;
  }

  public List<Event> getEvents(Resource resource) {
    return null;
  }

  public Collection<Dependency> getIncomingDependencies(Resource resource) {
    return null;
  }

  public Measure getMeasure(Metric metric) {
    return null;
  }

  public Measure getMeasure(Resource resource, Metric metric) {
    return null;
  }

  public <M> M getMeasures(MeasuresFilter<M> measuresFilter) {
    return null;
  }

  public <M> M getMeasures(Resource resource, MeasuresFilter<M> measuresFilter) {
    return null;
  }

  public Collection<Dependency> getOutgoingDependencies(Resource resource) {
    return null;
  }

  public Resource getParent(Resource resource) {
    return null;
  }

  public <R extends Resource> R getResource(R arg0) {
    return null;
  }

  public boolean index(Resource resource) {
    return false;
  }

  public boolean index(Resource resource, Resource resource1) {
    return false;
  }

  public boolean isExcluded(Resource resource) {
    return false;
  }

  public boolean isIndexed(Resource resource, boolean arg1) {
    return false;
  }

  public Dependency saveDependency(Dependency dependency) {
    return null;
  }

  public void saveLink(ProjectLink projectLink) {
  }

  public String saveResource(Resource resource) {
    return null;
  }

  public void saveSource(Resource resource, String source) {
  }

  public void saveViolation(Violation violation) {
  }

  public void saveViolation(Violation violation, boolean arg1) {
  }

  public void saveViolations(Collection<Violation> violations) {
  }

  public Measure saveMeasure(InputFile inputFile, Measure measure) {
    return null;
  }

  public Measure saveMeasure(InputFile inputFile, Metric metric, Double value) {
    return null;
  }
}