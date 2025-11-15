package CodeGeneration.src.main.java.CodeGen.Html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CodeGeneration.src.main.java.CodeGen.Environment;
import CodeGeneration.src.main.java.CodeGen.Common.Utils;

public class HtmlElement {
    
    private String tagName;
    private Map<String, String> attributes;
    private List<HtmlElement> children;
    private String textContent;

    private int indentCount = Environment.HTML_INDENTATION;

    public HtmlElement(String tagName) {
        this.tagName = tagName;
        this.attributes = new HashMap<>();
        this.children = new ArrayList<>();
        this.textContent = "";
    }  

    public HtmlElement addAttribute(String name, String value) {
        this.attributes.put(name, value);
        return this;
    }

    public HtmlElement addChildren(HtmlElement child) {
        this.children.add(child);
        return this;
    }

    public HtmlElement addChildrens(List<HtmlElement> children) {
        this.children.addAll(children);
        return this;
    }

    public HtmlElement setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public List<HtmlElement> getChildren() {
        return this.children;
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    public String getHTML() {
        return this.generateHTMLString(this, 0);
    }

    public String getTextContent() {
        return this.textContent;
    }

    private String generateHTMLString(HtmlElement element, int depth) {
        String indentString = generateIndentString(depth);

        StringBuilder sb = new StringBuilder();
        sb.append(indentString).append("<").append(element.tagName);

        Map<String, String> attributes = element.getAttributes();
        List<HtmlElement> children = element.getChildren();

        if (attributes.size() > 0) {
            for (Map.Entry<String, String> attr: attributes.entrySet()) {
                sb.append(" ").append(attr.getKey()).append("=\"").append(attr.getValue()).append("\"");
            }
        }

        sb.append(">");

        if (hasSomethingInside(element)) {
            sb.append("\n");
        }

        for (HtmlElement child: children) {
            sb.append(child.generateHTMLString(child, depth + 1));
        }

        if (element.getTextContent().length() > 0) {
            sb.append(indentString).append("  ").append(element.getTextContent()).append("\n");
        }

        if (hasSomethingInside(element)) {
            sb.append(indentString);
        }

        sb.append("</").append(element.tagName).append(">").append("\n");

        return sb.toString();
    }

    private String generateIndentString(int depth) {
        return  Utils.generateIndentString(indentCount, depth);
    }

    private boolean hasSomethingInside(HtmlElement element) {
        return element.getChildren().size() > 0 || element.getTextContent().length() > 0;
    }
}
