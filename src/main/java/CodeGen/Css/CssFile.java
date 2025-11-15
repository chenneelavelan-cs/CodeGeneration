package CodeGen.Css;

import java.util.ArrayList;
import java.util.List;

import CodeGen.Environment;
import CodeGen.Common.CodeGenFile;

public class CssFile extends CodeGenFile {

    public List<CssRule> rules = new ArrayList<CssRule>();
    
    public CssFile(String fileName) {
        super(fileName);

        if (Environment.GENERATE_RESET_CSS) {
            CssRule resetRule = new CssRule("*")
                .addProperty("margin", "0")
                .addProperty("padding", "0")
                .addProperty("box-sizing", "border-box");
            this.rules.add(resetRule);

            // generate basic reset rules
            CssRule bodyRule = new CssRule("body")
                .addProperty("font-family", "'Segoe UI', Tahoma, Geneva, Verdana, sans-serif")
                .addProperty("line-height", "1.6")
                .addProperty("background-color", "#f4f4f4")
                .addProperty("color", "#333");
            this.rules.add(bodyRule);

            CssRule aRule = new CssRule("a")
                .addProperty("color", "#333")
                .addProperty("text-decoration", "none");
            this.rules.add(aRule);

            CssRule imgRule = new CssRule("img")
                .addProperty("max-width", "100%")
                .addProperty("height", "auto");
            this.rules.add(imgRule);

            CssRule buttonRule = new CssRule("button")
                .addProperty("cursor", "pointer")
                .addProperty("border", "none")
                .addProperty("padding", "10px 15px")
                .addProperty("background-color", "#333")
                .addProperty("color", "#fff");
            this.rules.add(buttonRule);
        }
    }

    public CssFile addRule(CssRule rule) {
        this.rules.add(rule);
        return this;
    }

    public CssFile removeRule(CssRule rule) {
        this.rules.remove(rule);
        return this;
    }

    public CssFile addRules(List<CssRule> rules) {
        this.rules.addAll(rules);
        return this;
    }

    public List<CssRule> getRules() {
        return this.rules;
    }

    public String getFileExtension() {
        return Environment.CSS_FILE_EXTENSION;
    }

    @Override
    public String getFileContent() {
        StringBuilder sb = new StringBuilder();
        for (CssRule rule: this.rules) {
            sb.append(rule.getCSS()).append("\n");
            sb.append("\n");
        }
        return sb.toString();
    }

}
