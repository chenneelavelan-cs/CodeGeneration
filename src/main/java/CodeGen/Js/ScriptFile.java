package CodeGeneration.src.main.java.CodeGen.Js;

import java.util.ArrayList;
import java.util.List;

import CodeGeneration.src.main.java.CodeGen.Environment;
import CodeGeneration.src.main.java.CodeGen.Common.CodeGenFile;

public class ScriptFile extends CodeGenFile {
    
    private List<JsRenderable> statements;

    public ScriptFile(String fileName) {
        super(fileName);
        this.statements = new ArrayList<>();
    }

    public ScriptFile addStatement(JsRenderable statement) {
        this.statements.add(statement);
        return this;
    }

    public ScriptFile addStatements(List<JsRenderable> statements) {
        this.statements.addAll(statements);
        return this;
    }

    public String getFileExtension() {
        return Environment.JS_FILE_EXTENSION;
    }

    @Override
    public String getFileContent() {
        StringBuilder sb = new StringBuilder();
        for (JsRenderable statement : statements) {
            sb.append(statement.renderJsContent(0)).append("\n");
            if (statement != statements.getLast()) { // add new line between statements
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
