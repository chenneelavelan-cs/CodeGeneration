package CodeGeneration.src.main.java.CodeGen.Js;

import java.util.ArrayList;
import java.util.List;

public class Function implements JsRenderable {
    
    private String functionName;
    private List<Parameter> parameters = new ArrayList<>();
    private List<JsRenderable> bodyStatements = new ArrayList<>();

    public Function(String functionName) {
        this.functionName = functionName;
    }

    public Function addParameter(Parameter parameter) {
        this.parameters.add(parameter);
        return this;
    }

    public Function addBodyStatement(JsRenderable statement) {
        this.bodyStatements.add(statement);
        return this;
    }

    @Override
    public String renderJsContent(int indentLevel) {
        StringBuilder sb = new StringBuilder();
        String indent = " ".repeat(indentLevel);

        sb.append(indent).append("function ").append(functionName).append("(");
        for (int i = 0; i < parameters.size(); i++) {
            sb.append(parameters.get(i).renderJsContent(0));
            if (i < parameters.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(") {\n");
        
        for (JsRenderable statement : bodyStatements) {
            sb.append(statement.renderJsContent(indentLevel + 1)).append("\n");
        }

        sb.append(indent).append("}");
        return sb.toString();
    }
}
