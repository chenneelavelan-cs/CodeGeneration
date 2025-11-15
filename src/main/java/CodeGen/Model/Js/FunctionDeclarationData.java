package CodeGen.Model.Js;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = VariableDeclarationData.class, name = "variableDeclaration"),
    @JsonSubTypes.Type(value = FunctionDeclarationData.class, name = "functionDeclaration"),
    @JsonSubTypes.Type(value = ExpressionStatementData.class, name = "expressionStatement")
})
public class FunctionDeclarationData extends JsStatementData {
    @JsonProperty("functionName")
    private String functionName;
    
    @JsonProperty("parameters")
    private List<String> parameters;
    
    @JsonProperty("bodyStatements")
    private List<JsStatementData> bodyStatements;
    
    public String getFunctionName() { return functionName; }
    public void setFunctionName(String functionName) { this.functionName = functionName; }
    
    public List<String> getParameters() { return parameters; }
    public void setParameters(List<String> parameters) { this.parameters = parameters; }
    
    public List<JsStatementData> getBodyStatements() { return bodyStatements; }
    public void setBodyStatements(List<JsStatementData> bodyStatements) { this.bodyStatements = bodyStatements; }
}
