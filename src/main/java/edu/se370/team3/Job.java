package edu.se370.team3;


import java.util.ArrayList;
import java.util.Scanner;

class Job {
    private int baseHP;
    // to be added to finalHP in character class while calculating final stats
    private ArrayList<String> proficienciesTypes = new ArrayList<String>();
    // Arraylist index 0 = armor, 1 = weapons, 2 = tools
    private ArrayList<String> skills = new ArrayList<String>();
    private ArrayList<Item> equipment = new ArrayList<Item>();
    private string getJobTitle;
    private int spellCount;
    private int skillCount;

    private Boolean strengthSV;
    private Boolean dexteritySV;
    private Boolean constitutionSV;
    private Boolean intelligenceSV;
    private Boolean wisdomSV;
    private Boolean charismaSV;

    Job() {
        this.baseHP = 0;
        this.proficienciesTypes.add("");
        this.proficienciesTypes.add("");
        this.proficienciesTypes.add("");
        this.strengthSV = false;
        this.dexteritySV = false;
        this.constitutionSV = false;
        this.intelligenceSV = false;
        this.wisdomSV = false;
        this.charismaSV = false;
        this.getJobTitle = "";
        this.spellCount = 0;
        this.skillCount = 0;
    }


    public int getSpellCount()
    {
        return spellCount;
    }

    public int getSkillCount() {
        return skillCount;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int hp) {
        this.baseHP = hp;
    }

    public Boolean getStr() {
        return strengthSV;
    }

    public void setStr() {
        this.strengthSV = true;
    }

    public Boolean getDex() {
        return dexteritySV;
    }

    public void setDex() {
        this.dexteritySV = true;
    }

    public Boolean getCon() {
        return constitutionSV;
    }

    public void setCon() {
        this.constitutionSV = true;
    }

    public Boolean getInt() {
        return intelligenceSV;
    }

    public void setInt() {
        this.intelligenceSV = true;
    }

    public Boolean getWis() {
        return wisdomSV;
    }

    public void setWis() {
        this.wisdomSV = true;
    }

    public Boolean getCha() {
        return charismaSV;
    }

    public void setCha() {
        this.charismaSV = true;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public ArrayList<String> getProficiancy() {
        return proficienciesTypes;
    }

    public ArrayList<String> getEquipment() {
        return equipment;
    }
}

    void Barbarian(int x, int y) {
        this.setStr();
        this.setCon();
        this.setBaseHP(12);
        this.getProficiancy().set(0, "light armor, medium armor, shields");
        this.getProficiancy().set(1, "simple weapons, martial weapons");


        this.getSkills.add("Animal Handling");
        this.getSkills.add("Athletics");
        this.getSkills.add("Intimidation");
        this.getSkills.add("Nature");
        this.getSkills.add("Perception");
        this.getSkills.add("Survival");
        this.skillCount = 2;

    switch (x) {
        case 0:
            this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                    new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light"));
            break;
        case 1:
            this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                    new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
            break;
        case 2:
            this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                    new int[]{1, 8}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Two-handed"));
            break;
        case 3:
            this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                    new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
            break;
        case 4:
            this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                    new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
            break;
        case 5:
            this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                    new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light, Thrown (20/60)"));
            break;
        case 6:
            this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                    new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
            break;
        case 7:
            this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                    new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
            break;
        case 8:
            this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                    new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light"));
            break;
        case 9:
            this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                    new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
            break;
        case 10:
            this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                    new int[]{1, 1}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
            break;
        case 11:
            this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                    new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
            break;
        case 12:
            this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                    new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Finesse, Thrown (20/60)"));
            break;
        case 13:
            this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                    new int[]{1, 6}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));
            break;
        case 14:
            this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                    new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.BLUDGEONING, "Ammunition (range 30/120)"));
            break;
        default:
            System.out.println("Invalid input. No equipment added.");
    }
}

        switch (y) {
            case (0):
                this.getEquipment.add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                this.getEquipment.add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                break;
            case (1):
                this.getEquipment.add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light"));
                break;
            case (2):
                this.getEquipment.add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
                break;
            case (3):
                this.getEquipment.add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                        new int[]{1, 8}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Two-handed"));
                break;
            case (4):
                this.getEquipment.add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                break;
            case (5):
                this.getEquipment.add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                break;
            case (6):
                this.getEquipment.add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light, Thrown (20/60)"));
                break;
            case (7):
                this.getEquipment.add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case (8):
                this.getEquipment.add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
                break;
            case (9):
                this.getEquipment.add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light"));
                break;
            case (10):
                this.getEquipment.add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                break;
            case (11):
                this.getEquipment.add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                        new int[]{1, 1}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case (12):
                this.getEquipment.add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                        new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                break;
            case (13):
                this.getEquipment.add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                        new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Finesse, Thrown (20/60)"));
                break;
            case (14):
                this.getEquipment.add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));
                break;
            case (15):
                this.getEquipment.add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                        new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.BLUDGEONING, "Ammunition (range 30/120)");
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }

        this.getEquipment().add(new Item("Explorer's pack",
                "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, and a waterskin.",
                59, 10, "gp"));
        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
    }


    void Bard(int x, int y, int z) {
        setDex();
        setCha();
        setBaseHP(8);
        getProficiancy().set(0, "light armor");
        getProficiancy().set(1, "simple weapons, hand crossbows, longswords, rapiers, shortswords");
        getProficiancy().set(2, "Three musical instruments of your choice");

        this.getSkills().add("Athletics");
this.getSkills().add("Acrobatics");
this.getSkills().add("Sleight of Hand");
this.getSkills().add("Stealth");
this.getSkills().add("Arcana");
this.getSkills().add("History");
this.getSkills().add("Investigation");
this.getSkills().add("Nature");
this.getSkills().add("Religion");
this.getSkills().add("Animal Handling");
this.getSkills().add("Insight");
this.getSkills().add("Medicine");
this.getSkills().add("Perception");
this.getSkills().add("Survival");
this.getSkills().add("Deception");
this.getSkills().add("Intimidation");
this.getSkills().add("Performance");
this.getSkills().add("Persuasion");
        this.skillCount = 3;

        switch (x) {
            case (0):
                this.getEquipment.add(new Weapon("Longsword", "", 3, 15, "gp", new int[]{1, 8}, weaponType.SLASHING));
                break;
            case (1):
                this.getEquipment.add(new Weapon("Rapier", "", 2, 25, "gp", new int[]{1, 8}, weaponType.PIERCING));
                break;
            case (2):
                this.getEquipment.add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light"));
                break;
            case (3):
                this.getEquipment.add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
                break;
            case (4):
                this.getEquipment.add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                        new int[]{1, 8}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Two-handed"));
                break;
            case (5):
                this.getEquipment.add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                break;
            case (6):
                this.getEquipment.add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                break;
            case (7):
                this.getEquipment.add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light, Thrown (20/60)"));
                break;
            case (8):
                this.getEquipment.add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case (9):
                this.getEquipment.add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
                break;
            case (10):
                this.getEquipment.add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light"));
                break;
            case (11):
                this.getEquipment.add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                break;
            case (12):
                this.getEquipment.add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                        new int[]{1, 1}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case (13):
                this.getEquipment.add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                        new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                break;
            case (14):
                this.getEquipment.add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                        new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Finesse, Thrown (20/60)"));
                break;
            case (15):
                this.getEquipment.add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));
                break;
            case (16):
                this.getEquipment.add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                        new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.BLUDGEONING, "Ammunition (range 30/120)");
                break;
        }
        switch (y) {
            case (0):
                this.getEquipment.add(new Item("Entertainer's pack",
                        "Includes a backpack, a bedroll, 2 costumes, 5 candles, 5 days of rations, a waterskin, and a disguise kit.",
                        32, 40, "gp"));
                break;
            case (1):
                new Item("Diplomat's pack",
                        "Includes a chest, two cases for maps and scrolls, a set of fine clothes, a bottle of ink, an ink pen, a lamp, two flasks of oil, a sheet of paper, a vial of perfume, sealing wax, and soap.",
                        39, 39, "gp");
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (z) {
            case (0):
                this.getEquipment().add(new Misc("Lute", "A stringed musical instrument.", 2, 35, "gp"));
                break;

            case (1):
                this.getEquipment().add(new Misc("Lyre", "A musical instrument with strings.", 10, 30, "gp"));
                break;

            case (2):
                this.getEquipment().add(new Misc("Flute", "A woodwind instrument.", 1, 2, "gp"));
                break;

            case (3):
                this.getEquipment().add(new Misc("Drum", "A percussion instrument.", 3, 6, "gp"));
                break;

            case (4):
                this.getEquipment().add(new Misc("Horn", "A brass instrument.", 2, 3, "gp"));
                break;

            case (5):
                this.getEquipment().add(new Misc("Pan Flute", "A musical instrument with pipes.", 2, 12, "gp"));
                break;

            case (6):
                this.getEquipment().add(new Misc("Bagpipes", "A wind instrument with reeds.", 6, 30, "gp"));
                break;

            case (7):
                this.getEquipment().add(new Misc("Violin", "A stringed musical instrument played with a bow.", 1, 30, "gp"));
                break;

            default:
                System.out.println("Invalid input. No equipment added.");
        }

        this.getEquipment().add(new Armor("Leather Armor", "Light and flexible leather armor.", 10, 10, "gp", 11, ArmorType.LIGHT, true));
        this.getEquipment.add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
    }


    void Cleric(int x, int y, int z, int w) {
        setWis();
        setCha();
        setBaseHP(8);
        getProficiancy().set(0, "Light armor, medium armor, shields");
        getProficiancy().set(1, "All simple weapons");

        this.getSkills().add("History");
this.getSkills().add("Insight");
this.getSkills().add("Medicine");
this.getSkills().add("Persuasion");
this.getSkills().add("Religion");
        this.skillCount = 2;

        switch (x) {
            case (0):
                this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp", new int[]{1, 6}, WeaponType.BLUDGEONING, AttackType.BLUDGEONING, ""));
                break;

            case (1):
                this.getEquipment().add(new Weapon("Warhammer", "A versatile, two-handed weapon with a heavy metal head.", 2, 15, "gp", new int[]{1, 8}, WeaponType.BLUDGEONING, AttackType.BLUDGEONING, ""));
                break;

            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (y) {
            case (0):
                this.getEquipment().add(new Armor("Leather Armor", "Light and flexible leather armor.", 10, 10, "gp", 11, ArmorType.LIGHT, true));
                break;

            case (1):
                this.getEquipment().add(new Armor("Scale Mail", "Armor made of overlapping metal scales.", 45, 50, "gp", 14, ArmorType.MEDIUM, false));
                break;

            case (2):
                this.getEquipment().add(new Armor("Chain Mail", "Armor made of interlocking metal rings.", 55, 75, "gp", 16, ArmorType.HEAVY, false));
                break;

            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (z) {
            case (0):
                this.getEquipment().add(new Weapon("Light Crossbow", "A small, one-handed crossbow.", 5, 25, "gp", new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                this.getEquipment().add(new Item("Bolts", "A bundle of 20 crossbow bolts.", 1, 1, "sp"));
                break;

            case (1):
                this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light"));
                break;

            case (2):
                this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
                break;

            case (3):
                this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp", new int[]{1, 8}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Two-handed"));
                break;

            case (4):
                this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                break;

            case (5):
                this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                break;

            case (6):
                this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light, Thrown (20/60)"));
                break;

            case (7):
                this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;

            case (8):
                this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
                break;

            case (9):
                this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light"));
                break;

            case (10):
                this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                break;

            case (11):
                this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "", new int[]{1, 1}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;

            case (12):
                this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp", new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                break;

            case (13):
                this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp", new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Finesse, Thrown (20/60)"));
                break;

            case (14):
                this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp", new int[]{1, 6}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));
                break;

            case (15):
                this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp", new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.BLUDGEONING, "Ammunition (range 30/120)"));
                break;

            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (w) {
            case (0):
                this.getEquipment().add(new Misc("Explorer's Pack",
                        "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                        59, 10, "gp"));
                break;

            case (1):
                this.getEquipment().add(new Misc("Priest's Pack",
                        "Includes a backpack, a blanket, 10 candles, a tinderbox, an alms box, 2 blocks of incense, a censer, vestments, 2 days of rations, and a waterskin.",
                        19, 19, "gp"));
                break;

            default:
                System.out.println("Invalid input. No equipment added.");
        }
        this.getEquipment().add(new Misc("Holy Symbol",
                "A holy symbol designed to reflect and channel your faith.",
                0, 0, "gp"));
        this.getEquipment().add(new Armor("Shield",
                "A wooden or metal shield carried in one hand to provide additional protection.",
                6, 10, "gp", 2, ArmorType.NONE, false));
    }


    void Druid(int x, int y) {
        setInt();
        setWis();
        setBaseHP(8);
        getProficiancy().set(0, "light armor, medium armor, shields");
        getProficiancy().set(1,
                "clubs, daggers, darts, javelins, maces, quarterstaffs, scimitars, sickles, slings, spears");
        getProficiancy().set(2, "Herbalism kit");

        this.getSkills().add("Arcana");
this.getSkills().add("Animal Handling");
this.getSkills().add("Insight");
this.getSkills().add("Medicine");
this.getSkills().add("Nature");
this.getSkills().add("Perception");
this.getSkills().add("Religion");
this.getSkills().add("Survival");
        this.skillCount = 2;

        switch (x) {
            case (0):
                this.getEquipment().add(new Armor("Shield",
                        "A wooden or metal shield carried in one hand to provide additional protection.",
                        6, 10, "gp", 2, ArmorType.NONE, false));
                break;

            case (1):
                this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light"));
                break;

            case (2):
                this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
                break;

            case (3):
                this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp", new int[]{1, 8}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Two-handed"));
                break;

            case (4):
                this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                break;

            case (5):
                this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                break;

            case (6):
                this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light, Thrown (20/60)"));
                break;

            case (7):
                this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;

            case (8):
                this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
                break;

            case (9):
                this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light"));
                break;

            case (10):
                this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                break;

            case (11):
                this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "", new int[]{1, 1}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;

            case (12):
                this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp", new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                break;

            case (13):
                this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp", new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Finesse, Thrown (20/60)"));
                break;

            case (14):
                this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp", new int[]{1, 6}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));
                break;

            case (15):
                this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp", new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.BLUDGEONING, "Ammunition (range 30/120)"));
                break;

            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (y) {
            case 0:
                this.getEquipment().add(new Weapon("Scimitar", "A curved, slashing blade.", 3, 25, "gp", new int[]{1, 6}, WeaponType.SLASHING, AttackType.SLASHING, ""));
                break;
            case 1:
                this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp", new int[]{1, 4}, WeaponType.BLUDGEONING, AttackType.BLUDGEONING, "Light"));
                break;
            case 2:
                this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
                break;
            case 3:
                this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp", new int[]{1, 8}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Two-handed"));
                break;
            case 4:
                this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 5, 5, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                break;
            case 5:
                this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                break;
            case 6:
                this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light, Thrown (20/60)"));
                break;
            case 7:
                this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case 8:
                this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
                break;
            case 9:
                this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light"));
                break;
            case 10:
                this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        this.getEquipment().add(new Armor("Leather Armor",
                "Flexible armor made from tanned animal hides.",
                10, 10, "gp", 11, ArmorType.LIGHT, false));
        this.getEquipment().add(new Misc("Explorer's Pack",
                "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                59, 10, "gp"));
        this.getEquipment().add(new Misc("Druidic Focus",
                "An object that reflects and channels your connection to nature.",
                0, 0, "gp"));
    }


    void Fighter(int x, int y, int z, int w, int l) {
        setStr();
        setCon();
        setBaseHP(10);
        getProficiancy().set(0, "All armor, shields");
        getProficiancy().set(1, "Simple weapons, martial weapons");
        this.getSkills().add("Acrobatics");
this.getSkills().add("Animal Handling");
this.getSkills().add("Athletics");
this.getSkills().add("History");
this.getSkills().add("Insight");
this.getSkills().add("Intimidation");
this.getSkills().add("Perception");
this.getSkills().add("Survival");
this.getSkillCount = 2;
        switch (armorChoice) {
            case 0:
                this.getEquipment().add(new Armor("Chainmail",
                        "A flexible type of armor made of interlocking metal rings.",
                        55, 75, "gp", 16, ArmorType.HEAVY, true));
                break;
            case 1:

                this.getEquipment().add(new Armor("Leather Armor",
                        "Flexible armor made from tanned animal hides.",
                        10, 10, "gp", 11, ArmorType.LIGHT, false));
                this.getEquipment().add(new Weapon("Longbow",
                        "A large bow suitable for long-range attacks.",
                        2, 50, "gp", new int[]{1, 8}, WeaponType.MARTIAL_RANGED, AttackType.PIERCING,
                        "Ammunition (range 150/600), Heavy, Two-handed"));
                this.getEquipment().add(new Item("20 Arrows", "A projectile designed for use with bows.", 1, 1, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        int loopCase;
        for (int i = 0; i < 2; i++) {
            if (i = 0)
                loopCase = y;
            else
                loopCase = z
            switch (loopCase) {
                case 0:

                    this.getEquipment().add(new Weapon("Battleaxe", "A versatile weapon with a keen edge.", 4, 10, "gp", new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Versatile (1d10)"));
                    break;
                case 1:
                    this.getEquipment().add(new Weapon("Flail", "A spiked chain with a heavy ball at the end.", 2, 10, "gp", new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.BLUDGEONING, ""));
                    break;
                case 2:
                    this.getEquipment().add(new Weapon("Glaive", "A long-handled weapon with a single-edged blade at the end.", 6, 20, "gp", new int[]{1, 10}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Heavy, Reach, Two-handed"));
                    break;
                case 3:
                    this.getEquipment().add(new Weapon("Greataxe", "A massive axe with a large, heavy head.", 7, 30, "gp", new int[]{1, 12}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Heavy, Two-handed"));
                    break;
                case 4:
                    this.getEquipment().add(new Weapon("Greatsword", "A large, two-handed sword with a sharp blade.", 6, 50, "gp", new int[]{2, 6}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Heavy, Two-handed"));
                    break;
                case 5:
                    this.getEquipment().add(new Weapon("Halberd", "A long-handled weapon with an axe blade and a spear point.", 6, 20, "gp", new int[]{1, 10}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Heavy, Reach, Two-handed"));
                    break;
                case 6:
                    this.getEquipment().add(new Weapon("Lance", "A long, narrow weapon used for mounted combat.", 6, 10, "gp", new int[]{1, 12}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Reach, Special"));
                    break;
                case 7:
                    this.getEquipment().add(new Weapon("Longsword", "A versatile and balanced weapon with a sharp blade.", 3, 15, "gp", new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Versatile (1d10)"));
                    break;
                case 8:
                    this.getEquipment().add(new Weapon("Maul", "A large, heavy hammer with a powerful blow.", 10, 10, "gp", new int[]{2, 6}, WeaponType.MARTIAL_MELEE, AttackType.BLUDGEONING, "Heavy, Two-handed"));
                    break;
                case 9:
                    this.getEquipment().add(new Weapon("Morningstar", "A spiked weapon with a heavy, blunt head.", 4, 15, "gp", new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, ""));
                    break;
                case 10:
                    this.getEquipment().add(new Weapon("Pike", "A long, pointed polearm with a sharp tip.", 18, 5, "gp", new int[]{1, 10}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Heavy, Reach, Two-handed"));
                    break;
                case 11:
                    this.getEquipment().add(new Weapon("Rapier", "A slender, piercing weapon with a sharp point.", 2, 25, "gp", new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Finesse"));
                    break;
                case 12:
                    this.getEquipment().add(new Weapon("Scimitar", "A curved, slashing blade.", 3, 25, "gp", new int[]{1, 6}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Finesse, Light"));
                    break;
                case 13:
                    this.getEquipment().add(new Weapon("Shortsword", "A simple, versatile weapon with a sharp blade.", 2, 10, "gp", new int[]{1, 6}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Finesse, Light"));
                    break;
                case 14:
                    this.getEquipment().add(new Weapon("Trident", "A three-pronged spear designed for throwing.", 4, 5, "gp", new int[]{1, 6}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                    break;
                case 15:
                    this.getEquipment().add(new Weapon("Warhammer", "A versatile weapon with a heavy head.", 2, 15, "gp", new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.BLUDGEONING, "Versatile (1d10)"));
                    break;
                case 16:
                    this.getEquipment().add(new Weapon("Whip", "A flexible weapon with a long reach.", 3, 2, "gp", new int[]{1, 4}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Finesse, Reach"));
                    break;
                case 17:
                    this.getEquipment().add(new Weapon("Blowgun", "A small tube used for blowing darts at a target.", 1, 10, "gp", new int[]{1}, WeaponType.MARTIAL_RANGED, AttackType.PIERCING, "Ammunition (range 25/100), Loading"));
                    break;
                case 18:
                    this.getEquipment().add(new Weapon("Crossbow, Hand", "A small, one-handed crossbow.", 3, 75, "gp", new int[]{1, 6}, WeaponType.MARTIAL_RANGED, AttackType.PIERCING, "Ammunition (range 30/120), Light, Loading"));
                    break;
                case 19:
                    this.getEquipment().add(new Weapon("Crossbow, Heavy", "A large, two-handed crossbow.", 18, 50, "gp", new int[]{1, 10}, WeaponType.MARTIAL_RANGED, AttackType.PIERCING, "Ammunition (range 100/400), Heavy, Loading, Two-handed"));
                    break;
                case 20:
                    this.getEquipment().add(new Weapon("Longbow", "A large bow suitable for long-range attacks.", 2, 50, "gp", new int[]{1, 8}, WeaponType.MARTIAL_RANGED, AttackType.PIERCING, "Ammunition (range 150/600), Heavy, Two-handed"));
                    break;
                case 21:
                    this.getEquipment().add(new Weapon("Net", "A mesh of woven ropes designed to restrain targets.", 3, 1, "gp", new int[]{0}, WeaponType.MARTIAL_RANGED, AttackType.BLUDGEONING, "Special, Thrown (5/15)"));
                    break;
                case 22:
                    this.getEquipment().add(new Armor("Shield", "A protective piece of equipment worn on the arm.", 6, 10, "gp", 2, ArmorType.SHIELD, false));
                    break;

                default:
                    System.out.println("Invalid input. No equipment added.");
            }
        }
        switch (w) {
            case 0:

                this.getEquipment().add(new Weapon("Light Crossbow", "A small, one-handed crossbow.", 5, 25, "gp", new int[]{1, 8}, WeaponType.MARTIAL_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                this.getEquipment().add(new Item("Bolts (20)", "A bundle of 20 projectiles designed for use with crossbows.", 1.5, 1, "gp"));
                break;
            case 1:
                this.getEquipment().add(new Weapon("Hand Axe", "A small, versatile axe.", 2, 5, "gp", new int[]{1, 6}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                this.getEquipment().add(new Weapon("Hand Axe", "A small, versatile axe.", 2, 5, "gp", new int[]{1, 6}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (l) {
            case 0:
                this.getEquipment().add(new Misc("Dungeoneer's Pack",
                        "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                        29, 12, "gp"));
                break;
            case 1:
                3
                this.getEquipment().add(new Misc("Explorer's Pack",
                        "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                        59, 10, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment pack added.");
        }
    }


    void Monk(int x, int y) {
        setDex();
        setStr();
        setBaseHP(8);
        getProficiancy().set(1, "simple weapons, shortswords");
        getProficiancy().set(2, "artisan’s tools, musical instruments");

        this.getSkills().add("Acrobatics");
this.getSkills().add("Athletics");
this.getSkills().add("History");
this.getSkills().add("Insight");
this.getSkills().add("Religion");
this.getSkills().add("Stealth");
this.getSkillCount = 2;

        System.out.printf("Equipment:\n");
        switch (x) {
            case 0:
                this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light"));
                break;
            case 1:
                this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
                break;
            case 2:
                this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp", new int[]{1, 8}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Two-handed"));
                break;
            case 3:
                this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                break;
            case 4:
                this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                break;
            case 5:
                this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light, Thrown (20/60)"));
                break;
            case 6:
                this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case 7:
                this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
                break;
            case 8:
                this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light"));
                break;
            case 9:
                this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                break;
            case 10:
                this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "", new int[]{1, 1}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case 11:
                this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp", new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                break;
            case 12:
                this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp", new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Finesse, Thrown (20/60)"));
                break;
            case 13:
                this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp", new int[]{1, 6}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));
                break;
            case 14:
                this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp", new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.BLUDGEONING, "Ammunition (range 30/120)"));
                break;
            case 15:
                this.getEquipment().add(new Weapon("Shortsword", "A simple, versatile weapon with a sharp blade.", 2, 10, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light"));
                break;
            default:
                System.out.println("Invalid input. No weapon added.");
        }
        switch (y) {
            case 0:
                this.getEquipment().add(new Misc("Dungeoneer's Pack",
                        "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                        29, 12, "gp"));
                break;
            case 1:
                3
                this.getEquipment().add(new Misc("Explorer's Pack",
                        "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                        59, 10, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment pack added.");
        }
        this.getEquipment().add(new Item("Dart (10)", "A set of 10 small, throwable projectiles.", 0, 5, "cp"));
    }


    void Paladin(int x, int y, int z, int w, int l) {
        setWis();
        setCha();
        setBaseHP(10);
        getProficiancy().set(0, "all armor, shields");
        getProficiancy().set(1, "simple weapons, martial weapons");
        this.getSkills().add("Athletics");
this.getSkills().add("Insight");
this.getSkills().add("Intimidation");
this.getSkills().add("Medicine");
this.getSkills().add("Persuasion");
this.getSkills().add("Religion");
this.skillCount = 2;
        for (int i = 0; i < 2; i++) {
            if (i = 0)
                loopCase = x;
            else
                loopCase = y;
            switch (loopCase) {
                case 0:

                    this.getEquipment().add(new Weapon("Battleaxe", "A versatile weapon with a keen edge.", 4, 10, "gp", new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Versatile (1d10)"));
                    break;
                case 1:
                    this.getEquipment().add(new Weapon("Flail", "A spiked chain with a heavy ball at the end.", 2, 10, "gp", new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.BLUDGEONING, ""));
                    break;
                case 2:
                    this.getEquipment().add(new Weapon("Glaive", "A long-handled weapon with a single-edged blade at the end.", 6, 20, "gp", new int[]{1, 10}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Heavy, Reach, Two-handed"));
                    break;
                case 3:
                    this.getEquipment().add(new Weapon("Greataxe", "A massive axe with a large, heavy head.", 7, 30, "gp", new int[]{1, 12}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Heavy, Two-handed"));
                    break;
                case 4:
                    this.getEquipment().add(new Weapon("Greatsword", "A large, two-handed sword with a sharp blade.", 6, 50, "gp", new int[]{2, 6}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Heavy, Two-handed"));
                    break;
                case 5:
                    this.getEquipment().add(new Weapon("Halberd", "A long-handled weapon with an axe blade and a spear point.", 6, 20, "gp", new int[]{1, 10}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Heavy, Reach, Two-handed"));
                    break;
                case 6:
                    this.getEquipment().add(new Weapon("Lance", "A long, narrow weapon used for mounted combat.", 6, 10, "gp", new int[]{1, 12}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Reach, Special"));
                    break;
                case 7:
                    this.getEquipment().add(new Weapon("Longsword", "A versatile and balanced weapon with a sharp blade.", 3, 15, "gp", new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Versatile (1d10)"));
                    break;
                case 8:
                    this.getEquipment().add(new Weapon("Maul", "A large, heavy hammer with a powerful blow.", 10, 10, "gp", new int[]{2, 6}, WeaponType.MARTIAL_MELEE, AttackType.BLUDGEONING, "Heavy, Two-handed"));
                    break;
                case 9:
                    this.getEquipment().add(new Weapon("Morningstar", "A spiked weapon with a heavy, blunt head.", 4, 15, "gp", new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, ""));
                    break;
                case 10:
                    this.getEquipment().add(new Weapon("Pike", "A long, pointed polearm with a sharp tip.", 18, 5, "gp", new int[]{1, 10}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Heavy, Reach, Two-handed"));
                    break;
                case 11:
                    this.getEquipment().add(new Weapon("Rapier", "A slender, piercing weapon with a sharp point.", 2, 25, "gp", new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Finesse"));
                    break;
                case 12:
                    this.getEquipment().add(new Weapon("Scimitar", "A curved, slashing blade.", 3, 25, "gp", new int[]{1, 6}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Finesse, Light"));
                    break;
                case 13:
                    this.getEquipment().add(new Weapon("Shortsword", "A simple, versatile weapon with a sharp blade.", 2, 10, "gp", new int[]{1, 6}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Finesse, Light"));
                    break;
                case 14:
                    this.getEquipment().add(new Weapon("Trident", "A three-pronged spear designed for throwing.", 4, 5, "gp", new int[]{1, 6}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                    break;
                case 15:
                    this.getEquipment().add(new Weapon("Warhammer", "A versatile weapon with a heavy head.", 2, 15, "gp", new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.BLUDGEONING, "Versatile (1d10)"));
                    break;
                case 16:
                    this.getEquipment().add(new Weapon("Whip", "A flexible weapon with a long reach.", 3, 2, "gp", new int[]{1, 4}, WeaponType.MARTIAL_MELEE, AttackType.SLASHING, "Finesse, Reach"));
                    break;
                case 17:
                    this.getEquipment().add(new Weapon("Blowgun", "A small tube used for blowing darts at a target.", 1, 10, "gp", new int[]{1}, WeaponType.MARTIAL_RANGED, AttackType.PIERCING, "Ammunition (range 25/100), Loading"));
                    break;
                case 18:
                    this.getEquipment().add(new Weapon("Crossbow, Hand", "A small, one-handed crossbow.", 3, 75, "gp", new int[]{1, 6}, WeaponType.MARTIAL_RANGED, AttackType.PIERCING, "Ammunition (range 30/120), Light, Loading"));
                    break;
                case 19:
                    this.getEquipment().add(new Weapon("Crossbow, Heavy", "A large, two-handed crossbow.", 18, 50, "gp", new int[]{1, 10}, WeaponType.MARTIAL_RANGED, AttackType.PIERCING, "Ammunition (range 100/400), Heavy, Loading, Two-handed"));
                    break;
                case 20:
                    this.getEquipment().add(new Weapon("Longbow", "A large bow suitable for long-range attacks.", 2, 50, "gp", new int[]{1, 8}, WeaponType.MARTIAL_RANGED, AttackType.PIERCING, "Ammunition (range 150/600), Heavy, Two-handed"));
                    break;
                case 21:
                    this.getEquipment().add(new Weapon("Net", "A mesh of woven ropes designed to restrain targets.", 3, 1, "gp", new int[]{0}, WeaponType.MARTIAL_RANGED, AttackType.BLUDGEONING, "Special, Thrown (5/15)"));
                    break;
                case 22:
                    this.getEquipment().add(new Armor("Shield", "A protective piece of equipment worn on the arm.", 6, 10, "gp", 2, ArmorType.SHIELD, false));
                    break;

                default:
                    System.out.println("Invalid input. No equipment added.");
            }
        }

        switch (z) {
            case 0:
                this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                break;
            case 1:
                this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light"));
                break;
            case 2:
                this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
                break;
            case 3:
                this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp", new int[]{1, 8}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Two-handed"));
                break;
            case 4:
                this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                break;
            case 5:
                this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light, Thrown (20/60)"));
                break;
            case 6:
                this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case 7:
                this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
                break;
            case 8:
                this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light"));
                break;
            case 9:
                this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                break;
            case 10:
                this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "", new int[]{1, 1}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
        }
        switch (w) {
            case 0:
                this.getEquipment().add(new Misc("Explorer's Pack", "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.", 59, 10, "gp"));
                break;
            case 1:
                this.getEquipment().add(new Misc("Priest's Pack", "Includes a backpack, a blanket, 10 candles, a tinderbox, an alms box, a block of incense, a censer, vestments, 2 days of rations, and a waterskin.", 19, 10, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (y) {
            case 0:
                this.getEquipment().add(new Misc("Dungeoneer's Pack",
                        "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                        29, 12, "gp"));
                break;
            case 1:
                3
                this.getEquipment().add(new Misc("Explorer's Pack",
                        "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                        59, 10, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment pack added.");
        }
        this.getEquipment().add(new Armor("Chainmail",
                "A flexible type of armor made of interlocking metal rings.",
                55, 75, "gp", 16, ArmorType.HEAVY, true));
        this.getEquipment().add(new Misc("Holy Symbol",
                "A holy symbol designed to reflect and channel your faith.",
                0, 0, "gp"));
    }


    void Ranger(int x, int y, int z, int w) {
        setDex();
        setStr();
        setBaseHP(10);
        getProficiancy().set(0, "Light armor");
        getProficiancy().set(1, "Simple weapons, martial weapons");
this.getSkills().add("Animal Handling");
this.getSkills().add("Athletics");
this.getSkills().add("Insight");
this.getSkills().add("Investigation");
this.getSkills().add("Nature");
this.getSkills().add("Perception");
this.getSkills().add("Stealth");
this.getSkills().add("Survival");
this.skillCount = 3;


        int loopCase;
        for (int i = 0; i < 2; i++) {
            if (i = 0)
                loopCase = x;
            else
                loopCase = y;
            switch (loopCase) {
                case 0:
                    this.getEquipment().add(new Weapon("Shortsword", "A versatile and finesse melee weapon.", 2, 10, "gp",
                            new int[]{1, 6}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Finesse, Light"));
                    break;
                case 1:
                    this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                            new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light"));
                    break;
                case 2:
                    this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                            new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
                    break;
                case 3:
                    this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                            new int[]{1, 8}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Two-handed"));
                    break;
                case 4:
                    this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                            new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                    break;
                case 5:
                    this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                            new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                    break;
                case 6:
                    this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                            new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light, Thrown (20/60)"));
                    break;
                case 7:
                    this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                            new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                    break;
                case 8:
                    this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                            new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
                    break;
                case 9:
                    this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                            new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light"));
                    break;
                case 10:
                    this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                            new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                    break;
                case 11:
                    this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                            new int[]{1, 1}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                    break;
                case 12:
                    this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                            new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                    break;
                case 13:
                    this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                            new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Finesse, Thrown (20/60)"));
                    break;
                case 14:
                    this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                            new int[]{1, 6}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));
                    break;
                case 15:
                    this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                            new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.BLUDGEONING, "Ammunition (range 30/120)"));
                    break;
                default:
                    System.out.println("Invalid input. No equipment added.");
            }
        }

        switch (z) {
            case 0:
                this.getEquipment().add(new Armor("Scale Mail", "Heavy armor made of interlocking metal scales.", 45, 50, "gp", 14, ArmorType.HEAVY, true));
                break;
            case 1:
                this.getEquipment().add(new Armor("Leather Armor", "Light armor made from tanned animal hides.", 10, 10, "gp", 11, ArmorType.LIGHT, false));
                break;
            default:
                System.out.println("Invalid input. No armor added.");
        }
        switch (w) {
            case 0:
                this.getEquipment().add(new Misc("Dungeoneer's Pack",
                        "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                        29, 12, "gp"));
                break;
            case 1:
                3
                this.getEquipment().add(new Misc("Explorer's Pack",
                        "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                        59, 10, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment pack added.");
        }
        this.getEquipment().add(new Weapon("Longbow", "A powerful ranged weapon with great accuracy.", 2, 50, "gp",
                new int[]{1, 8}, WeaponType.MARTIAL_RANGED, AttackType.PIERCING, "Ammunition (range 150/600), Heavy, Two-handed"));
        this.getEquipment().add(new Item("Arrows (20)", "A quiver containing 20 arrows for use with a ranged weapon.", 1, 1, "gp"));
    }


    void Rogue(int x, int y, int z) {
        setDex();
        setInt();
        setBaseHP(8);
        getProficiancy().set(0, "Light armor");
        getProficiancy().set(1, "Simple weapons, hand crossbows, longswords, rapiers, shortswords");
        getProficiancy().set(2, "Thieves’ tools");

        Sthis.getSkills().add("Acrobatics");
this.getSkills().add("Athletics");
this.getSkills().add("Deception");
this.getSkills().add("Insight");
this.getSkills().add("Intimidation");
this.getSkills().add("Investigation");
this.getSkills().add("Perception");
this.getSkills().add("Performance");
this.getSkills().add("Persuasion");
this.getSkills().add("Sleight of Hand");
this.getSkills().add("Stealth");
this.skillCount = 4;

        switch (x) {
            case 0:
                this.getEquipment().add(new Weapon("Rapier", "A slender, sharply-pointed sword suitable for thrusting attacks.", 2, 25, "gp",
                        new int[]{1, 8}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Finesse"));
                break;
            case 1:
                this.getEquipment().add(new Weapon("Shortsword", "A small, versatile sword.", 2, 10, "gp",
                        new int[]{1, 6}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Finesse, Light"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (y) {
            case 0:
                this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));
                this.getEquipment().add(new Item("Arrows (20)", "A quiver containing 20 arrows for use with a ranged weapon.", 1, 1, "gp"));
                break;
            case 1:
                this.getEquipment().add(new Weapon("Shortsword", "A small, versatile sword.", 2, 10, "gp",
                        new int[]{1, 6}, WeaponType.MARTIAL_MELEE, AttackType.PIERCING, "Finesse, Light"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (z) {
            case 0:
                this.getEquipment().add(new Misc("Burglar's Pack",
                        "Includes a backpack, a crowbar, a set of dark common clothes including a hood, a belt pouch, a set of thieves' tools, and a candle.",
                        16, 16, "gp"));
                break;
            case 1:
                this.getEquipment().add(new Misc("Dungeoneer's Pack",
                        "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, and a waterskin.",
                        61, 12, "gp"));
                break;
            case 2:
                this.getEquipment().add(new Misc("Explorer's Pack",
                        "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                        59, 10, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        this.getEquipment().add(new Armor("Leather Armor", "Light armor made from tanned animal hides.", 10, 10, "gp", 11, ArmorType.LIGHT, false));
        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
        this.getEquipment().add(new Misc("Thieves' Tools", "A set of tools for picking locks and disabling traps.", 1, 25, "gp"));

    }


    void Sorcerer(int x, int y, int z) {
        setDex();
        setCon();
        setBaseHP(6);
        getProficiancy().set(1, "Daggers, darts, slings, quarterstaffs, light crossbows");

        this.getSkills().add("Arcana");
this.getSkills().add("Deception");
this.getSkills().add("Insight");
this.getSkills().add("Intimidation");
this.getSkills().add("Persuasion");
this.getSkills().add("Religion");
this.skillCount = 2;

        switch (x) {
            case 0:
                this.getEquipment().add(new Weapon("Light Crossbow", "A small, one-handed crossbow.", 5, 25, "gp",
                        new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                this.getEquipment().add(new Item("Bolts (20)", "A quiver containing 20 bolts for use with a ranged weapon.", 1, 1, "gp"));
                break;
            case 1:
                this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light"));
                break;
            case 2:
                this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
                break;
            case 3:
                this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                        new int[]{1, 8}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Two-handed"));
                break;
            case 4:
                this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                break;
            case 5:
                this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                break;
            case 6:
                this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light, Thrown (20/60)"));
                break;
            case 7:
                this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case 8:
                this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
                break;
            case 9:
                this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light"));
                break;
            case 10:
                this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                break;
            case 11:
                this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                        new int[]{1, 1}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case 12:
                this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                        new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                break;
            case 13:
                this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                        new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Finesse, Thrown (20/60)"));
                break;
            case 14:
                this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));
                break;
            case 15:
                this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                        new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.BLUDGEONING, "Ammunition (range 30/120)"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (y) {
            case 0:
                this.getEquipment().add(new Item("Component Pouch", "A small, watertight leather belt pouch for holding spell components.", 2, 25, "gp"));
                break;
            case 1:
                this.getEquipment().add(new Item("Arcane Focus", "A crystal, an orb, a rod, a specially constructed staff, or some similar item designed to channel the power of arcane spells.", 1, 10, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (z) {
            case 0:
                this.getEquipment().add(new Misc("Dungeoneer's Pack",
                        "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                        29, 12, "gp"));
                break;
            case 1:
                3
                this.getEquipment().add(new Misc("Explorer's Pack",
                        "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                        59, 10, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment pack added.");
        }
        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
    }


    void Warlock(int x, int y, int z, int w) {
        setWis();
        setCha();
        setBaseHP(8);
        getProficiancy().set(0, "Light armor");
        getProficiancy().set(1, "Simple weapons");

        this.getSkills().add("Arcana");
this.getSkills().add("Deception");
this.getSkills().add("History");
this.getSkills().add("Intimidation");
this.getSkills().add("Investigation");
this.getSkills().add("Nature");
this.getSkills().add("Religion");
this.skillCount = 2;

        switch (x) {
            case 0:
                this.getEquipment().add(new Weapon("Light Crossbow", "A small, one-handed crossbow.", 5, 25, "gp",
                        new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                this.getEquipment().add(new Item("Bolts (20)", "A quiver containing 20 bolts for use with a ranged weapon.", 1, 1, "gp"));
                break;
            case 1:
                this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light"));
                break;
            case 2:
                this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
                break;
            case 3:
                this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                        new int[]{1, 8}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Two-handed"));
                break;
            case 4:
                this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                break;
            case 5:
                this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                break;
            case 6:
                this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light, Thrown (20/60)"));
                break;
            case 7:
                this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case 8:
                this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
                break;
            case 9:
                this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light"));
                break;
            case 10:
                this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                break;
            case 11:
                this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                        new int[]{1, 1}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case 12:
                this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                        new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                break;
            case 13:
                this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                        new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Finesse, Thrown (20/60)"));
                break;
            case 14:
                this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));
                break;
            case 15:
                this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                        new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.BLUDGEONING, "Ammunition (range 30/120)"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }

        switch (y) {
            case 0:
                this.getEquipment().add(new Item("Component Pouch", "A small, watertight leather belt pouch for holding spell components.", 2, 25, "gp"));
                break;
            case 1:
                this.getEquipment().add(new Item("Arcane Focus", "A crystal, an orb, a rod, a specially constructed staff, or some similar item designed to channel the power of arcane spells.", 1, 10, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (z) {
            case 0:
                this.getEquipment().add(new Misc("Scholar's Pack",
                        "Includes a backpack, a book of lore, a bottle of ink, an ink pen, 10 sheets of parchment, a little bag of sand, and a small knife.", 40, 40, "gp"));
                break;
            case 1:
                this.getEquipment().add(new Misc("Dungeoneer's Pack",
                        "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, and a waterskin.", 61, 12, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        switch (w) {
            case 0:
                this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light"));
                break;
            case 1:
                this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
                break;
            case 2:
                this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                        new int[]{1, 8}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Two-handed"));
                break;
            case 3:
                this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light, Thrown (20/60)"));
                break;
            case 4:
                this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (30/120)"));
                break;
            case 5:
                this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Light, Thrown (20/60)"));
                break;
            case 6:
                this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case 7:
                this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
                break;
            case 8:
                this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                        new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.SLASHING, "Light"));
                break;
            case 9:
                this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));
                break;
            case 10:
                this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                        new int[]{1, 1}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, ""));
                break;
            case 11:
                this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                        new int[]{1, 8}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Loading, Two-handed"));
                break;
            case 12:
                this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                        new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Finesse, Thrown (20/60)"));
                break;
            case 13:
                this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                        new int[]{1, 6}, WeaponType.SIMPLE_RANGED, AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));
                break;
            case 14:
                this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                        new int[]{1, 4}, WeaponType.SIMPLE_RANGED, AttackType.BLUDGEONING, "Ammunition (range 30/120)"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
        }
        this.getEquipment().add(new Armor("Leather Armor", "Light, flexible armor made from animal hides.", 10, 10, "gp", 11, ArmorType.LIGHT, false));
        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
    }


    void Wizard(int x, int y, int z) {
        setWis();
        setInt();
        setBaseHP(6);
        getProficiancy().set(1, "Daggers, darts, slings, quarterstaffs, light crossbows");

        this.getSkills().add("Arcana");
this.getSkills().add("History");
this.getSkills().add("Insight");
this.getSkills().add("Investigation");
this.getSkills().add("Medicine");
this.getSkills().add("Religion");
this.skillCount = 2;

        switch (x) {
            case 0:
                this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp", new int[]{1, 6}, WeaponType.SIMPLE_MELEE, AttackType.BLUDGEONING, "Versatile (1d8)"));
                break;
            case 1:
                this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4}, WeaponType.SIMPLE_MELEE, AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
                break;
        }
        switch (y) {
            case 0:
                this.getEquipment().add(new Misc("Component Pouch", "A small, watertight leather belt pouch containing various spell components.", 2, 25, "gp"));
                break;
            case 1:
                this.getEquipment().add(new Misc("Arcane Focus", "A crystal, an orb, a rod, a specially constructed staff, a wand-like length of wood, or some similar item.", 1, 10, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
                break;
        }
        switch (yourInput) {
            case 0:
                this.getEquipment().add(new Misc("Scholar's Pack",
                        "Includes a backpack, a book of lore, a bottle of ink, an ink pen, 10 sheets of parchment, a little bag of sand, and a small knife.", 20, 40, "gp"));
                break;
            case 1:
                this.getEquipment().add(new Misc("Explorer's Pack",
                        "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.", 59, 10, "gp"));
                break;
            default:
                System.out.println("Invalid input. No equipment added.");
                break;
        }
        this.getEquipment().add(new Misc("Spellbook", "A book containing arcane symbols and formulas used by wizards to prepare their spells.", 3, 50, "gp"));
    }
