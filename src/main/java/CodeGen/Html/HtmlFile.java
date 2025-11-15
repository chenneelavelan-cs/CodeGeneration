package CodeGen.Html;

import java.util.ArrayList;
import java.util.List;

import CodeGen.Environment;
import CodeGen.Common.CodeGenFile;
import CodeGen.Css.CssFile;
import CodeGen.Js.ScriptFile;

public class HtmlFile extends CodeGenFile {
    
    private String title;
    private List<HtmlElement> elements = new ArrayList<HtmlElement>();
    private List<CssFile> cssFiles = new ArrayList<CssFile>();
    private List<ScriptFile> scriptFiles = new ArrayList<ScriptFile>();

    public HtmlFile(String fileName, String title) {
        super(fileName);
        this.title = title;
    }

    public HtmlFile addElement(HtmlElement element) {
        this.elements.add(element);
        return this;
    }

    public HtmlFile addElements(List<HtmlElement> elements) {
        this.elements.addAll(elements);
        return this;
    }

    public HtmlFile linkCssFile(CssFile cssFile) {
        this.cssFiles.add(cssFile);
        return this;
    }

    public HtmlFile linkCssFiles(List<CssFile> cssFiles) {
        this.cssFiles.addAll(cssFiles);
        return this;
    }

    public HtmlFile linkScriptFile(ScriptFile scriptFile) {
        this.scriptFiles.add(scriptFile);
        return this;
    }

    public HtmlFile linkScriptFiles(List<ScriptFile> scriptFiles) {
        this.scriptFiles.addAll(scriptFiles);
        return this;
    }

    public String getFileExtension() {
        return Environment.HTML_FILE_EXTENSION;
    }

    @Override
    public String getFileContent() {
        HtmlElement headElement = new HtmlElement("head")
            .addChildren(new HtmlElement("meta").addAttribute("charset", "UTF-8"))
            .addChildren(new HtmlElement("meta").addAttribute("name", "viewport").addAttribute("content", "width=device-width, initial-scale=1.0"));

        if (!this.cssFiles.isEmpty()) {
            for (CssFile cssFile: this.cssFiles) {
                HtmlElement linkElement = new HtmlElement("link")
                    .addAttribute("rel", "stylesheet")
                    .addAttribute("href", "./" + cssFile.getFileName() + "." + cssFile.getFileExtension());
                headElement.addChildren(linkElement);
            }
        }

        headElement.addChildren(new HtmlElement("title").setTextContent(this.title));

        HtmlElement body = new HtmlElement("body")
                    .addAttribute("style", "font-family: Arial, sans-serif;")
                    .addChildrens(this.elements);
        
        if (scriptFiles.size() > 0) {
            for (ScriptFile scriptFile: this.scriptFiles) {
                HtmlElement scriptElement = new HtmlElement("script")
                    .addAttribute("src", "./" + scriptFile.getFileName() + "." + scriptFile.getFileExtension());
                body.addChildren(scriptElement);
            }
        }

        HtmlElement finalHtml = new HtmlElement("html").addAttribute("lang", "en")
            .addChildren(headElement)
            .addChildren(body);

        String htmlOut = Environment.DOCTYPE_DECLARATION + "\n" + finalHtml.getHTML();
        return htmlOut;
    }
}
