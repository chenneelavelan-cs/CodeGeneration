package CodeGeneration.src.main.java.CodeGen.Js;

public class OperationExpression implements Expression {
    
    private String operator;
    private Expression left;
    private Expression right;

    public OperationExpression(Expression left, String operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public String renderJsContent(int indentLevel) {
        return left.renderJsContent(indentLevel) + " " + operator + " " + right.renderJsContent(indentLevel);
    }
}
