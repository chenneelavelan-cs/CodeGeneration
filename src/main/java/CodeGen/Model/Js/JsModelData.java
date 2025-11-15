package CodeGen.Model.Js;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import CodeGen.Js.ScriptFile;

public class JsModelData {
    @JsonProperty("fileName")
    private String fileName;
    
    @JsonProperty("statements")
    private List<JsStatementData> statements;

    @JsonIgnore()
    private ScriptFile file;
    
    // Getters and setters
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    
    public List<JsStatementData> getStatements() { return statements; }
    public void setStatements(List<JsStatementData> statements) { this.statements = statements; }

    public ScriptFile getFile() { return file; }
    public void setFile(ScriptFile file) { this.file = file; }
}