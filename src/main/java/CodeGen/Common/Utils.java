package CodeGen.Common;

public class Utils {
    
    public static String generateIndentString(int indentCount, int times) {
        return " ".repeat(indentCount).repeat(times);
    }

    public static String generateIndentString(int indentCount) {
        return generateIndentString(indentCount, 1);
    }
}
