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
package es.excentia.sonar.plugins.tattletale.util;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TattletaleUtilTest {

  private static final Logger LOG = LoggerFactory.getLogger(TattletaleUtilTest.class);

  private String fileName;
  private String htmlCode;
  private Parser parser;

  @Before
  public void setUp() {
    fileName = System.getProperty("user.dir") + "/src/test/resources/unusedjars.html";
    htmlCode = TattletaleUtil.fileToString(fileName);

    parser = Parser.createParser(htmlCode, null);
  }

  @Test
  public void testFileToString() {
    assertTrue(htmlCode.length() > 0);
    assertTrue(htmlCode.contains("<title>JBoss Tattletale 1.1.2.Final: Unused Jar</title>"));
  }

  @Test
  public void testRemoveNodesThatMatch() {
    try {
      NodeList page = parser.parse(null);
      NodeFilter filter = new TagNameFilter("head");

      assertSame(page.extractAllNodesThatMatch(filter, true).size(), 1);

      int deletedNodes = TattletaleUtil.removeNodesThatMatch(page, filter, true);

      assertSame(page.extractAllNodesThatMatch(filter, true).size(), 0);
      assertSame(deletedNodes, 1);

    } catch (ParserException exception) {
      LOG.debug(exception.getMessage());
    }
  }

  @Test
  public void testChangeNodesToText() {
    try {
      NodeList page = parser.parse(null);
      NodeFilter aFilter = new TagNameFilter("a");

      assertTrue(page.extractAllNodesThatMatch(aFilter, true).size() > 0);

      TattletaleUtil.removeNodesThatMatch(page, aFilter, true);
      TattletaleUtil.changeNodesToText(page, aFilter);

      assertSame(page.extractAllNodesThatMatch(aFilter, true).size(), 0);

    } catch (ParserException exception) {
      LOG.debug(exception.getMessage());
    }
  }

  @Test
  public void testCountNumberOfTimesAppearsText() {
    try {
      NodeList page = parser.parse(null);
      NodeFilter tdFilter = new TagNameFilter("td");

      int times = TattletaleUtil.countNumberOfTimesAppearsText(page, tdFilter, "No");

      assertSame(times, 14);

    } catch (ParserException exception) {
      LOG.debug(exception.getMessage());
    }
  }

  @Test
  public void testPutCssStyle() {
    try {
      NodeList page = parser.parse(null);
      NodeFilter linkFilter = new TagNameFilter("link");

      TattletaleUtil.putCssStyle(page, linkFilter, "/stylesheets/sonar.css");

      assertTrue(page.toHtml().contains("href=\"/stylesheets/sonar.css\""));

    } catch (ParserException exception) {
      LOG.debug(exception.getMessage());
    }
  }
}