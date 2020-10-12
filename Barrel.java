public class Barrel implements Attackable {
  private int health;
  private String name;

  public Barrel() {
    this.health = 10;
    this.name = "Barrel";
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void takeDamage(int damageAmount) {
    this.health -= damageAmount;
  }
}