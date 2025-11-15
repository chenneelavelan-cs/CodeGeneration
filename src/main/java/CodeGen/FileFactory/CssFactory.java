package CodeGen.FileFactory;

import java.util.Map;

import CodeGen.Css.CssFile;
import CodeGen.Css.CssRule;
import CodeGen.Model.Css.CssModelData;
import CodeGen.Model.Css.CssRuleData;

public class CssFactory extends CodeGenFileFactory<CssModelData, CssFile> {

    @Override
    public CssFile createCodeGenFile(CssModelData cssData) {
        CssFile cssFile = new CssFile(cssData.getFileName());
        
        if (cssData.getRules() != null) {

            // Iterates through each CSS rule creates Rule objects and adds them to the CssFile
            for (CssRuleData ruleData : cssData.getRules()) {
                CssRule rule = new CssRule(ruleData.getSelector());
                
                if (ruleData.getProperties() != null) { // Iterates through each property and adds them to the CssRule
                    for (Map.Entry<String, String> property : ruleData.getProperties().entrySet()) {
                        rule.addProperty(property.getKey(), property.getValue());
                    }
                }
                
                cssFile.addRule(rule);
            }
        }
        
        return cssFile;
    }
    
}
