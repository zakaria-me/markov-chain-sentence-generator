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
    // Initialization
    String filePath = "source-text.txt";
    String sourceText = readFile(filePath);
    // make sourceText into a list
    String[] arrayOfSourceText = sourceText.split(" ");
    List<String> array = Arrays.asList(arrayOfSourceText);
    String sentenceGenerated = "";

    // The algorithm
    int randomIndex = 0;
    for (int loop = 0; loop < 11; loop++) {
      // chose a random word, the index is always between 0 and array.size()
      randomIndex = (int) ((Math.random() * 10000.0) % array.size());
      String randomWord = array.get(randomIndex);
      // add the word to the sentence
      sentenceGenerated += " " + randomWord;
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
      randomIndex = (int) ((Math.random() * 10000.0) % bigrams.size());
      sentenceGenerated += " " + bigrams.get(randomIndex);
    }
    System.out.println(sentenceGenerated);
  }

  public static void displayRandomWordAndBigramsAssociated(String randomWord, ArrayList<String> bigrams) {
    System.out.println(randomWord);
    for (int index = 0; index < bigrams.size(); index++) {
      System.out.print(index + " " + bigrams.get(index) + " ");
    }
  }
}