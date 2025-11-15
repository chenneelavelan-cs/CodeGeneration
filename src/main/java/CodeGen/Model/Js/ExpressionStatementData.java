package CodeGen.Model.Js;

import com.fasterxml.jackson.annotation.JsonProperty;
import CodeGen.Model.Js.Expressions.ExpressionData;

public class ExpressionStatementData extends JsStatementData {
    @JsonProperty("expression")
    private ExpressionData expression;
    
    public ExpressionData getExpression() { return expression; }
    public void setExpression(ExpressionData expression) { this.expression = expression; }
}
