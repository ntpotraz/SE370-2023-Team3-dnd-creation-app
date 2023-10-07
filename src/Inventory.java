import java.util.ArrayList;

public class Inventory {

    // 0: Copper, 1: Silver, 2: Electrum, 3: Gold, 4: Platinum
    private int[] currency;
    private ArrayList<Item> backpack;

    public Inventory() {
        this.backpack = new ArrayList<Item>();
        this.currency = new int[5];
        this.currency[0] = 0;
        this.currency[1] = 0;
        this.currency[2] = 0;
        this.currency[3] = 0;
        this.currency[4] = 0;
    }

    private abstract class Item {
        private String name;
        private String description;
        private int weight;
        private int cost;
        private String currencyType;

        private Item(String name, String description, int weight, int cost, String currencyType) {
            this.name = name;
            this.description = description;
            this.weight = weight;
            this.cost = cost;
            this.currencyType = currencyType;
        }
    }

    private class Armor extends Item {
        private enum Type {
            NONE,
            LIGHT,
            MEDIUM,
            HEAVY
        };

        private int ac;
        private Type armorType;
        private boolean stealthDisadvantage;

        public Armor(String name,
                String description,
                int weight,
                int cost,
                String currencyType,
                int ac,
                Type armorType,
                boolean stealth) {
            super(name, description, weight, cost, currencyType);
            this.ac = ac;
            this.armorType = armorType;
            this.stealthDisadvantage = stealth;
        }

        public Armor() {
            this("Noname", "Nodesc", 0, 0, "cp", 0, Type.NONE, false);
        }
    }

    private class Weapon extends Item {
        private enum WeaponType {
            SIMPLE_MELEE,
            SIMPLE_RANGE,
            MARTIAL_MELEE,
            MARTIAL_RANGE,
        }

        private enum AttackType {
            BLUDGEONING,
            PIERCING,
            SLASHING,
        }

        private int diceAmount;
        private int diceType;
        private WeaponType weaponType;
        private AttackType attackType;
        private String properties;

        public Weapon(String name,
                String description,
                int weight,
                int cost,
                String currencyType,
                int diceAmount,
                int diceType,
                WeaponType weaponType,
                AttackType attackType,
                String properties) {
            super(name, description, weight, cost, currencyType);
            this.diceAmount = diceAmount;
            this.diceType = diceType;
            this.weaponType = weaponType;
            this.attackType = attackType;
        }

        public Weapon() {
            this("Noname", "Nodesc", 0, 0, "cp", 1, 4, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Noprops");
        }

    }
}
