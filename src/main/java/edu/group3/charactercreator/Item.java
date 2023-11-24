public abstract class Item {
  private String name;
  private String description;
  private int weight;
  private int cost;
  private String currencyType;

  public Item(String name, String description, int weight, int cost, String currencyType) {
    this.name = name;
    this.description = description;
    this.weight = weight;
    this.cost = cost;
    this.currencyType = currencyType;
  }

  public Item() {
    this("ItemName",
        "ItemDesc",
        5,
        5,
        "cp");
  }

  public String getName() {
    return this.name;
  }

  public String getDesc() {
    return this.description;
  }

  public int getWeight() {
    return this.weight;
  }

  public int getCost() {
    return this.cost;
  }

  public String getCurrencyType() {
    return this.currencyType;
  }

  public String toString() {
    String output = "Name: " + this.getName() + "\n";
    output += "Description: " + this.getDesc() + "\n";
    output += "Weight: " + this.getWeight() + "\n";
    output += "Cost: " + this.getCost() + "\n";
    output += "Currency Type: " + this.getCurrencyType() + "\n";
    return output;
  }

}

class Armor extends Item {
  public enum ArmorType {
    NONE,
    LIGHT,
    MEDIUM,
    HEAVY
  };

  private int ac;
  private ArmorType armorType;
  private boolean stealthDisadvantage;

  public Armor(String name,
      String description,
      int weight,
      int cost,
      String currencyType,
      int ac,
      ArmorType armorType,
      boolean stealth) {
    super(name, description, weight, cost, currencyType);
    this.ac = ac;
    this.armorType = armorType;
    this.stealthDisadvantage = stealth;
  }

  public Armor() {
    this("ArmorName",
        "ArmorDesc",
        20,
        10,
        "sp",
        13,
        ArmorType.NONE,
        false);
  }

  public int getAC() {
    return this.ac;
  }

  public ArmorType getArmorType() {
    return this.armorType;
  }

  public boolean hasStealthDisadvantage() {
    return this.stealthDisadvantage;
  }

  public String toString() {
    String output = "==========Armor==========\n";
    output += super.toString();
    output += "AC: " + this.ac + "\n";
    output += "Armor Type: " + this.armorType + "\n";
    output += "Stealth Disavatage: " + this.stealthDisadvantage + "\n";
    output += "=========================";
    return output;
  }
}

class Weapon extends Item {
  public enum WeaponType {
    SIMPLE_MELEE,
    SIMPLE_RANGE,
    MARTIAL_MELEE,
    MARTIAL_RANGE,
  }

  public enum AttackType {
    BLUDGEONING,
    PIERCING,
    SLASHING,
  }

  private int[] damage; // 0: number of dice, 1: Sides of dice
  private WeaponType weaponType;
  private AttackType attackType;
  private String properties;

  public Weapon(String name,
      String description,
      int weight,
      int cost,
      String currencyType,
      int[] damage,
      WeaponType weaponType,
      AttackType attackType,
      String properties) {
    super(name, description, weight, cost, currencyType);
    this.damage = damage;
    this.weaponType = weaponType;
    this.attackType = attackType;
    this.properties = properties;
  }

  public Weapon() {
    this("WeaponName",
        "WeaponDesc",
        10,
        50,
        "gp",
        new int[] { 1, 8 },
        WeaponType.SIMPLE_MELEE,
        AttackType.SLASHING,
        "WeaponProps");
  }

  public String damageString() {
    return this.damage[0] + "d" + this.damage[1];
  }

  public WeaponType getWeaponType() {
    return this.weaponType;
  }

  public AttackType getAttackType() {
    return this.attackType;
  }

  public String getProperties() {
    return this.properties;
  }

  public String toString() {
    String output = "==========Weapon==========\n";
    output += super.toString();
    output += "Damage: " + this.damageString() + "\n";
    output += "Weapon Type: " + this.weaponType + "\n";
    output += "Attack Type: " + this.attackType + "\n";
    output += "Properties: " + this.properties + "\n";
    output += "==========================";
    return output;
  }
}

class Misc extends Item {
  public Misc(String name, String description, int weight, int cost, String currencyType) {
    super(name, description, weight, cost, currencyType);
  }

  public Misc() {
    super(
        "MiscName",
        "MiscDesc",
        5,
        5,
        "cp");
  }

  public String toString() {
    String output = "==========Misc==========\n";
    output += super.toString();
    output += "========================";
    return output;
  }
}
