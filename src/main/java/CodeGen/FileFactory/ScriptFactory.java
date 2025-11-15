package CodeGen.FileFactory;

import java.util.ArrayList;
import java.util.List;

import CodeGen.Js.Expression;
import CodeGen.Js.ExpressionStatement;
import CodeGen.Js.Function;
import CodeGen.Js.FunctionCallExpression;
import CodeGen.Js.JsRenderable;
import CodeGen.Js.LiteralExpression;
import CodeGen.Js.OperationExpression;
import CodeGen.Js.Parameter;
import CodeGen.Js.PropertyAccessExpression;
import CodeGen.Js.ScriptFile;
import CodeGen.Js.Variable;
import CodeGen.Model.Js.ExpressionStatementData;
import CodeGen.Model.Js.FunctionDeclarationData;
import CodeGen.Model.Js.JsModelData;
import CodeGen.Model.Js.JsStatementData;
import CodeGen.Model.Js.VariableDeclarationData;
import CodeGen.Model.Js.Expressions.ExpressionData;
import CodeGen.Model.Js.Expressions.FunctionCallExpressionData;
import CodeGen.Model.Js.Expressions.LiteralExpressionData;
import CodeGen.Model.Js.Expressions.OperationExpressionData;
import CodeGen.Model.Js.Expressions.PropertyAccessExpressionData;

public class ScriptFactory extends CodeGenFileFactory<JsModelData, ScriptFile> {

    @Override
    public ScriptFile createCodeGenFile(JsModelData jsData) {
        ScriptFile scriptFile = new ScriptFile(jsData.getFileName()); // Create ScriptFile with file name
        
        if (jsData.getStatements() != null) {
            for (JsStatementData statementData : jsData.getStatements()) { // Converts each JsStatementData to JsRenderable and add to ScriptFile
                JsRenderable statement = convertJsStatement(statementData);
                if (statement != null) {
                    scriptFile.addStatement(statement); // Adds statement to ScriptFile
                }
            }
        }
        
        return scriptFile;
    }

    public JsRenderable convertJsStatement(JsStatementData statementData) {

        // JSON Polymorphic Deserialization based on the type of JsStatementData
        // JsStatementData can be VariableDeclarationData, FunctionDeclarationData, or ExpressionStatementData  
        
        if (statementData instanceof VariableDeclarationData) { // Handles Variable Declaration
            VariableDeclarationData varData = (VariableDeclarationData) statementData;
            Expression value = convertExpression(varData.getValue());
            return new Variable(varData.getDeclarationType(), varData.getVariableName(), value); // Creates Variable statement
            
        } else if (statementData instanceof FunctionDeclarationData) { // Handles Function Declaration
            FunctionDeclarationData funcData = (FunctionDeclarationData) statementData;
            
            Function function = new Function(funcData.getFunctionName());
            
            // Add parameters
            if (funcData.getParameters() != null) {
                for (String paramName : funcData.getParameters()) {
                    function.addParameter(new Parameter(paramName));
                }
            }
            
            // Add body statements
            if (funcData.getBodyStatements() != null) {
                for (JsStatementData bodyStatement : funcData.getBodyStatements()) { // Recursively convert body statements
                    JsRenderable statement = convertJsStatement(bodyStatement);
                    if (statement != null) {
                        function.addBodyStatement(statement);
                    }
                }
            }
            
            return function; // Creates Function statement
            
        } else if (statementData instanceof ExpressionStatementData) { // Handles Expression Statement
            ExpressionStatementData exprData = (ExpressionStatementData) statementData;
            Expression expression = convertExpression(exprData.getExpression());
            return new ExpressionStatement(expression); // Creates ExpressionStatement
        }
        
        return null;
    }

    private Expression convertExpression(ExpressionData exprData) {
        if (exprData == null) { // Invalid expression data
            return null;
        }
        
        if (exprData instanceof LiteralExpressionData) { // Handles Literal Expression
            LiteralExpressionData literalData = (LiteralExpressionData) exprData;
            return new LiteralExpression(literalData.getValue()); // Creates LiteralExpression

        } else if (exprData instanceof OperationExpressionData) { // Handles Operation Expression
            OperationExpressionData opData = (OperationExpressionData) exprData;
            Expression left = convertExpression(opData.getLeftOperand());
            Expression right = convertExpression(opData.getRightOperand());
            return new OperationExpression(left, opData.getOperator(), right); // Creates OperationExpression

        } else if (exprData instanceof PropertyAccessExpressionData) { // Handles Property Access Expression
            PropertyAccessExpressionData propData = (PropertyAccessExpressionData) exprData;
            Expression object = convertExpression(propData.getObject());
            return new PropertyAccessExpression(object, propData.getProperty()); // Creates PropertyAccessExpression
            
        } else if (exprData instanceof FunctionCallExpressionData) { // Handles Function Call Expression
            FunctionCallExpressionData funcCallData = (FunctionCallExpressionData) exprData;
            Expression functionName = convertExpression(funcCallData.getFunctionName()); // Converts function name expression
            
            List<Expression> argumentsList = new ArrayList<>();
            if (funcCallData.getArguments() != null) {
                for (ExpressionData argData : funcCallData.getArguments()) { // Converts each argument expression
                    Expression arg = convertExpression(argData);
                    if (arg != null) {
                        argumentsList.add(arg);
                    }
                }
            }
            
            // Convert List to array for the constructor
            Expression[] arguments = argumentsList.toArray(new Expression[0]);
            return new FunctionCallExpression(functionName, arguments); // Creates FunctionCallExpression
            
        }
        
        return null;
    }
    
}
