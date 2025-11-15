import CodeGen.Engine.CodeGenerator;
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


        // INPUT FLOW:

        // CodeGenAST
        // CodeGenerator codeGenerator = new CodeGenerator();
        // codeGenerator will take the file path of the json ast as input
        // the json will be of design CodeGenAST

        // reading from the file path, codeGenerator will parse the json into CodeGenAST object 
        // using object mapper from jackson library
        
        // each model in the AST has its own class in the CodeGen.Model package

        // after deserializing into CodeGenAST object
        // codeGenerator will go through each file object in the AST and create respective factory classes to create file objects
        // CssFileFactory, JsFileFactory, HtmlFileFactory.

        // finally, codeGenerator will use FileCreator to create the files on disk.


        // CodeGenAST will have these properties
        // List<HtmlModelData> htmlFiles
        // List<CssModelData> cssFiles
        // List<JsModelData> jsFiles

        // HtmlModelData will have properties like fileName, title, rootElementId, elements Map<String, HtmlElementData>
        // CssModelData will have properties like fileName, rules (list of CssRuleData)
        // JsModelData will have properties like fileName, statements (list of JsStatementData

        // HtmlModelData will have HtmlElementData which will represent each html element
        // CssModelData will have CssRuleData which will represent each css rule
        // JsModelData will have JsStatementData which will represent each js statement

        // JsStatementData will be abstract class with subclasses VariableDeclarationData, FunctionDeclarationData, ExpressionStatementData
        // JsStatementData has different types, so we need to use polymorphism here.
        // using jackson annotations to achieve polymorphic deserialization

        // JsStatementData for now can have only these 4 types
        // - VariableDeclarationData
        // - FunctionDeclarationData
        // - ExpressionStatementData
        // - ExpressionData

        // ExpressionData can be of different types too
        // - LiteralExpressionData
        // - OperationExpressionData
        // - FunctionCallExpressionData
        // - PropertyAccessExpressionData

        // using similar approach for ExpressionData as well using jackson annotations

        // Design Patterns Used:
        // - Factory Pattern for creating file objects from model data
        // - Builder Pattern for building HtmlElement, CssRule, JsStatement objects
        // - Polymorphism for JsStatementData and ExpressionData using jackson annotations
        // - Strategy Pattern for FileObject creations.

        // Data Structures Used:
        // - Maps for storing elements and attributes
        // - Lists for storing children elements, rules, statements
        // - Classes and Objects for representing different file types and their components
        // - Trees for representing hierarchical structure of HTML elements
        
        // Algorithms Used:
        // - Recursive algorithms for converting nested HTML elements from model data to HtmlElement objects
        // - Iterative algorithms for processing lists of CSS rules and JS statements
        // - Simple parsing algorithms for interpreting JSON input into model data objects

        // technologies Used:
        // - Jackson library for JSON parsing and polymorphic deserialization


        // // Test the MASSIVE AST file
        // System.out.println("\n=== Testing MASSIVE AST-based Code Generator ===");
        // try {
        //     CodeGenerator massiveCodeGenerator = new CodeGenerator();
        //     massiveCodeGenerator.generate("src/main/resources/MassiveAST.json");
        // } catch (Exception e) {
        //     System.out.println("Error generating code from Massive AST: " + e.getMessage());
        //     e.printStackTrace();
        // }

        // // Test the Colorful Fun Page
        // System.out.println("\n=== Testing COLORFUL FUN PAGE Code Generator ===");
        // try {
        //     CodeGenerator colorfulPageGenerator = new CodeGenerator();
        //     colorfulPageGenerator.generate("src/main/resources/ColorfulFunPage.json");
        // } catch (Exception e) {
        //     System.out.println("Error generating code from Colorful Fun Page AST: " + e.getMessage());
        //     e.printStackTrace();
        // }
        
    
        // Test the new AST-based code generator
        System.out.println("\n=== Testing AST-based Code Generator ===");
        try {
            CodeGenerator codeGenerator = new CodeGenerator();
            codeGenerator.generate("src/main/resources/SampleAST.json");
        } catch (Exception e) {
            System.out.println("Error generating code from AST: " + e.getMessage());
            e.printStackTrace();
        }

        // Test the Documentation Page
        System.out.println("\n=== Testing DOCUMENTATION PAGE Code Generator ===");
        try {
            CodeGenerator docPageGenerator = new CodeGenerator();
            docPageGenerator.generate("src/main/resources/DocumentationPage.json");
        } catch (Exception e) {
            System.out.println("Error generating code from Documentation Page AST: " + e.getMessage());
            e.printStackTrace();
        }

        // Test the Tic Tac Toe Game
        System.out.println("\n=== Testing TIC TAC TOE GAME Code Generator ===");
        try {
            CodeGenerator ticTacToeGenerator = new CodeGenerator();
            ticTacToeGenerator.generate("src/main/resources/TicTacToeGame.json");
        } catch (Exception e) {
            System.out.println("Error generating code from Tic Tac Toe Game AST: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
