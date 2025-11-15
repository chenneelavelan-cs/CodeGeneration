package CodeGen.Model.Js.Expressions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PropertyAccessExpressionData extends ExpressionData {
    @JsonProperty("object")
    private ExpressionData object;
    
    @JsonProperty("property")
    private String property;
    
    public ExpressionData getObject() { return object; }
    public void setObject(ExpressionData object) { this.object = object; }
    
    public String getProperty() { return property; }
    public void setProperty(String property) { this.property = property; }
}
