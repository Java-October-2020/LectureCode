public abstract class AbstractMammal {
  protected boolean milkProducing;
  protected boolean warmBlooded;
  protected boolean requireOxygen;
  protected String species;
  protected int strength;

  public void breathe() {
    System.out.println(this.species + " took a deep breath of air");
  }

  public void eat() {
    this.strength += 5;
  }

  public abstract void makesound();
}