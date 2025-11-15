package CodeGen.Engine;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import CodeGen.Model.CodeGenASTModel;

public class CodeGenerator {
    private final ObjectMapper mapper;
    
    public CodeGenerator() {
        this.mapper = new ObjectMapper();

        // Configure mapper to ignore unknown properties for better AST handling.
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    
    public void generate(String astFilePath) throws IOException {
        File astFile = new File(astFilePath);
        CodeGenASTModel ast = mapper.readValue(astFile, CodeGenASTModel.class);
        CodeGenEngine.generateCode(ast);
    }
    
    public void generate(File astFile) throws IOException {
        CodeGenASTModel ast = mapper.readValue(astFile, CodeGenASTModel.class);
        CodeGenEngine.generateCode(ast);
    }
}