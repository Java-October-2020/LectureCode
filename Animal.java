public class Animal {
  private String species;
  private String diet;
  private String habitat;
  private int health;
  private int strength;

  // Constructor (Overloaded)
  public Animal() {

  }

  // Constructor
  public Animal(String species, String diet, String habitat, int strength) {
    this.species = species;
    this.diet = diet;
    this.habitat = habitat;
    this.health = 100;
    this.strength = strength;
  }

  public String getSpecies() {
    return this.species;
  }

  public String getDiet() {
    return this.diet;
  }

  public String getHabitat() {
    return this.habitat;
  }

  public int getHealth() {
    return this.health;
  }

  public int getStrength() {
    return this.strength;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public void setDiet(String diet) {
    this.diet = diet;
  }

  public void setHabitat(String habitat) {
    this.habitat = habitat;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  // Attacks another animal
  public void battle(Animal target, String powerMove) {
    // Define the logic of how animal attacks;
    int damage;
    if (powerMove.equals("bite")) {
      damage = 3;
    } else if (powerMove.equals("tusk hit")) {
      damage = 3;
    } else if (powerMove.equals("belly flop")) {
      damage = 5;
    } else {
      System.out.println("Move not recognized");
      return;
    }

    // Multiple the strength x damage
    int effectiveDamage = this.strength * damage;

    // Reduce the targets health by effectiveDamage
    target.health -= effectiveDamage;

    // print to the console what just happened using a formatted string.
    System.out.printf("%s attacks %s for %d points\n", this.species, target.species, effectiveDamage);
  }

  // attacks another animal, default damage amount
  public void battle(Animal target) {
    this.battle(target, "bite");
  }

}