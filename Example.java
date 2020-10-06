import java.util.Arrays;

public class Example {
  public static void main(String[] args) {
    char letter = 'o';
    Integer a = getIndexOrNull("Coding", letter);
    Integer b = getIndexOrNull("Hello World", letter);
    Integer c = getIndexOrNull("Hi", letter);
    System.out.println(a); // 1
    System.out.println(b); // 4
    System.out.println(c);

    int[] myArray = new int[10];
    System.out.println(Arrays.toString(myArray));
  }

  public static Integer getIndexOrNull(String input, char c) {
    if (input.indexOf(c) != -1) {
      return input.indexOf(c);
    } else {
      return null;
    }

    // return input.indexOf(c) != -1 ? input.indexOf(c) : null;
  }
}