package CodeGeneration.src.main.java.CodeGen.Js;

public interface Expression extends JsRenderable {
    default Expression dot(String property) {
        return new PropertyAccessExpression(this, property);
    }

    default Expression call(Expression... args) {
        return new FunctionCallExpression(this, args);
    }
}