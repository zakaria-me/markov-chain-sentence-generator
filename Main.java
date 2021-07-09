import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static String readFile(String filePath) {
    byte[] encodedContent;
    try {
      encodedContent = Files.readAllBytes(Paths.get(filePath));
      return new String(encodedContent);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    String filePath = "source-text.txt";
    String sourceText = readFile(filePath);
  }
}