package CodeGen.Js;

public class LiteralExpression implements Expression {
    String value;

    public LiteralExpression(String value) {
        this.value = value;
    }

    @Override
    public String renderJsContent(int indentLevel) {
        return value;
    }
}