public interface Attackable {
  int getHealth();

  void takeDamage(int damageAmount);

  void setHealth(int health);
}