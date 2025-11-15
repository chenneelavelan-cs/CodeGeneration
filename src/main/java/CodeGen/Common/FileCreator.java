package CodeGeneration.src.main.java.CodeGen.Common;

import java.nio.file.Files;
import java.nio.file.Path;

import CodeGeneration.src.main.java.CodeGen.Environment;

public class FileCreator {


    public static boolean createFile(String fileName, String content) {
        try {
            Files.writeString(Path.of(Environment.OUTPUT_DIRECTORY + fileName), content);
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean createFile(CodeGenFile file) {
        return createFile(file.getFileName() + "." + file.getFileExtension(), file.getFileContent());
    }
}
