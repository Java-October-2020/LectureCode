public class FirstProgram {
  // Entry Point Method
  public static void main(String[] args) {
    // Variables
    // Primitive
    byte myByte = 100; // Store whole numbers from -128 to 127
    short myShort = 1000; // Stores whole numbers from -32,768 to 32,767
    int myInt = 100000; // Stores whole numbers from -2,147,483,648 to 2,147,483,647
    long myLong = 10000000; // Stores whole numbers from -9,223,372,036,854,775,808 to
                            // 9,223,372,036,854,775,807

    float myFloat = 3.14f; // Stores fracitonal numbers. Sufficient for storing 6 to 7 decimal digits
    double myDouble = 3.142344d; // Stores fractional numbers up to 15 decimal digits

    boolean myBool = true; // Stores true or false
    char myChar = 'c';

    // Wrapper Class
    Integer myWrapperInt = 10000;
    Character myCharacter = 'd';

    // Strings
    String myString = "Java October 2020";

    String bootcamp = "Java";
    String bootCamp = "August";
    String bootCAMP = "2020";

    // Operators and Conditionals
    int isOdd = 5;
    if (isOdd % 2 != 0) {
      System.out.println("Number is Odd");
    } else {
      System.out.println("Number is not odd");
    }

    // String Equality
    String name = "Kevin";
    String name2 = "Kevin";

    // Loops
    // While
    int i2 = 0;
    while (i2 < 4) {
      System.out.println(i2);
      i2++;
    }

    // For Loops
    for (int i = 0; i < 4; i++) {
      System.out.println(i);
    }

  }

}