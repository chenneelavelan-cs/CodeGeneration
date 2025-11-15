package CodeGen.Model.Css;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CssRuleData {
    @JsonProperty("selector")
    private String selector;
    
    @JsonProperty("properties")
    private Map<String, String> properties;
    
    // Getters and setters
    public String getSelector() { return selector; }
    public void setSelector(String selector) { this.selector = selector; }
    
    public Map<String, String> getProperties() { return properties; }
    public void setProperties(Map<String, String> properties) { this.properties = properties; }
}