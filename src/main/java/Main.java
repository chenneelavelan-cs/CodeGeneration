package CodeGeneration.src.main.java;

import CodeGeneration.src.main.java.CodeGen.Common.FileCreator;
import CodeGeneration.src.main.java.CodeGen.Css.CssFile;
import CodeGeneration.src.main.java.CodeGen.Css.CssRule;
import CodeGeneration.src.main.java.CodeGen.Html.HtmlElement;
import CodeGeneration.src.main.java.CodeGen.Html.HtmlFile;
import CodeGeneration.src.main.java.CodeGen.Js.Expression;
import CodeGeneration.src.main.java.CodeGen.Js.ExpressionStatement;
import CodeGeneration.src.main.java.CodeGen.Js.Function;
import CodeGeneration.src.main.java.CodeGen.Js.FunctionCallExpression;
import CodeGeneration.src.main.java.CodeGen.Js.LiteralExpression;
import CodeGeneration.src.main.java.CodeGen.Js.OperationExpression;
import CodeGeneration.src.main.java.CodeGen.Js.Parameter;
import CodeGeneration.src.main.java.CodeGen.Js.PropertyAccessExpression;
import CodeGeneration.src.main.java.CodeGen.Js.ScriptFile;
import CodeGeneration.src.main.java.CodeGen.Js.Variable;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello, Code Generation!");

        // plan to just code gen html files for now... 
        // later i will add css and js generation

        // i plan to create a HtmlElement class that will represent an html element
        // with methods to add attributes, children, and text content
        // using builder pattern for easy chaining

        // FileCreator class will have a static method to create a file using the given content and file name

        // HtmlElement class will have tag name, attributes map, list of children, and text content.

        // similar to how i have code generated for html, i now have to code generate for css and js files too.
        // i will create CssElement and JsElement classes similar to HtmlElement
        // and add methods to generate css and js code respectively.
        // finally, i will use FileCreator to create the files.

        // design for styles.css
        // <ruleName> {
        //     <property>: <value>;
        // }

        // design for script.js
        // variables and functions can be created.
        // variables can be of type var, let, const
        // functions can be created using function keyword

        // variable design
        // <declarationType> <variableName> = <value>;

        // param design
        // <parameterType> <parameterName>
        // optional parameter with default value
        // <parameterType> <parameterName> = <defaultValue>

        // optional parameter without default value
        // [<parameterType> <parameterName>]

        // function design
        // can have variable declarations and function calls
        // paramaters: List<Parameter>
        // body: List<JsRenderable>
        // function <functionName>(<parameters>) {
        //     loop through body and render each statement
        // }

        // expression design
        // expressions can be either property access or function calls
        // propertyAccess design
        // <object>.<property>;
        // expression statement -> expression followed by a semicolon
        // <expression>;

        // function call expression
        // <functionName>(<arguments>);

        // literal expression
        // <value>

        // operational expression
        // <leftExpression> <operator> <rightExpression>

        // functionCall design
        // <functionName>(<arguments>);

        // functionbody design

        // plan 2.0;
        // this is a code generation library, this will just take an json as input and create the files accordingly.
        // later i can create a gui to take input from user and generate files accordingly.
        // for now, i will hardcode the input and generate the files.

        // json input design
        // json -> {
        //     "html": htmlFileObject,
        //     "css": cssFileObject,
        //     "js": jsFileObject
        // }

        // htmlFileObject -> {
        //     "fileName": "index",
        //     "title": "My Generated HTML",
        //     "elements": {id: HtmlElementObject}.. each element will have unique id
        //    "linkedCssFiles": [cssFileObject]..
        //     "linkedJsFiles": [jsFileObject]..
        // }

        // cssFileObject -> {
        //     "fileName": "styles",
        //     "rules": [CssRuleObject]..
        // }

        // jsFileObject -> {
        //     "fileName": "script",
        //     "statements": [JsRenderableObject]..
        // }

        // htmlElementObject -> {
        //     "tagName": "div",
        //     "attributes": {key: value}..,
        //     "children": [HtmlElementObject]..,
        //     "textContent": "Hello World"
        // }

        // cssRuleObject -> {
        //     "ruleName": ".my-class",
        //     "properties": {key: value}..
        // }

        // jsRenderableObject -> can be either Variable, Function, ExpressionStatement
        // variableObject -> {
        //     "declarationType": "const",
        //     "variableName": "myVar",
        //     "value": expressionObject
        // }

        // functionObject -> {
        //     "functionName": "myFunction",
        //     "parameters": [parameterObject]..,
        //     "body": [jsRenderableObject]..
        // }

        // parameterObject -> {
        //     "parameterName": "param1",
        //     "parameterType": "string",
        //     "defaultValue": "default" (optional)
        // }

        // expressionObject -> can be either PropertyAccessExpression, FunctionCallExpression, LiteralExpression, OperationExpression
        // propertyAccessExpressionObject -> {
        //     "object": "myObject",
        //     "property": "myProperty"
        // }

        // functionCallExpressionObject -> {
        //     "functionName": "myFunction",
        //     "arguments": [expressionObject]..
        // }

        // literalExpressionObject -> {
        //     "value": "myValue"
        // }

        // operationExpressionObject -> {
        //     "leftExpression": expressionObject,
        //     "operator": "+",
        //     "rightExpression": expressionObject
        // }

        // now, i will create a factory class to create these objects from json input.
        // for now, i will hardcode the input and generate the files.

        // reading the json input and setting state of the objects accordingly using state pattern.
        // for html, css, and js files i will create separate factory classes.
        // HtmlFileFactory, CssFileFactory, JsFileFactory
        // each factory class will have a static method to create the respective file object from json input.
        // HtmlFileFactory.createFromJson(jsonObject)
        // CssFileFactory.createFromJson(jsonObject)
        // JsFileFactory.createFromJson(jsonObject)

        // flow.. reads the json input -> initializes state -> calls respective factory classes to create file objects -> uses FileCreator to create files.
        // CodeGenEngine.processJsonInput(jsonInput)
        // inside processJsonInput -> calls HtmlFileFactory, CssFileFactory, JsFileFactory -> uses FileCreator to create files.

        // should codegen engine be singleton?
        // yes, because we only need one instance of it to process the json input and generate

        // what if we want to generate multiple things reading multiple json inputs?
        // in that case, we can create multiple instances of CodeGenEngine.
        // so, no need to make it singleton for now.

        // should i need to create state pattern for this?
        // i wont be modifying the state of the objects after creation.
        // so, no need to create state pattern for now.
        // if needed later, can be added.

        // CodeGenEngine codeGenEngine = new CodeGenEngine();
        // codeGenEngine.processJsonInput(jsonInput);

        // codeGen will take json input and generate files accordingly.
        // codeGen engine will go through each css files in the json input and create CssFile objects using CssFileFactory.
        // similarly for html and js files.

        // should the codeGenengine loop through the json input or should the factory classes do that?
        // codeGen engine should loop through the json input and call respective factory classes to create file objects.
        // factory classes should only be responsible for creating file objects from json input.

        // CodeGenEngine will have methods to process html, css, and js files separately.
        // codeGenEngine will have json input as its state.
        // CodeGenEngine.processHtmlFiles()
        // CodeGenEngine.processCssFiles()
        // CodeGenEngine.processJsFiles()
        // they will be reading the json input and calling respective factory classes to create file objects.
        // processJsonInput will call these methods one by one.
        // first css, then js, then html.

        // but wait, html files can link to css and js files.
        // so, we need to process css and js files first before html files.
        // how should i convey to HtmlFileFactory about the created css and js files?
        // i can pass the created css and js files as parameters to HtmlFileFactory.
        // HtmlFileFactory.createFromJson(jsonObject, List<CssFile> createdCssFiles, List<JsFile> createdJsFiles)
        // this way, HtmlFileFactory can link the css and js files to the html file
        // createdCssFiles and createdJsFiles can be stored in the state of CodeGenEngine
        // and passed to HtmlFileFactory when needed. they will be a map of id to file object for easy access.
        // Map<String, CssFile> createdCssFiles;
        // Map<String, JsFile> createdJsFiles;
        // Map<String, HtmlFile> createdHtmlFiles;
        // these maps will be populated when processing the respective files.

        // is this correct approach?
        // whats the alternative approach?
        // alternative approach is to create all files first without linking and then link them later.
        // but that will be more complex and will require multiple passes through the json input.
        // so, current approach is better.

        // should i store in the state itself instead of new maps? like {html: {id: fileObject}.., css: {id: fileObject}.., js: {id: fileObject}..}
        // should i store in the fileObject itself?
        // like styleObject will have another key like fileObject: its created CssFile object.
        // that way, i can avoid multiple maps in the state.
        // yes, that will be better approach.

        // what should codeGen engine take as input?
        // should it take json string or json object or file path?
        // for now, i will make it take json string as input.

        // json string is not good for large inputs.
        // i am thinking it should take file as input.
        // then inside codeGen engine i will use jackson or gson to parse the file into json object.
        // that way, user can provide large json input as file.

        // now for nows!!!, i want to do this in the best scalable way.
        // so, i will make codeGen engine take file path as input.

        // which is better? file path or file object?
        // file path is better, xbecause user can provide file path as string.

        // but this violates single responsibility principle.
        // codeGen engine should not be responsible for reading file from disk.
        
        // should i have another class like codeGen which takes file as input and creates state object then and passes to codeGen engine?
        // yes, that will be better approach.
        // CodeGen class will have method processFile(filePath)
        // inside processFile, it will read the file and create json object
        // then create state object and pass to codeGen engine.
        // CodeGenEngine codeGenEngine = new CodeGenEngine(state);
        // codeGenEngine.generateFiles();
        // this way, codeGen engine will only be responsible for generating files from state object.
        // CodeGen class will be responsible for reading file and creating state object.

        // should codeGen class take file path as input or file object?
        // file path is better, because user can provide file path as string.
        // why file object is not good?
        // file object is not good, because user has to create file object first.
        // but its his responsibility to provide the correct file right


       
        Expression getButtonExpr = new FunctionCallExpression(
            new PropertyAccessExpression(
                new LiteralExpression("document"),
                "getElementById"
            ),
            new LiteralExpression("\"myButton\"")
        );

        // const buttonEl = document.getElementById("myButton");
        Variable buttonEl = new Variable("const", "buttonEl", getButtonExpr);

        // let clickCount = 0;
        Variable clickCountVar = new Variable("let", "clickCount", new LiteralExpression("0"));

        OperationExpression buttonInitialTextContentValue = new OperationExpression( // buttonEl.innerText = `Clicked ${clickCount} times`;
            new LiteralExpression("buttonEl").dot("innerText"),
            "=",
            new LiteralExpression("`Clicked ${clickCount} times`")
        );

        // function buttonClick(e) { console.log("clicked on button: ", e); }
        Function buttonClick = new Function("buttonClick")
            .addParameter(new Parameter("e", null))
            .addBodyStatement(new ExpressionStatement( // clickCount += 1;
                new OperationExpression(
                    new LiteralExpression("clickCount"), 
                    "+=", 
                    new LiteralExpression("1")
                )
            ))
            .addBodyStatement(new ExpressionStatement( // console.log("clicked on button: ", e);
                new FunctionCallExpression(
                    new LiteralExpression("console").dot("log"),
                    new LiteralExpression("\"clicked on button: \""),
                    new LiteralExpression("e")
                )
            ))
            .addBodyStatement(new ExpressionStatement( // console.log("Click count: ", clickCount);
                new FunctionCallExpression(
                    new LiteralExpression("console").dot("log"),
                    new LiteralExpression("\"Click count: \""),
                    new LiteralExpression("clickCount")
                )
            ))
            .addBodyStatement(new ExpressionStatement( // buttonEl.innerText = `Clicked ${clickCount} times`;
                new OperationExpression(
                    new LiteralExpression("buttonEl").dot("innerText"),
                    "=",
                    new LiteralExpression("`Clicked ${clickCount} times`")
                )
            ));

        // buttonEl.addEventListener("click", buttonClick);
        Expression addListenerExpr = new FunctionCallExpression(
            new LiteralExpression("buttonEl").dot("addEventListener"),
            new LiteralExpression("\"click\""),
            new LiteralExpression("buttonClick")
        );

        ExpressionStatement eventBinding = new ExpressionStatement(addListenerExpr);

        ScriptFile scriptFile = new ScriptFile("script")
            .addStatement(buttonEl)
            .addStatement(clickCountVar)
            .addStatement(buttonInitialTextContentValue)
            .addStatement(buttonClick)
            .addStatement(eventBinding);

        boolean isScriptFileCreationSuccessful = FileCreator.createFile(scriptFile);
        if (isScriptFileCreationSuccessful) {
            System.out.println(scriptFile.getFileName() + " File Created Successfully");
        }
        else {
            System.out.println(scriptFile.getFileName() + " File Creation failed");
        }

        System.out.println("\n Generated JS File Content:\n");
        System.out.println(scriptFile.getFileContent());

        CssRule myClass = new CssRule(".my-div")
                        .addProperty("border", "1px solid black")
                        .addProperty("padding", "12px")
                        .addProperty("font-size", "20px")
                        .addProperty("display", "flex")
                        .addProperty("flex-direction", "column")
                        .addProperty("gap", "12px");

        CssRule myButton = new CssRule(".my-button")
                        .addProperty("background-color", "#4CAF50")
                        .addProperty("color", "white")
                        .addProperty("padding", "10px 20px")
                        .addProperty("border", "none")
                        .addProperty("border-radius", "4px")
                        .addProperty("cursor", "pointer");

        CssRule hoverEffect = new CssRule(".my-button:hover")
                        .addProperty("background-color", "#45a049");
        
        CssFile cssFile = new CssFile("styles")
                        .addRule(myClass)
                        .addRule(myButton)
                        .addRule(hoverEffect);

        String cssOut = cssFile.getFileContent();
        System.out.println("\n Generated CSS File Content:\n");
        System.out.println(cssOut);

        boolean isCssFileCreationSuccessfull = FileCreator.createFile(cssFile);
        if (isCssFileCreationSuccessfull) {
            System.out.println(cssFile.getFileName() + " File Created Successfully");
        }
        else {
            System.out.println(cssFile.getFileName() + " File Creation failed");
        }

        HtmlElement myDiv = new HtmlElement("div")
                        .addAttribute("class", "my-div")
                        .addChildren(new HtmlElement("p")
                            .setTextContent("Hello New World"))
                        .addChildren(new HtmlElement("button").
                            setTextContent("Click Me")
                            .addAttribute("class", "my-button")
                            .addAttribute("id", "myButton"));

        HtmlFile htmlFile = new HtmlFile("index", "My Generated HTML")
                        .addElement(myDiv)
                        .linkCssFile(cssFile)
                        .linkScriptFile(scriptFile);

        System.out.println("\n Generated HTML File Content:\n");
        System.out.println(htmlFile.getFileContent());

        boolean isFileCreationSuccessfull = FileCreator.createFile(htmlFile);
        if (isFileCreationSuccessfull) {
            System.out.println(htmlFile.getFileName() + " File Created Successfully");
        }
        else {
            System.out.println(htmlFile.getFileName() + " File Creation failed");
        }
    }
}
