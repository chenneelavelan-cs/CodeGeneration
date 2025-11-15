package CodeGeneration.src.main.java.CodeGen.Css;

import java.util.HashMap;
import java.util.Map;

import CodeGeneration.src.main.java.CodeGen.Environment;
import CodeGeneration.src.main.java.CodeGen.Common.Utils;

public class CssRule {
    
    private int indentValue;
    private String ruleName;
    private Map<String, String> properties;

    public CssRule(String ruleName, int indentDepth) {
        this.ruleName = ruleName;
        this.properties = new HashMap<>();
        this.indentValue = Environment.STYLE_INDENTATION * indentDepth;
    }

    public CssRule(String ruleName) {
        this(ruleName, 1);
    }

    public CssRule addProperty(String name, String value) {
        this.properties.put(name, value);
        return this;
    }

    public String getCSS() {
        StringBuilder sb = new StringBuilder();
        sb.append(ruleName).append(" {");

        if (properties.size() > 0) {
            for (Map.Entry<String, String> property: properties.entrySet()) {
                sb.append("\n").append(Utils.generateIndentString(indentValue)).append(property.getKey()).append(": ").append(property.getValue()).append(";");
            }
            sb.append("\n");
        }

        sb.append("}");
        return sb.toString();
    }
}
