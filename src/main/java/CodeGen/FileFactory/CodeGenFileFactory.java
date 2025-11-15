package CodeGen.FileFactory;

public abstract class CodeGenFileFactory<I, O> {
    public abstract O createCodeGenFile(I data);
}
