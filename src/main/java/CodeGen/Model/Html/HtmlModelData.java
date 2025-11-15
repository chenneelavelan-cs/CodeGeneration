package CodeGen.Model.Html;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HtmlModelData {
    @JsonProperty("fileName")
    private String fileName;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("elements")
    private Map<String, HtmlElementData> elements;
    
    @JsonProperty("cssFiles")
    private List<String> cssFiles;
    
    @JsonProperty("jsFiles")
    private List<String> jsFiles;

    @JsonIgnore()
    private boolean isRootFile;

    @JsonIgnore()
    private String rootElementId;
    
    // Getters and setters
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public Map<String, HtmlElementData> getElements() { return elements; }
    public void setElements(Map<String, HtmlElementData> elements) { this.elements = elements; }
    
    public List<String> getCssFiles() { return cssFiles; }
    public void setCssFiles(List<String> cssFiles) { this.cssFiles = cssFiles; }
    
    public List<String> getJsFiles() { return jsFiles; }
    public void setJsFiles(List<String> jsFiles) { this.jsFiles = jsFiles; }

    public boolean isRootFile() { return isRootFile; }
    public void setRootFile(boolean isRootFile) { this.isRootFile = isRootFile; }

    public String getRootElementId() { return rootElementId; }
    public void setRootElementId(String rootElementId) { this.rootElementId = rootElementId; }
    
}