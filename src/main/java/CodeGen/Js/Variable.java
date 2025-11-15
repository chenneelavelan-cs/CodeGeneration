package CodeGen.Js;

import CodeGen.Environment;
import CodeGen.Common.Utils;

public class Variable implements JsRenderable {
    private String declarationType;
    private String name;
    private Expression value;

    public Variable(String declarationType, String name, Expression value) {
        this.declarationType = declarationType;
        this.name = name;
        this.value = value;
    }

    @Override
    public String renderJsContent(int indentLevel) {
        String indent = Utils.generateIndentString(Environment.JS_INDENTATION, indentLevel);
        return indent + declarationType + " " + name + (value != null ? " = " + value.renderJsContent(indentLevel) : "") + ";";
    }
}
