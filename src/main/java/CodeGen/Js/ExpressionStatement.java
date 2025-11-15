package CodeGeneration.src.main.java.CodeGen.Js;

import CodeGeneration.src.main.java.CodeGen.Environment;
import CodeGeneration.src.main.java.CodeGen.Common.Utils;

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
