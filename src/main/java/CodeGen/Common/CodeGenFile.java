package CodeGeneration.src.main.java.CodeGen.Common;

public abstract class CodeGenFile {
    
    private String fileName;
    
    protected CodeGenFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public abstract String getFileContent();
    public abstract String getFileExtension();
}
