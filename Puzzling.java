import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Puzzling {
  public static void main(String[] args) {
    // Instantiate Random Object
    Random r = new Random();
    // Instantiate ArrayList Object
    ArrayList<Character> alphabet = new ArrayList<Character>();
    // Add Characters To Alphabet using for loop
    for (char ch = 'a'; ch <= 'z'; ++ch) {
      alphabet.add(ch);
    }
    int randomNumber = r.nextInt(25);
    System.out.println(alphabet);
    // Use Collcetions SuperClass method of Shuffle to shuffle array
    Collections.shuffle(alphabet);
    System.out.println(alphabet);
    // Get Random Letter from Alphabet ArrayList
    System.out.println(randomNumber);
    System.out.println(alphabet.get(randomNumber));
  }
}