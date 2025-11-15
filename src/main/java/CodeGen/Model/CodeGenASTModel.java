package CodeGen.Model;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

import CodeGen.Model.Css.CssModelData;
import CodeGen.Model.Html.HtmlModelData;
import CodeGen.Model.Js.JsModelData;

public class CodeGenASTModel {
    @JsonProperty("css")
    private Map<String, CssModelData> css;
    
    @JsonProperty("js")
    private Map<String, JsModelData> js;
    
    @JsonProperty("html")
    private Map<String, HtmlModelData> html;
    
    @JsonProperty("htmlRootId")
    private String htmlRootId;
    
    @JsonProperty("outputDirectory")
    private String outputDirectory;
    
    // Getters and setters
    public Map<String, CssModelData> getCss() { return css; }
    public void setCss(Map<String, CssModelData> css) { this.css = css; }
    
    public Map<String, JsModelData> getJs() { return js; }
    public void setJs(Map<String, JsModelData> js) { this.js = js; }
    
    public Map<String, HtmlModelData> getHtml() { return html; }
    public void setHtml(Map<String, HtmlModelData> html) { this.html = html; }
    
    public String getHtmlRootId() { return htmlRootId; }
    public void setHtmlRootId(String htmlRootId) { this.htmlRootId = htmlRootId; }
    
    public String getOutputDirectory() { return outputDirectory; }
    public void setOutputDirectory(String outputDirectory) { this.outputDirectory = outputDirectory; }
}