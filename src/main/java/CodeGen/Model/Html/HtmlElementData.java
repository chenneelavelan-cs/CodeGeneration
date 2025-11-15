package CodeGen.Model.Html;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAlias;

public class HtmlElementData {
    @JsonProperty("tagName")
    private String tagName;
    
    @JsonProperty("attributes")
    private Map<String, String> attributes;
    
    @JsonProperty("children")
    private List<String> children; // IDs of child elements
    
    @JsonProperty("textContent")
    @JsonAlias("content")
    private String textContent;
    
    // Getters and setters
    public String getTagName() { return tagName; }
    public void setTagName(String tagName) { this.tagName = tagName; }
    
    public Map<String, String> getAttributes() { return attributes; }
    public void setAttributes(Map<String, String> attributes) { this.attributes = attributes; }
    
    public List<String> getChildren() { return children; }
    public void setChildren(List<String> children) { this.children = children; }
    
    public String getTextContent() { return textContent; }
    public void setTextContent(String textContent) { this.textContent = textContent; }
}