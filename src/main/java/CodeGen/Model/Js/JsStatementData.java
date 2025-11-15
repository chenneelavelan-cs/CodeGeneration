package CodeGen.Model.Js;

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
public abstract class JsStatementData {
    @JsonProperty("type")
    private String type;
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}