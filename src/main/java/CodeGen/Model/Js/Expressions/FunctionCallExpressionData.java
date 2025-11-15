package CodeGen.Model.Js.Expressions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FunctionCallExpressionData extends ExpressionData {
    @JsonProperty("functionName")
    private ExpressionData functionName;
    
    @JsonProperty("arguments")
    private List<ExpressionData> arguments;
    
    public ExpressionData getFunctionName() { return functionName; }
    public void setFunctionName(ExpressionData functionName) { this.functionName = functionName; }
    
    public List<ExpressionData> getArguments() { return arguments; }
    public void setArguments(List<ExpressionData> arguments) { this.arguments = arguments; }
}