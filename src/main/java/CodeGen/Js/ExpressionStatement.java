package CodeGen.Js;

import CodeGen.Environment;
import CodeGen.Common.Utils;

public class ExpressionStatement implements Expression {
    
    private Expression expression;

    public ExpressionStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String renderJsContent(int indentLevel) {
        String indentString = Utils.generateIndentString(Environment.JS_INDENTATION, indentLevel);
        return indentString + expression.renderJsContent(indentLevel) + ";";
    }
}
