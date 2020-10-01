import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Day2 {
  public static void main(String[] args) {
    // == Two Primitives
    // == Two Strings is not going to have the right result

    String name = "Lance";
    String name2 = "Lance";

    String name3 = new String("Lance");
    String name4 = new String("Lance");

    // Arrays
    String[] people = { "Matthew", "Jaclynn", "Shanky", "Haftamu", "Kelly" };
    String[] people2 = new String[5];
    people[0] = "Matthew";
    people[1] = "Matthew";
    people[2] = "Matthew";
    people[3] = "Matthew";

    int[] numbers = new int[10];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i + 1;
    }

    System.out.println(Arrays.toString(numbers));
    // for (int num : numbers) {
    // System.out.println(num);
    // }

    Object[] myObjectArr = { 1, "hello", false };

    // Collections Class
    // ArrayList
    ArrayList<String> stringList = new ArrayList<String>();
    stringList.add("one");
    stringList.add("two");
    stringList.add("three");
    stringList.add("four");

    ArrayList<Object> objectList = new ArrayList<Object>();
    objectList.add("random string");
    objectList.add(1);
    objectList.add(stringList);

    // Hash Map
    HashMap<String, String> classHobbies = new HashMap<String, String>();
    classHobbies.put("Matthew", "Photography");
    classHobbies.put("Kelly", "Music");
    classHobbies.put("Shanky", "Travel");
    classHobbies.put("Terra", "Gardening");
    classHobbies.put("Jaclynn", "Jiu-Jitsu");
    classHobbies.put("DT", "Phone");
    classHobbies.put("Lance", "fishing");
    classHobbies.put("Devon", "WebFun");

    // Loop for getting keys
    // for (String hobbyName : classHobbies.keySet()) {
    // System.out.println(hobbyName);
    // }

    // // Loop for getting values
    // for (String hobbyName : classHobbies.values()) {
    // System.out.println(hobbyName);
    // }

    // Loop for getting values
    // for (HashMap.Entry<String, String> hobbies : classHobbies.entrySet()) {
    // System.out.println(hobbies);
    // }

    // Methods
    System.out.println(maxArrayValue(numbers));
    // maxArrayValue(numbers); -> maxArrayValue(numbers) = 10;
    sayHello();

    // Errors

  }

  public static void sayHello() {
    System.out.println("Hello!");
  }

  public static int maxArrayValue(int[] nums) {
    // For Loop
    // index 0 to be the max (variable for maximum)
    // compare all the values to the max value
    // if something is greater replace
    int maxValue = nums[0];
    for (int i = 0; i < nums.length; i++) {
      try {
        if (maxValue < nums[i]) {
          maxValue = nums[i];
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    return maxValue;
  }
}