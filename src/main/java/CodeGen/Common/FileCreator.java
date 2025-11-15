package CodeGen.Common;

import java.nio.file.Files;
import java.nio.file.Path;

import CodeGen.Environment;


public class FileCreator {

    private static boolean createFile(String fileName, String content, String directory) {
        try {
            Files.createDirectories(Path.of(Environment.OUTPUT_DIRECTORY + directory));
            Files.writeString(Path.of(Environment.OUTPUT_DIRECTORY + directory + "/" + fileName), content);
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean createFile(CodeGenFile file, String directory) {
        return createFile(file.getFileName() + "." + file.getFileExtension(), file.getFileContent(), directory);
    }
}
