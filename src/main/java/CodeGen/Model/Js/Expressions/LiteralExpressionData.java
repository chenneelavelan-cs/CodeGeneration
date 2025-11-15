package CodeGen.Model.Js.Expressions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LiteralExpressionData extends ExpressionData {
    @JsonProperty("value")
    private String value;
    
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}