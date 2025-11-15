package CodeGen.Model.Js;

import com.fasterxml.jackson.annotation.JsonProperty;
import CodeGen.Model.Js.Expressions.ExpressionData;

public class VariableDeclarationData extends JsStatementData {
    @JsonProperty("declarationType")
    private String declarationType;
    
    @JsonProperty("variableName")
    private String variableName;
    
    @JsonProperty("value")
    private ExpressionData value;
    
    public String getDeclarationType() { return declarationType; }
    public void setDeclarationType(String declarationType) { this.declarationType = declarationType; }
    
    public String getVariableName() { return variableName; }
    public void setVariableName(String variableName) { this.variableName = variableName; }
    
    public ExpressionData getValue() { return value; }
    public void setValue(ExpressionData value) { this.value = value; }
}