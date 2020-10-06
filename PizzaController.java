import java.util.Arrays;

public class PizzaController {
  // Entry Point Method
  public static void main(String[] args) {
    // Creating an object that uses our first constructor
    Pizza meatLoversPizza = new Pizza(new String[] { "pepperoni", "cheese", "sasuage" }, 'L', 14.99, "deepdish");
    meatLoversPizza.displayPizza();
    meatLoversPizza.eatSlice(4);

    // Creating an object that uses our second constructor.
    Pizza cheesePizza = new Pizza(new String[] { "cheese" }, 'L', "thin crust");

    // Returning attribute of the cheesePizza object
    System.out.println(cheesePizza.getSlices());

    // Interacting with two pizza objects.
    meatLoversPizza.pizzaFight(cheesePizza);

  }
}