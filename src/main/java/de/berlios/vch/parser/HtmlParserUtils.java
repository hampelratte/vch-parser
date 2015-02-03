package de.berlios.vch.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParserUtils {

    // public static Element getElementById(final String id, Parser parser) throws ParserException {
    // Node desired = null;
    //
    // NodeList nodes = parser.extractAllNodesThatMatch(new NodeFilter() {
    // @Override
    // public boolean accept(Node node) {
    // if (node instanceof Tag) {
    // Tag tag = (Tag) node;
    // if (id.equals(tag.getAttribute("id"))) {
    // return true;
    // }
    // }
    // return false;
    // }
    // });
    //
    // if (nodes.size() > 0) {
    // desired = nodes.elementAt(0);
    // }
    //
    // return desired;
    // }

    /**
     * Returns the tag selected by the given selector or null
     * 
     * @param html
     * @param charset
     * @param cssSelector
     * @return the tag selected by the given selector or null
     */
    public static Element getTag(String html, String cssSelector) {
        Elements list = getTags(html, cssSelector);
        if (list.size() > 0) {
            Element tag = list.first();
            return tag;
        } else {
            return null;
        }
    }

    public static Elements getTags(String html, String cssSelector) {
        Document doc = Jsoup.parse(html);
        return doc.select(cssSelector);
    }

    /**
     * 
     * @param html
     * @param charset
     * @param cssSelector
     * @return The text content of the selected element or an empty string, if nothing has been selected
     */
    public static String getText(String html, String cssSelector) {
        Document doc = Jsoup.parse(html);
        Elements selection = doc.select(cssSelector);

        if (selection.size() == 0) {
            throw new RuntimeException("Bad selector. No element selected by " + cssSelector);
            // } else if (selection.size() != 1) {
            // throw new RuntimeException("Ambiguous selector. More than one element selected by " + cssSelector);
        }

        Element elem = selection.first();
        return elem.text();
    }

    // @SuppressWarnings("unchecked")
    // public static <T extends Node> T findChildByType(Node node, Class<T> type) throws ParserException {
    // NodeList childs = node.getChildren();
    // NodeIterator iter = childs.elements();
    // while (iter.hasMoreNodes()) {
    // Node child = iter.nextNode();
    // if (child.getClass().equals(type)) {
    // return (T) child;
    // }
    //
    // // look up recursive
    // if (child.getChildren() != null && child.getChildren().size() > 0) {
    // Node result = findChildByType(child, type);
    // if (result != null) {
    // return (T) result;
    // }
    // }
    // }
    //
    // return null;
    // }
}
