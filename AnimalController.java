public class AnimalController {
  // Entry Point Method
  public static void main(String[] args) {
    Animal shark = new Animal("Shark", "human", "ocean", 10);
    Animal walrus = new Animal("Walrus", "fish", "ocean", 7);

    walrus.battle(shark, "belly flop");
    System.out.println(shark.getHealth());
  }
}