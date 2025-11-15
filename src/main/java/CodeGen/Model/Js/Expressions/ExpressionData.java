package CodeGen.Model.Js.Expressions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = LiteralExpressionData.class, name = "literal"),
    @JsonSubTypes.Type(value = PropertyAccessExpressionData.class, name = "propertyAccess"),
    @JsonSubTypes.Type(value = FunctionCallExpressionData.class, name = "functionCall"),
    @JsonSubTypes.Type(value = OperationExpressionData.class, name = "operation")
})
public abstract class ExpressionData {
    @JsonProperty("type")
    private String type;
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
