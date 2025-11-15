package CodeGen.Engine;

import java.util.Map;

import CodeGen.Common.FileCreator;
import CodeGen.Css.CssFile;
import CodeGen.FileFactory.CssFactory;
import CodeGen.FileFactory.HtmlFactory;
import CodeGen.FileFactory.ScriptFactory;
import CodeGen.Html.HtmlFile;
import CodeGen.Js.ScriptFile;
import CodeGen.Model.CodeGenASTModel;
import CodeGen.Model.Css.CssModelData;
import CodeGen.Model.Html.HtmlModelData;
import CodeGen.Model.Js.JsModelData;

public class CodeGenEngine {

    /**
     * Generates code files based on the provided AST model.
     * @param ast
     */
    public static void generateCode(CodeGenASTModel ast) {

        // Generate CSS files
        if (ast.getCss() != null) {
            CssFactory cssFactory = new CssFactory();

            for (Map.Entry<String, CssModelData> entry : ast.getCss().entrySet()) { // Iterates through each CSS model and generate css files
                CssFile cssFile = cssFactory.createCodeGenFile(entry.getValue());
                entry.getValue().setFile(cssFile);

                // Create CSS File
                FileCreator.createFile(cssFile, ast.getOutputDirectory());
                System.out.println("Generated CSS file: " + cssFile.getFileName());
            }
        }
        
        // Generate JS files
        if (ast.getJs() != null) {
            ScriptFactory scriptFactory = new ScriptFactory();

            for (Map.Entry<String, JsModelData> entry : ast.getJs().entrySet()) { // Iterates through each JS model and generate js files
                ScriptFile scriptFile = scriptFactory.createCodeGenFile(entry.getValue());
                entry.getValue().setFile(scriptFile);

                // Create JS File
                FileCreator.createFile(scriptFile, ast.getOutputDirectory());
                System.out.println("Generated JS file: " + scriptFile.getFileName());
            }
        }
        
        // Generate HTML files
        if (ast.getHtml() != null) {
            HtmlFactory htmlFactory = new HtmlFactory();

            for (Map.Entry<String, HtmlModelData> entry : ast.getHtml().entrySet()) { // Iterates through each HTML model and generate html files
                HtmlModelData htmlData = entry.getValue();

                htmlData.setRootFile(htmlData.getFileName().equals(ast.getHtmlRootId()));
                htmlData.setRootElementId(ast.getHtmlRootId());
                
                HtmlFile htmlFile = htmlFactory.createCodeGenFile(htmlData);
                
                // Link CSS Files
                if (htmlData.getCssFiles() != null) {
                    for (String cssId : htmlData.getCssFiles()) { // Link CSS files to HTML
                        if (ast.getCss() != null && ast.getCss().containsKey(cssId)) {
                            htmlFile.linkCssFile(ast.getCss().get(cssId).getFile());
                        }
                    }
                }
                
                // Link JS Files
                if (htmlData.getJsFiles() != null) {
                    for (String jsId : htmlData.getJsFiles()) { // Link JS files to HTML
                        if (ast.getJs() != null && ast.getJs().containsKey(jsId)) {
                            htmlFile.linkScriptFile(ast.getJs().get(jsId).getFile());
                        }
                    }
                }
                
                // Create HTML File
                FileCreator.createFile(htmlFile, ast.getOutputDirectory());
                System.out.println("Generated HTML file: " + htmlFile.getFileName());
            }
        }
        
        System.out.println("Code generation completed!");
    }
}
