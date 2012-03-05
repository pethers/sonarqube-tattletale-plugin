package es.excentia.sonar.plugins.tattletale.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Tag;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.ParagraphTag;
import org.htmlparser.util.NodeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An utility class
 */
public final class TattletaleUtil {

  private static final Logger LOG = LoggerFactory.getLogger(TattletaleUtil.class);

  /**
   * The only instance to be created
   */
  private static TattletaleUtil instance = new TattletaleUtil();

  /**
   * Private constructor (Singleton pattern)
   */
  private TattletaleUtil() {
  }

  /**
   * Obtains TattletaleUtil instance
   * 
   * @return: the instance
   */
  public TattletaleUtil getInstance() {
    return instance;
  }

  /**
   * Puts CSS Style into the HEAD
   * 
   * @param allNodes
   *          Nodes list
   * @param filter
   *          Type of elements to match
   * @param style
   *          CSS style
   */
  public static void putCssStyle(NodeList allNodes, NodeFilter filter, String style) {
    Node node;
    NodeList children;
    String nodeText, replacement;

    for (int i = 0; i < allNodes.size(); i++) {
      node = allNodes.elementAt(i);

      if (filter.accept(node)) {
        nodeText = node.getText();

        replacement = "<";
        replacement = replacement.concat(nodeText.replaceFirst("href=\".*css\"", "href=\"" + style + "\""));
        replacement = replacement.concat(">");

        node.setText(replacement);

        return;
      }

      children = node.getChildren();

      if (children != null) {
        putCssStyle(children, filter, style);
      }
    }
  }

  /**
   * Counts the number of times that the text appears in the allNodes list. Only looks in nodes that match with the filter
   * 
   * @param allNodes
   *          Nodes list to find text
   * @param filter
   *          Type of elements to match
   * @param text
   *          String we're looking for
   * @return number of times that text appears
   */
  public static int countNumberOfTimesAppearsText(NodeList allNodes, NodeFilter filter, String text) {
    Node node, childrenNode;
    NodeList children;
    String nodeText;
    int times = 0;

    for (int i = 0; i < allNodes.size(); i++) {
      node = allNodes.elementAt(i);

      if (filter.accept(node)) {
        // obtain text Node
        childrenNode = node.getFirstChild();

        if (childrenNode == null) {
          nodeText = node.getText();
        } else {
          nodeText = childrenNode.getText();
        }

        // text matches
        if (nodeText.equals(text) || nodeText.endsWith(text)) {
          times++;
        }
      }

      children = node.getChildren();

      if (children != null) {
        times += countNumberOfTimesAppearsText(children, filter, text);
      }
    }

    return times;
  }

  /**
   * Replaces the elements contained in allNodes that match with the filter with their text
   * 
   * @param allNodes
   *          Nodes list to replace the elements
   * @param filter
   *          Type of elements to replace
   */
  public static void changeNodesToText(NodeList allNodes, NodeFilter filter) {
    Node node, childrenNode;
    Tag tag, tagEnd;
    NodeList children;
    String nodeText;

    for (int i = 0; i < allNodes.size(); i++) {
      node = allNodes.elementAt(i);

      if (filter.accept(node)) {
        // create text Node
        childrenNode = node.getFirstChild();

        if (childrenNode == null) {
          nodeText = node.getText();
        } else {
          nodeText = childrenNode.getText();
        }

        // creates new tag
        tag = new ParagraphTag();
        tag.setTagName("p");
        tag.setChildren(new NodeList(new TextNode(nodeText)));
        tagEnd = new ParagraphTag();
        tagEnd.setTagName("/p");
        tag.setEndTag(tagEnd);

        // remove old Node
        allNodes.remove(node);

        // put new Node
        allNodes.add(tag);
      }

      children = node.getChildren();

      if (children != null) {
        changeNodesToText(children, filter);
      }
    }
  }

  /**
   * Removes the elements contained in allNodes that match with the filter
   * 
   * @param allNodes
   *          Nodes list to remove the elements
   * @param filter
   *          Type of elements to remove
   * @param onlyOne
   *          if its true, only removes one element
   * @return Number of nodes deleted
   */
  public static int removeNodesThatMatch(NodeList allNodes, NodeFilter filter, boolean onlyOne) {
    Node node;
    NodeList children;
    int times = 0;

    for (int i = 0; i < allNodes.size(); i++) {
      node = allNodes.elementAt(i);

      if (filter.accept(node)) {
        allNodes.remove(node);

        times++;

        if (onlyOne) {
          return times;
        }
      }

      children = node.getChildren();

      if (children != null) {
        times += removeNodesThatMatch(children, filter, onlyOne);
      }
    }

    return times;
  }

  /**
   * Converts the file content into a String
   * 
   * @param fileName
   *          name of the file to read
   * @return string content of the file
   */
  public static String fileToString(String fileName) {
    String data = "";

    File file = new File(fileName);

    if (file != null) {

      StringBuilder contents = new StringBuilder();

      try {
        BufferedReader input = new BufferedReader(new FileReader(file));

        try {
          String line = input.readLine();

          while (line != null) {
            contents.append(line);
            line = input.readLine();
          }
        } finally {
          input.close();
        }
      } catch (IOException exception) {
        LOG.error(exception.getMessage());
      }

      data = contents.toString();
    }

    return data;
  }
}
