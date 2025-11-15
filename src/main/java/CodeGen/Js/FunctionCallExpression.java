package CodeGeneration.src.main.java.CodeGen.Js;

public class FunctionCallExpression implements Expression {
    
    private Expression callee;
    private Expression[] arguments;

    public FunctionCallExpression(Expression callee, Expression... arguments) {
        this.callee = callee;
        this.arguments = arguments;
    }


    @Override
    public String renderJsContent(int indentLevel) {
        StringBuilder argsBuilder = new StringBuilder();
        for (int i = 0; i < arguments.length; i++) {
            argsBuilder.append(arguments[i].renderJsContent(indentLevel));
            if (i < arguments.length - 1) {
                argsBuilder.append(", ");
            }
        }
        return callee.renderJsContent(indentLevel) + "(" + argsBuilder.toString() + ")";
    }
}
