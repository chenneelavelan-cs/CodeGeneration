package CodeGen.Model.Js.Expressions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OperationExpressionData extends ExpressionData {
    @JsonProperty("leftOperand")
    private ExpressionData leftOperand;
    
    @JsonProperty("operator")
    private String operator;
    
    @JsonProperty("rightOperand")
    private ExpressionData rightOperand;
    
    public ExpressionData getLeftOperand() { return leftOperand; }
    public void setLeftOperand(ExpressionData leftOperand) { this.leftOperand = leftOperand; }
    
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }
    
    public ExpressionData getRightOperand() { return rightOperand; }
    public void setRightOperand(ExpressionData rightOperand) { this.rightOperand = rightOperand; }
}