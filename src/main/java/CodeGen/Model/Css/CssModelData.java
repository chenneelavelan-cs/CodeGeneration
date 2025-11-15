package CodeGen.Model.Css;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import CodeGen.Css.CssFile;

public class CssModelData {
    @JsonProperty("fileName")
    private String fileName;
    
    @JsonProperty("rules")
    private List<CssRuleData> rules;

    @JsonIgnore()
    private CssFile file;
    
    // Getters and setters
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    
    public List<CssRuleData> getRules() { return rules; }
    public void setRules(List<CssRuleData> rules) { this.rules = rules; }

    public CssFile getFile() { return file; }
    public void setFile(CssFile file) { this.file = file; }
    
}