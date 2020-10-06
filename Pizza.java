import java.util.Arrays;

public class Pizza {
  // Attributes A Pizza Has
  private String[] toppings;
  private char size;
  private double price;
  private String crustType;
  private int slices;

  // Constructor
  public Pizza(String[] toppings, char size, double price, String crustType) {
    this.toppings = toppings;
    this.size = size;
    this.price = price;
    this.crustType = crustType;
    this.slices = 8;
  }

  // Overloaded Method
  public Pizza(String[] toppings, char size, String crustType) {
    this.price = 14.99;
    this.toppings = toppings;
    this.size = size;
    this.crustType = crustType;
    this.slices = 10;
  }

  // Getters And Setters.
  public String[] getToppings() {
    return this.toppings;
  }

  public char getSize() {
    return this.size;
  }

  public double getPrice() {
    return this.price;
  }

  public String getCrustType() {
    return this.crustType;
  }

  public int getSlices() {
    return this.slices;
  }

  // Setters
  public void setToppings(String[] toppings) {
    this.toppings = toppings;
  }

  public void setSize(char size) {
    this.size = size;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  // The point of having private properties and using public getters and setters
  // to access them is being able to add an extra layer of security to what the
  // user is allowed to do. Here we would deny a user from being able to set the
  // sauce to blank. Essentially making it a required field
  public void setCrustType(String crustType) {
    if (crustType.equals("")) {
      return;
    }
    this.crustType = crustType;
  }

  public void setSlices(int slices) {
    this.slices = slices;
  }

  public void displayPizza() {
    System.out.println(
        "This is a size: " + this.size + " pizza with " + Arrays.toString(this.toppings) + " for " + this.price);
  }

  // Method where we mess with objects attributes
  public int eatSlice(int slices) {
    if (slices > this.slices) {
      System.out.println("Pizza's all gone");
      return 0;
    }
    System.out.println("You have eaten" + slices + " of " + Arrays.toString(this.toppings) + " pizza");
    this.slices -= slices;
    return this.slices;
  }

  // eat a slice with method overloading. Java will know which method to use based
  // on the number of parameters that are input.
  public int eatSlice() {
    System.out.println("You ate one slice of pizza");
    this.slices -= 1;
    return this.slices;
  }

  // Example on how an object can interact with another object. By importing
  // "otherPizza" into here, we now have access to all the otherObject's
  // attributes and can modify them as we please
  public void pizzaFight(Pizza otherPizza) {
    otherPizza.setSlices(otherPizza.getSlices() - 1);
    System.out.println(
        Arrays.toString(this.toppings) + " pizza just cut 1 slice from " + Arrays.toString(otherPizza.toppings));
    System.out.println("Other pizza now has " + otherPizza.getSlices());
  }

  public static void advertise() {
    System.out.println("Hey you.... come check out these pizzas");
  }
}