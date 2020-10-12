import java.util.ArrayList;

public class ZooController {
  public static void main(String[] args) {
    Mammal dog = new Mammal("dog", 100);
    Gorilla magilla = new Gorilla();
    Barrel barrel = new Barrel();

    ArrayList<Mammal> animals = new ArrayList<Mammal>();
    animals.add(dog);
    animals.add(magilla);

    // for (Mammal m : animals) {
    // System.out.println(m.getSpecies());
    // }

    magilla.battle(barrel);
    magilla.eatBanana();
    System.out.println(magilla.getHealth());
  }
}