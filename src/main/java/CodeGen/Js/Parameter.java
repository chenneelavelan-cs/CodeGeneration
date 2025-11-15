package CodeGen.Js;

public class Parameter implements JsRenderable {
    private String name;
    private Expression defaultValue;

    public Parameter(String name) {
        this.name = name;
    }

    public Parameter(String name, Expression defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    @Override
    public String renderJsContent(int indentLevel) {
        if (defaultValue == null) {
            return name;
        } else {
            return name + " = " + defaultValue.renderJsContent(indentLevel);
        }
    }
    
}
