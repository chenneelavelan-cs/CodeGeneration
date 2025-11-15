# AST-Based Code Generation Platform

## Overview

This project implements a sophisticated **Abstract Syntax Tree (AST) based code generation platform** that transforms JSON specifications into fully functional web applications. The system generates HTML, CSS, and JavaScript files from structured JSON input, enabling rapid prototyping and automated code creation.

## 🏗️ System Architecture

### Input Flow Pipeline

```
JSON AST File → CodeGenerator → ModelConverter → File Objects → FileCreator → Generated Files
```

1. **JSON AST Input**: Structured JSON containing complete application specification
2. **Deserialization**: Jackson ObjectMapper parses JSON into strongly-typed model objects
3. **Model Conversion**: Factory pattern converts model data into file generation objects
4. **File Generation**: Builder pattern creates final HTML, CSS, and JS files
5. **File Output**: FileCreator writes generated content to disk

## 📊 Data Model Architecture

### Core AST Structure

```java
CodeGenAST {
    Map<String, HtmlModelData> htmlFiles
    Map<String, CssModelData> cssFiles
    Map<String, JsModelData> jsFiles
    String htmlRootId
    String outputDirectory
}
```

### HTML Model Structure

```java
HtmlModelData {
    String fileName
    String title
    Map<String, HtmlElementData> elements
    List<String> cssFiles    // References to CSS file IDs
    List<String> jsFiles     // References to JS file IDs
}

HtmlElementData {
    String tagName
    Map<String, String> attributes
    List<String> children    // IDs of child elements
    String textContent
}
```

**Example HTML Structure:**
```json
{
    "fileName": "index",
    "title": "My App",
    "elements": {
        "root": {
            "tagName": "div",
            "attributes": {"class": "container"},
            "children": ["header", "main", "footer"]
        }
    }
}
```

### CSS Model Structure

```java
CssModelData {
    String fileName
    List<CssRuleData> rules
}

CssRuleData {
    String selector
    Map<String, String> properties
}
```

**Example CSS Structure:**
```json
{
    "fileName": "styles",
    "rules": [
        {
            "selector": ".container",
            "properties": {
                "max-width": "1200px",
                "margin": "0 auto"
            }
        }
    ]
}
```

### JavaScript Model Structure

```java
JsModelData {
    String fileName
    List<JsStatementData> statements
}
```

#### Polymorphic JavaScript Statements

The system supports multiple JavaScript statement types using **polymorphic deserialization**:

##### 1. Variable Declarations
```java
VariableDeclarationData extends JsStatementData {
    String declarationType  // "const", "let", "var"
    String variableName
    ExpressionData value
}
```

##### 2. Function Declarations
```java
FunctionDeclarationData extends JsStatementData {
    String functionName
    List<String> parameters
    List<JsStatementData> bodyStatements
}
```

##### 3. Expression Statements
```java
ExpressionStatementData extends JsStatementData {
    ExpressionData expression
}
```

#### Polymorphic Expression Types

##### 1. Literal Expressions
```java
LiteralExpressionData extends ExpressionData {
    String value  // "hello", "123", "true"
}
```

##### 2. Property Access
```java
PropertyAccessExpressionData extends ExpressionData {
    ExpressionData object
    String property
}
```

##### 3. Function Calls
```java
FunctionCallExpressionData extends ExpressionData {
    ExpressionData functionName
    List<ExpressionData> arguments
}
```

##### 4. Operations
```java
OperationExpressionData extends ExpressionData {
    ExpressionData leftOperand
    String operator  // "+", "=", "===", etc.
    ExpressionData rightOperand
}
```

## 🎯 Design Patterns Implementation

### 1. Factory Pattern
- **Purpose**: Create file objects from model data
- **Implementation**: `ModelConverter` class acts as a factory
- **Example**: `convertCssModel()`, `convertJsModel()`, `convertHtmlModel()`

### 2. Builder Pattern
- **Purpose**: Construct complex objects step-by-step
- **Implementation**: 
  - `HtmlElement.addAttribute().addChildren()`
  - `CssRule.addProperty()`
  - `Function.addParameter().addBodyStatement()`

### 3. Polymorphism with Jackson
- **Purpose**: Handle different statement and expression types
- **Implementation**: `@JsonTypeInfo` and `@JsonSubTypes` annotations
- **Benefit**: Automatic type resolution based on JSON "type" field

```java
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = VariableDeclarationData.class, name = "variableDeclaration"),
    @JsonSubTypes.Type(value = FunctionDeclarationData.class, name = "functionDeclaration")
})
public abstract class JsStatementData { ... }
```

### 4. Strategy Pattern
- **Purpose**: Different file creation strategies
- **Implementation**: Separate converters for HTML, CSS, JS
- **Benefit**: Easy extension for new file types

## 🗂️ Data Structures

### Maps
```java
Map<String, String> attributes           // Element attributes
Map<String, HtmlElementData> elements    // Element hierarchy
Map<String, String> properties          // CSS properties
```

### Lists
```java
List<String> children                    // Child element IDs
List<CssRuleData> rules                 // CSS rules
List<JsStatementData> statements        // JavaScript statements
List<ExpressionData> arguments          // Function arguments
```

### Trees
- **HTML Element Hierarchy**: Parent-child relationships via ID references
- **JavaScript AST**: Nested expressions and statements
- **File Dependencies**: CSS/JS file linking to HTML

## ⚡ Algorithms

### 1. Recursive HTML Tree Conversion
```java
private static HtmlElement convertHtmlElement(
    HtmlElementData elementData, 
    Map<String, HtmlElementData> allElements
) {
    HtmlElement element = new HtmlElement(elementData.getTagName());
    
    // Process children recursively
    for (String childId : elementData.getChildren()) {
        HtmlElement child = convertHtmlElement(
            allElements.get(childId), 
            allElements
        );
        element.addChildren(child);
    }
    
    return element;
}
```

### 2. Iterative Rule Processing
```java
for (CssRuleData ruleData : cssData.getRules()) {
    CssRule rule = new CssRule(ruleData.getSelector());
    for (Map.Entry<String, String> property : ruleData.getProperties().entrySet()) {
        rule.addProperty(property.getKey(), property.getValue());
    }
    cssFile.addRule(rule);
}
```

### 3. Polymorphic Statement Parsing
```java
private static JsRenderable convertJsStatement(JsStatementData statementData) {
    if (statementData instanceof VariableDeclarationData) {
        VariableDeclarationData varData = (VariableDeclarationData) statementData;
        return new Variable(varData.getDeclarationType(), 
                          varData.getVariableName(), 
                          convertExpression(varData.getValue()));
    }
    // ... handle other types
}
```

## 🛠️ Technologies

### Core Libraries
- **Jackson 2.15.2**: JSON parsing and polymorphic deserialization
  - `jackson-databind`: Core JSON processing
  - `jackson-dataformat-yaml`: YAML support (optional)

### Language Features
- **Java 21**: Latest LTS with modern syntax
- **Generics**: Type-safe collections
- **Annotations**: Jackson mapping configuration
- **Abstract Classes**: Polymorphic inheritance

## 📁 Package Structure

```
CodeGen/
├── Model/                    # Data models for AST
│   ├── ASTModel.java        # Root AST container
│   ├── CssModelData.java    # CSS file model
│   ├── HtmlModelData.java   # HTML file model
│   ├── JsModelData.java     # JavaScript file model
│   ├── Css/                 # CSS-specific models
│   ├── Html/                # HTML-specific models
│   └── Js/                  # JavaScript-specific models
│       ├── JsStatementData.java     # Abstract statement
│       ├── VariableDeclarationData.java
│       ├── FunctionDeclarationData.java
│       └── Expressions/     # Expression models
├── Engine/                  # Processing engine
│   ├── CodeGenerator.java   # Main entry point
│   └── ModelConverter.java  # Model-to-object converter
├── Common/                  # Shared utilities
│   └── FileCreator.java     # File I/O operations
├── Html/                    # HTML generation
├── Css/                     # CSS generation
└── Js/                      # JavaScript generation
```

## 🚀 Usage Example

### Basic Usage
```java
// Create generator instance
CodeGenerator generator = new CodeGenerator();

// Generate from JSON AST file
generator.generate("path/to/ast.json");
```

### Generated Output
The system creates:
- **HTML files**: Semantic markup with proper structure
- **CSS files**: Professional styling with responsive design
- **JavaScript files**: Modern ES6+ with event handling

### Sample JSON Input
```json
{
    "css": {
        "main-styles": {
            "fileName": "main",
            "rules": [
                {
                    "selector": "body",
                    "properties": {
                        "font-family": "Arial, sans-serif",
                        "margin": "0"
                    }
                }
            ]
        }
    },
    "js": {
        "app-script": {
            "fileName": "app",
            "statements": [
                {
                    "type": "variableDeclaration",
                    "declarationType": "const",
                    "variableName": "message",
                    "value": {
                        "type": "literal",
                        "value": "'Hello World'"
                    }
                }
            ]
        }
    },
    "html": {
        "main-page": {
            "fileName": "index",
            "title": "Generated App",
            "elements": {
                "root": {
                    "tagName": "div",
                    "attributes": {"class": "app"},
                    "children": []
                }
            },
            "cssFiles": ["main-styles"],
            "jsFiles": ["app-script"]
        }
    },
    "htmlRootId": "root"
}
```

## 🎯 Key Benefits

1. **Type Safety**: Strong typing throughout the generation pipeline
2. **Extensibility**: Easy to add new statement types and expressions
3. **Separation of Concerns**: Clear distinction between models, conversion, and generation
4. **Maintainability**: Well-structured codebase with design patterns
5. **Scalability**: Handles complex, nested structures efficiently
6. **Modern Standards**: Generates contemporary web code

## 🔮 Future Enhancements

- **TypeScript Support**: Generate TypeScript instead of JavaScript
- **Framework Integration**: React, Vue, Angular component generation
- **CSS Preprocessors**: SASS, LESS support
- **Validation**: JSON schema validation for input
- **CLI Interface**: Command-line tool for batch processing
- **Visual Editor**: GUI for creating AST structures
- **Template System**: Reusable component templates

---

This documentation provides a comprehensive overview of the AST-based code generation platform, covering architecture, implementation details, and usage patterns for effective development and maintenance.