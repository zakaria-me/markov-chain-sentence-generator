import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    // make sourceText into a list
    String[] arrayOfSourceText = sourceText.split(" ");
    List<String> array = Arrays.asList(arrayOfSourceText);
    // chose a random word
    int randomIndex = (int) (Math.random() * 100.0);
    String randomWord = array.get(randomIndex);
    // find bigrams matching the randomWord
    ArrayList<String> bigrams = new ArrayList<String>();
    ArrayList<String> copyOfArray = new ArrayList<String>(array);
    while (copyOfArray.contains(randomWord)) {
      int closestIndex = copyOfArray.indexOf(randomWord);
      if (copyOfArray.get(closestIndex + 1) != null && closestIndex != -1 && copyOfArray.get(closestIndex + 1) != "\n"
          && !bigrams.contains(copyOfArray.get(closestIndex + 1))) {
        bigrams.add(copyOfArray.get(closestIndex + 1));
      }
      copyOfArray.remove(closestIndex);
    }
  }

  public static void display(String randomWord, ArrayList<String> bigrams) {
    System.out.println(randomWord);
    for (int index = 0; index < bigrams.size(); index++) {
      System.out.print(index + " " + bigrams.get(index) + " ");
    }
  }
}