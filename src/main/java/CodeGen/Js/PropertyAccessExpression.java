package CodeGen.Js;

public class PropertyAccessExpression implements Expression {
    
    private Expression object;
    private String property;

    public PropertyAccessExpression(Expression object, String property) {
        this.object = object;
        this.property = property;
    }

    @Override
    public String renderJsContent(int indentLevel) {
        return object.renderJsContent(0) + "." +  property;
    }
}
