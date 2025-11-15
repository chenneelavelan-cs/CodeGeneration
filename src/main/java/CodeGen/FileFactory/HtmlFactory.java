package CodeGen.FileFactory;

import java.util.Map;

import CodeGen.Html.HtmlElement;
import CodeGen.Html.HtmlFile;
import CodeGen.Model.Html.HtmlElementData;
import CodeGen.Model.Html.HtmlModelData;

public class HtmlFactory extends CodeGenFileFactory<HtmlModelData, HtmlFile> {

    @Override
    public HtmlFile createCodeGenFile(HtmlModelData htmlData) {
        
        HtmlFile htmlFile = new HtmlFile(htmlData.getFileName(), htmlData.getTitle() != null ? htmlData.getTitle() : "Generated HTML");
        String rootElementId = htmlData.getRootElementId();

        if (htmlData.getElements() != null && rootElementId != null) {

            // adds root element and its children to HTML file recursively.
            HtmlElement rootElement = convertHtmlElement(htmlData.getElements().get(rootElementId), htmlData.getElements());
            if (rootElement != null) {
                htmlFile.addElement(rootElement);
            }
        }
        
        return htmlFile;
    }
    
    private HtmlElement convertHtmlElement(HtmlElementData elementData, Map<String, HtmlElementData> allElements) {
        if (elementData == null || elementData.getTagName() == null) { // Invalid element data
            return null;
        }
        
        HtmlElement element = new HtmlElement(elementData.getTagName()); // Create HtmlElement with tag name
        
        // Add attributes
        if (elementData.getAttributes() != null) {
            for (Map.Entry<String, String> attr : elementData.getAttributes().entrySet()) {
                element.addAttribute(attr.getKey(), attr.getValue());
            }
        }
        
        // Set text content
        if (elementData.getTextContent() != null) {
            element.setTextContent(elementData.getTextContent());
        }
        
        // Add children
        if (elementData.getChildren() != null) {
            for (String childId : elementData.getChildren()) {
                HtmlElement childElement = convertHtmlElement(allElements.get(childId), allElements);
                if (childElement != null) {
                    element.addChildren(childElement);
                }
            }
        }
        
        return element;
    }
    
}
