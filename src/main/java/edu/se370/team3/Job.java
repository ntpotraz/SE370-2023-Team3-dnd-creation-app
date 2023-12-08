package edu.se370.team3;

import java.util.ArrayList;

import edu.se370.team3.Armor.ArmorType;

class Job {
    private int baseHP;
    // to be added to finalHP in character class while calculating final stats
    private ArrayList<String> proficienciesTypes = new ArrayList<String>();
    // Arraylist index 0 = armor, 1 = weapons, 2 = tools
    private ArrayList<String> skills = new ArrayList<String>();
    private ArrayList<Item> equipment = new ArrayList<Item>();
    private ArrayList<Item> equipmentGiven = new ArrayList<Item>();
    private equipmentString;
    private String jobTitle;
    private int spellCount;
    private int skillCount;
    private int cantripCount;
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
        this.jobTitle = "";
        this.spellCount = 0;
        this.skillCount = 0;
        this.equipmentString = "";
        this.cantripCount = 0;
    }

    public int getSpellCount() {
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

    public ArrayList<Item> getEquipment() {
        return equipment;
    }

    public ArrayList<Item> getEquipmentGiven() {
        return equipmentGiven;
    }

    public String getEquipmentString() { return equipmentString; }

    void Barbarian() {
        this.setStr();
        this.setCon();
        this.setBaseHP(12);
        this.getProficiancy().set(0, "light armor, medium armor, shields");
        this.getProficiancy().set(1, "simple weapons, martial weapons");

        this.getSkills().add("animal_handling");
        this.getSkills().add("athletics");
        this.getSkills().add("intimidation");
        this.getSkills().add("nature");
        this.getSkills().add("perception");
        this.getSkills().add("survival");
        this.skillCount = 2;

        this.equipmentString = "Pick a greataxe or any martial melee weapon, and two handaxes or any simple weapon.";
        this.getEquipment().add(new Weapon("Battleaxe", "A stout axe favored by dwarves.", 4, 10, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, ""));

        this.getEquipment().add(new Weapon("Flail", "A spiked ball on a chain.", 2, 10, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.BLUDGEONING, ""));
        this.getEquipment().add(new Weapon("Glaive", "A polearm with a curved blade at the end.", 6, 20, "gp",
                new int[]{1, 10}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, ""));

        this.getEquipment().add(new Weapon("Greataxe", "A large, two-handed axe.", 7, 30, "gp",
                new int[]{1, 12}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, ""));

        this.getEquipment().add(new Weapon("Greatsword", "A large, two-handed sword.", 6, 50, "gp",
                new int[]{2, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, ""));

        this.getEquipment().add(new Weapon("Halberd", "A two-handed polearm with an axe blade.", 6, 20, "gp",
                new int[]{1, 10}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, ""));

        this.getEquipment().add(new Weapon("Lance", "A long, two-handed spear for mounted combat.", 6, 10, "gp",
                new int[]{1, 12}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, ""));

        this.getEquipment().add(new Weapon("Longsword", "A versatile, one-handed sword.", 3, 15, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, ""));

        this.getEquipment().add(new Weapon("Maul", "A heavy, two-handed hammer.", 10, 10, "gp",
                new int[]{2, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Morningstar", "A spiked mace with a chain.", 4, 15, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, ""));

        this.getEquipment().add(new Weapon("Pike", "A long, two-handed spear.", 18, 5, "gp",
                new int[]{1, 10}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, ""));

        this.getEquipment().add(new Weapon("Rapier", "A slender, piercing sword.", 2, 25, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, ""));

        this.getEquipment().add(new Weapon("Shortsword", "A versatile, one-handed sword.", 2, 10, "gp",
                        new int[]{1, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, ""));

        this.getEquipment().add(new Weapon("Trident", "A three-pronged spear.", 4, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Thrown (20/60)"));

        this.getEquipment().add(new Weapon("War Pick", "A war pick with a pointed end.", 2, 5, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, ""));

        this.getEquipment().add(new Weapon("Warhammer", "A versatile, one-handed hammer.", 2, 15, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Whip", "A long, flexible whip.", 3, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, ""));

        this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light"));

        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Two-handed"));

        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (30/120)"));

        this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING,
                "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light"));

        this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Thrown (20/60), Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                new int[]{1, 1}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Loading, Two-handed"));

        this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING, "Finesse, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Two-handed"));

        this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.BLUDGEONING,
                "Ammunition (range 30/120)"));

        this.getEquipmentGiven()
                .add(new Misc("Explorer's pack",
                        "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, and a waterskin.",
                        59, 10, "gp"));
        this.getEquipmentGiven().add(new Weapon("Javelin's (4)", "A light spear designed for throwing.", 8, 20, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (30/120)"));

    }

    void Bard() {
        setDex();
        setCha();
        setBaseHP(8);
        getProficiancy().set(0, "light armor");
        getProficiancy().set(1, "simple weapons, hand crossbows, longswords, rapiers, shortswords");
        getProficiancy().set(2, "Three musical instruments of your choice");

        this.getSkills().add("athletics");
        this.getSkills().add("acrobatics");
        this.getSkills().add("sleight_of_hand");
        this.getSkills().add("stealth");
        this.getSkills().add("arcana");
        this.getSkills().add("history");
        this.getSkills().add("investigation");
        this.getSkills().add("nature");
        this.getSkills().add("religion");
        this.getSkills().add("animal_handling");
        this.getSkills().add("insight");
        this.getSkills().add("medicine");
        this.getSkills().add("perception");
        this.getSkills().add("survival");
        this.getSkills().add("deception");
        this.getSkills().add("intimidation");
        this.getSkills().add("performance");
        this.getSkills().add("persuasion");
        this.skillCount = 3;

        this.equipmentString = "Pick a rapier, a longsword, or any simple weapon, then a diplomat’s pack or an entertainer's pack, and any musical instrument";
        this.getEquipment().add(new Weapon("Longsword", "A versatile, one-handed sword.", 3, 15, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, ""));

        this.getEquipment().add(new Weapon("Rapier", "A slender, piercing sword.", 2, 25, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, ""));

        this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light"));

        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Two-handed"));

        this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (30/120)"));

        this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING,
                "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light"));

        this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Thrown (20/60), Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                new int[]{1, 1}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Loading, Two-handed"));

        this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING, "Finesse, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Two-handed"));

        this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.BLUDGEONING,
                "Ammunition (range 30/120)"));


        this.getEquipment().add(new Misc("Entertainer's pack",
                "Includes a backpack, a bedroll, 2 costumes, 5 candles, 5 days of rations, a waterskin, and a disguise kit.",
                32, 40, "gp"));

        new Misc("Diplomat's pack",
                "Includes a chest, two cases for maps and scrolls, a set of fine clothes, a bottle of ink, an ink pen, a lamp, two flasks of oil, a sheet of paper, a vial of perfume, sealing wax, and soap.",
                39, 39, "gp");


        this.getEquipment().add(new Misc("Lute", "A stringed musical instrument.", 2, 35, "gp"));


        this.getEquipment().add(new Misc("Lyre", "A musical instrument with strings.", 10, 30, "gp"));


        this.getEquipment().add(new Misc("Flute", "A woodwind instrument.", 1, 2, "gp"));


        this.getEquipment().add(new Misc("Drum", "A percussion instrument.", 3, 6, "gp"));


        this.getEquipment().add(new Misc("Horn", "A brass instrument.", 2, 3, "gp"));


        this.getEquipment().add(new Misc("Pan Flute", "A musical instrument with pipes.", 2, 12, "gp"));


        this.getEquipment().add(new Misc("Bagpipes", "A wind instrument with reeds.", 6, 30, "gp"));


        this.getEquipment().add(new Misc("Violin", "A stringed musical instrument played with a bow.", 1, 30, "gp"));


        this.getEquipmentGiven()
                .add(new Armor("Leather Armor", "Light and flexible leather armor.", 10, 10, "gp", 11, ArmorType.LIGHT, true));
        this.getEquipmentGiven().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));
    }

    void Cleric() {
        setWis();
        setCha();
        setBaseHP(8);
        getProficiancy().set(0, "Light armor, medium armor, shields");
        getProficiancy().set(1, "All simple weapons");

        this.getSkills().add("history");
        this.getSkills().add("insight");
        this.getSkills().add("medicine");
        this.getSkills().add("persuasion");
        this.getSkills().add("religion");
        this.skillCount = 2;

        this.equipmentString = "Pick a mace or a warhammer (if proficient), and scale mail, leather armor, or chain mail (if proficient), then a light crossbow or any simple weapon, finally pick a priest’s pack or an explorer’s pack.";

        this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Warhammer", "A versatile, two-handed weapon with a heavy metal head.", 2,
                15, "gp", new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(
                new Armor("Leather Armor", "Light and flexible leather armor.", 10, 10, "gp", 11, ArmorType.LIGHT, true));

        this.getEquipment().add(new Armor("Scale Mail", "Armor made of overlapping metal scales.", 45, 50, "gp", 14,
                ArmorType.MEDIUM, false));

        this.getEquipment().add(new Armor("Chain Mail", "Armor made of interlocking metal rings.", 55, 75, "gp", 16,
                ArmorType.HEAVY, false));

        this.getEquipment()
                .add(new Weapon("Light Crossbow", "A small, one-handed crossbow.", 5, 25, "gp", new int[]{1, 8},
                        Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 80/320), Loading, Two-handed"));
        this.getEquipment().add(new Misc("Bolts", "A bundle of 20 crossbow bolts.", 1, 1, "sp"));

        this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light"));

        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp", new int[]{1, 8},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Two-handed"));

        this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp", new int[]{1, 6},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (30/120)"));

        this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light"));

        this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp", new int[]{1, 6},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                new int[]{1, 1}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment()
                .add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp", new int[]{1, 8},
                        Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 80/320), Loading, Two-handed"));

        this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING, "Finesse, Thrown (20/60)"));

        this.getEquipment().add(
                new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp", new int[]{1, 6},
                        Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));

        this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.BLUDGEONING,
                "Ammunition (range 30/120)"));

        this.getEquipment().add(new Misc("Explorer's Pack",
                "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                59, 10, "gp"));

        this.getEquipment().add(new Misc("Priest's Pack",
                "Includes a backpack, a blanket, 10 candles, a tinderbox, an alms box, 2 blocks of incense, a censer, vestments, 2 days of rations, and a waterskin.",
                19, 19, "gp"));

        this.getEquipmentGiven().add(new Misc("Holy Symbol",
                "A holy symbol designed to reflect and channel your faith.",
                0, 0, "gp"));
        this.getEquipmentGiven().add(new Armor("Shield",
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

        this.getSkills().add("arcana");
        this.getSkills().add("animal_handling");
        this.getSkills().add("insight");
        this.getSkills().add("medicine");
        this.getSkills().add("nature");
        this.getSkills().add("perception");
        this.getSkills().add("religion");
        this.getSkills().add("survival");
        this.skillCount = 2;

        this.equipmentString = "Pick either a shield and one weapon, or two weapons.";
        this.getEquipment().add(new Armor("Shield",
                "A wooden shield carried in one hand to provide additional protection.",
                6, 10, "gp", 2, ArmorType.NONE, false));

        this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light"));

        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp", new int[]{1, 8},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Two-handed"));

        this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp", new int[]{1, 6},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (30/120)"));

        this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light"));

        this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp", new int[]{1, 6},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                new int[]{1, 1}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment()
                .add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp", new int[]{1, 8},
                        Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 80/320), Loading, Two-handed"));

        this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING, "Finesse, Thrown (20/60)"));

        this.getEquipment().add(
                new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp", new int[]{1, 6},
                        Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING, "Ammunition (range 80/320), Two-handed"));

        this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.BLUDGEONING,
                "Ammunition (range 30/120)"));

        this.getEquipment().add(new Weapon("Scimitar", "A curved, slashing blade.", 3, 25, "gp", new int[]{1, 6},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, ""));



        this.getEquipmentGiven().add(new Armor("Leather Armor",
                "Flexible armor made from tanned animal hides.",
                10, 10, "gp", 11, ArmorType.LIGHT, false));
        this.getEquipmentGiven().add(new Misc("Explorer's Pack",
                "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                59, 10, "gp"));
        this.getEquipmentGiven().add(new Misc("Druidic Focus",
                "An object that reflects and channels your connection to nature.",
                0, 0, "gp"));
    }

    void Fighter() {
        setStr();
        setCon();
        setBaseHP(10);
        getProficiancy().set(0, "All armor, shields");
        getProficiancy().set(1, "Simple weapons, martial weapons");
        this.getSkills().add("acrobatics");
        this.getSkills().add("animal_handling");
        this.getSkills().add("athletics");
        this.getSkills().add("history");
        this.getSkills().add("insight");
        this.getSkills().add("intimidation");
        this.getSkills().add("perception");
        this.getSkills().add("survival");
        this.skillCount = 2;

        this. equipmentString = "Pick chain mail or leather armor, a longbow, and 20 arrows, then a martial weapon and a shield or two martial weapons\n" +
                "also a light crossbow and 20 bolts or two handaxes, finally a dungeoneer’s pack or an explorer’s pack";
        this.getEquipment().add(new Armor("Chainmail",
                "A flexible type of armor made of interlocking metal rings.",
                55, 75, "gp", 16, Armor.ArmorType.HEAVY, true));

        this.getEquipment().add(new Armor("Leather Armor",
                "Flexible armor made from tanned animal hides.",
                10, 10, "gp", 11, Armor.ArmorType.LIGHT, false));
        this.getEquipment().add(new Weapon("Longbow",
                "A large bow suitable for long-range attacks.",
                2, 50, "gp", new int[]{1, 8}, Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 150/600), Heavy, Two-handed"));
        this.getEquipment().add(new Misc("20 Arrows", "A projectile designed for use with bows.", 1, 1, "gp"));

        this.getEquipment().add(new Weapon("Battleaxe", "A versatile weapon with a keen edge.", 4, 10, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Versatile (1d10)"));

        this.getEquipment().add(new Weapon("Flail", "A spiked chain with a heavy ball at the end.", 2, 10, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.BLUDGEONING, ""));
        this.getEquipment()
                .add(new Weapon("Glaive", "A long-handled weapon with a single-edged blade at the end.", 6, 20, "gp",
                        new int[]{1, 10}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING,
                        "Heavy, Reach, Two-handed"));

        this.getEquipment().add(new Weapon("Greataxe", "A massive axe with a large, heavy head.", 7, 30, "gp",
                new int[]{1, 12}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Heavy, Two-handed"));

        this.getEquipment().add(new Weapon("Greatsword", "A large, two-handed sword with a sharp blade.", 6, 50, "gp",
                new int[]{2, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Heavy, Two-handed"));

        this.getEquipment()
                .add(new Weapon("Halberd", "A long-handled weapon with an axe blade and a spear point.", 6, 20, "gp",
                        new int[]{1, 10}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING,
                        "Heavy, Reach, Two-handed"));

        this.getEquipment().add(new Weapon("Lance", "A long, narrow weapon used for mounted combat.", 6, 10, "gp",
                new int[]{1, 12}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Reach, Special"));

        this.getEquipment()
                .add(new Weapon("Longsword", "A versatile and balanced weapon with a sharp blade.", 3, 15, "gp",
                        new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Versatile (1d10)"));

        this.getEquipment().add(new Weapon("Maul", "A large, heavy hammer with a powerful blow.", 10, 10, "gp",
                new int[]{2, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.BLUDGEONING, "Heavy, Two-handed"));

        this.getEquipment().add(new Weapon("Morningstar", "A spiked weapon with a heavy, blunt head.", 4, 15, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, ""));
        this.getEquipment()
                .add(new Weapon("Pike", "A long, pointed polearm with a sharp tip.", 18, 5, "gp", new int[]{1, 10},
                        Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Heavy, Reach, Two-handed"));

        this.getEquipment().add(new Weapon("Rapier", "A slender, piercing weapon with a sharp point.", 2, 25, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Finesse"));

        this.getEquipment().add(new Weapon("Scimitar", "A curved, slashing blade.", 3, 25, "gp", new int[]{1, 6},
                Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Finesse, Light"));

        this.getEquipment().add(new Weapon("Shortsword", "A simple, versatile weapon with a sharp blade.", 2, 10,
                "gp", new int[]{1, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Finesse, Light"));

        this.getEquipment()
                .add(new Weapon("Trident", "A three-pronged spear designed for throwing.", 4, 5, "gp", new int[]{1, 6},
                        Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Warhammer", "A versatile weapon with a heavy head.", 2, 15, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d10)"));

        this.getEquipment().add(new Weapon("Whip", "A flexible weapon with a long reach.", 3, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Finesse, Reach"));

        this.getEquipment()
                .add(new Weapon("Blowgun", "A small tube used for blowing darts at a target.", 1, 10, "gp",
                        new int[]{1}, Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 25/100), Loading"));

        this.getEquipment()
                .add(new Weapon("Crossbow, Hand", "A small, one-handed crossbow.", 3, 75, "gp", new int[]{1, 6},
                        Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 30/120), Light, Loading"));

        this.getEquipment()
                .add(new Weapon("Crossbow, Heavy", "A large, two-handed crossbow.", 18, 50, "gp", new int[]{1, 10},
                        Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 100/400), Heavy, Loading, Two-handed"));

        this.getEquipment()
                .add(new Weapon("Longbow", "A large bow suitable for long-range attacks.", 2, 50, "gp",
                        new int[]{1, 8}, Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 150/600), Heavy, Two-handed"));

        this.getEquipment()
                .add(new Weapon("Net", "A mesh of woven ropes designed to restrain targets.", 3, 1, "gp", new int[]{0},
                        Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.BLUDGEONING, "Special, Thrown (5/15)"));

        this.getEquipment().add(new Armor("Shield", "A protective piece of equipment worn on the arm.", 6, 10, "gp",
                2, Armor.ArmorType.NONE, false));


        this.getEquipment()
                .add(new Weapon("Light Crossbow", "A small, one-handed crossbow.", 5, 25, "gp", new int[]{1, 8},
                        Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 80/320), Loading, Two-handed"));
        this.getEquipment()
                .add(new Misc("Bolts (20)", "A bundle of 20 projectiles designed for use with crossbows.", 1, 1, "gp"));

        this.getEquipment().add(new Weapon("Hand Axe's (2)", "A small, versatile axe.", 4, 10, "gp", new int[]{1, 6},
                Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Light, Thrown (20/60)"));


        this.getEquipment().add(new Misc("Dungeoneer's Pack",
                "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                29, 12, "gp"));

        this.getEquipment().add(new Misc("Explorer's Pack",
                "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                59, 10, "gp"));

    }

    void Monk() {
        setDex();
        setStr();
        setBaseHP(8);
        getProficiancy().set(1, "simple weapons, shortswords");
        getProficiancy().set(2, "artisan’s tools, musical instruments");

        this.getSkills().add("acrobatics");
        this.getSkills().add("athletics");
        this.getSkills().add("history");
        this.getSkills().add("insight");
        this.getSkills().add("religion");
        this.getSkills().add("stealth");
        this.skillCount = 2;

        this.equipmentString = "Pick a shortsword or any simple weapon,\n" +
                "then a dungeoneer’s pack or an explorer’s pack";
        this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light"));

        this.getEquipment()
                .add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4},
                        Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp", new int[]{1, 8},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Two-handed"));

        this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp", new int[]{1, 6},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (30/120)"));

        this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light"));

        this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp", new int[]{1, 6},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                new int[]{1, 1}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment()
                .add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp", new int[]{1, 8},
                        Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 80/320), Loading, Two-handed"));

        this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING, "Finesse, Thrown (20/60)"));

        this.getEquipment()
                .add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                        new int[]{1, 6}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 80/320), Two-handed"));

        this.getEquipment()
                .add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp", new int[]{1, 4},
                        Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.BLUDGEONING, "Ammunition (range 30/120)"));

        this.getEquipment().add(new Weapon("Shortsword", "A simple, versatile weapon with a sharp blade.", 2, 10, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Finesse, Light"));

        this.getEquipment().add(new Misc("Dungeoneer's Pack",
                "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                29, 12, "gp"));

        this.getEquipment().add(new Misc("Explorer's Pack",
                "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                59, 10, "gp"));

        this.getEquipmentGiven().add(new Misc("Dart (10)", "A set of 10 small, throwable projectiles.", 0, 5, "cp"));
    }

    void Paladin() {
        setWis();
        setCha();
        setBaseHP(10);
        getProficiancy().set(0, "all armor, shields");
        getProficiancy().set(1, "simple weapons, martial weapons");
        this.getSkills().add("athletics");
        this.getSkills().add("insight");
        this.getSkills().add("intimidation");
        this.getSkills().add("medicine");
        this.getSkills().add("persuasion");
        this.getSkills().add("religion");
        this.skillCount = 2;
        int loopCase;

        this.equipmentString = "Pick a martial weapon and a shield or two martial weapons,\n" +
                "then five javelins or any simple melee weapon, also a priest’s pack or an explorer’s pack";
        this.getEquipment().add(new Weapon("Battleaxe", "A versatile weapon with a keen edge.", 4, 10, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Versatile (1d10)"));

        this.getEquipment().add(new Weapon("Flail", "A spiked chain with a heavy ball at the end.", 2, 10, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment()
                .add(new Weapon("Glaive", "A long-handled weapon with a single-edged blade at the end.", 6, 20, "gp",
                        new int[]{1, 10}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING,
                        "Heavy, Reach, Two-handed"));

        this.getEquipment().add(new Weapon("Greataxe", "A massive axe with a large, heavy head.", 7, 30, "gp",
                new int[]{1, 12}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Heavy, Two-handed"));

        this.getEquipment().add(new Weapon("Greatsword", "A large, two-handed sword with a sharp blade.", 6, 50, "gp",
                new int[]{2, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Heavy, Two-handed"));

        this.getEquipment()
                .add(new Weapon("Halberd", "A long-handled weapon with an axe blade and a spear point.", 6, 20, "gp",
                        new int[]{1, 10}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING,
                        "Heavy, Reach, Two-handed"));

        this.getEquipment().add(new Weapon("Lance", "A long, narrow weapon used for mounted combat.", 6, 10, "gp",
                new int[]{1, 12}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Reach, Special"));

        this.getEquipment()
                .add(new Weapon("Longsword", "A versatile and balanced weapon with a sharp blade.", 3, 15, "gp",
                        new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Versatile (1d10)"));

        this.getEquipment().add(new Weapon("Maul", "A large, heavy hammer with a powerful blow.", 10, 10, "gp",
                new int[]{2, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.BLUDGEONING, "Heavy, Two-handed"));

        this.getEquipment().add(new Weapon("Morningstar", "A spiked weapon with a heavy, blunt head.", 4, 15, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, ""));

        this.getEquipment()
                .add(new Weapon("Pike", "A long, pointed polearm with a sharp tip.", 18, 5, "gp", new int[]{1, 10},
                        Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Heavy, Reach, Two-handed"));

        this.getEquipment().add(new Weapon("Rapier", "A slender, piercing weapon with a sharp point.", 2, 25, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Finesse"));

        this.getEquipment().add(new Weapon("Scimitar", "A curved, slashing blade.", 3, 25, "gp", new int[]{1, 6},
                Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Finesse, Light"));

        this.getEquipment().add(new Weapon("Shortsword", "A simple, versatile weapon with a sharp blade.", 2, 10,
                "gp", new int[]{1, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Finesse, Light"));

        this.getEquipment()
                .add(new Weapon("Trident", "A three-pronged spear designed for throwing.", 4, 5, "gp", new int[]{1, 6},
                        Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Warhammer", "A versatile weapon with a heavy head.", 2, 15, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d10)"));

        this.getEquipment().add(new Weapon("Whip", "A flexible weapon with a long reach.", 3, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.SLASHING, "Finesse, Reach"));

        this.getEquipment()
                .add(new Weapon("Blowgun", "A small tube used for blowing darts at a target.", 1, 10, "gp",
                        new int[]{1}, Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 25/100), Loading"));

        this.getEquipment()
                .add(new Weapon("Crossbow, Hand", "A small, one-handed crossbow.", 3, 75, "gp", new int[]{1, 6},
                        Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 30/120), Light, Loading"));

        this.getEquipment()
                .add(new Weapon("Crossbow, Heavy", "A large, two-handed crossbow.", 18, 50, "gp", new int[]{1, 10},
                        Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 100/400), Heavy, Loading, Two-handed"));

        this.getEquipment()
                .add(new Weapon("Longbow", "A large bow suitable for long-range attacks.", 2, 50, "gp",
                        new int[]{1, 8}, Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.PIERCING,
                        "Ammunition (range 150/600), Heavy, Two-handed"));

        this.getEquipment()
                .add(new Weapon("Net", "A mesh of woven ropes designed to restrain targets.", 3, 1, "gp", new int[]{0},
                        Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.BLUDGEONING, "Special, Thrown (5/15)"));

        this.getEquipment().add(new Armor("Shield", "A protective piece of equipment worn on the arm.", 6, 10, "gp",
                2, Armor.ArmorType.NONE, false));


        this.getEquipment().add(new Weapon("Javelin's (5)", "A light spear designed for throwing.", 10, 50, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (30/120)"));

        this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light"));

        this.getEquipment()
                .add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4},
                        Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp", new int[]{1, 8},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Two-handed"));

        this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp", new int[]{1, 6},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light"));

        this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp", new int[]{1, 6},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (20/60), Versatile (1d8)"));

        this.getEquipment().add(new Misc("Explorer's Pack",
                "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                59, 10, "gp"));

        this.getEquipment().add(new Misc("Priest's Pack",
                "Includes a backpack, a blanket, 10 candles, a tinderbox, an alms box, a block of incense, a censer, vestments, 2 days of rations, and a waterskin.",
                19, 10, "gp"));


        this.getEquipmentGiven().add(new Armor("Chainmail",
                "A flexible type of armor made of interlocking metal rings.",
                55, 75, "gp", 16, ArmorType.HEAVY, true));
        this.getEquipmentGiven().add(new Misc("Holy Symbol",
                "A holy symbol designed to reflect and channel your faith.",
                0, 0, "gp"));
    }

    void Ranger() {
        setDex();
        setStr();
        setBaseHP(10);
        getProficiancy().set(0, "Light armor");
        getProficiancy().set(1, "Simple weapons, martial weapons");
        this.getSkills().add("animal_handling");
        this.getSkills().add("athletics");
        this.getSkills().add("insight");
        this.getSkills().add("investigation");
        this.getSkills().add("nature");
        this.getSkills().add("perception");
        this.getSkills().add("stealth");
        this.getSkills().add("survival");
        this.skillCount = 3;


        this.equipmentString = "Pick scale mail or leather armor,\n" +
                "then two shortswords or two simple melee weapons, finally a dungeoneer’s pack or an explorer’s pack";
        this.getEquipment().add(new Weapon("Shortsword", "A versatile and finesse melee weapon.", 2, 10, "gp",
                new int[]{1, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Finesse, Light"));

        this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light"));

        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Two-handed"));

        this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (30/120)"));

        this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING,
                "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light"));

        this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Thrown (20/60), Versatile (1d8)"));


        this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Loading, Two-handed"));

        this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Finesse, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Two-handed"));

        this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.BLUDGEONING,
                "Ammunition (range 30/120)"));

        this.getEquipment().add(new Armor("Scale Mail", "Heavy armor made of interlocking metal scales.", 45, 50, "gp",
                14, ArmorType.HEAVY, true));

        this.getEquipment().add(new Armor("Leather Armor", "Light armor made from tanned animal hides.", 10, 10, "gp",
                11, ArmorType.LIGHT, false));

        this.getEquipment().add(new Misc("Dungeoneer's Pack",
                "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                29, 12, "gp"));

        this.getEquipment().add(new Misc("Explorer's Pack",
                "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                59, 10, "gp"));

        this.getEquipmentGiven().add(new Weapon("Longbow", "A powerful ranged weapon with great accuracy with 20 arrows.", 2, 50, "gp",
                new int[]{1, 8}, Weapon.WeaponType.MARTIAL_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 150/600), Heavy, Two-handed"));

    }

    void Rogue() {
        setDex();
        setInt();
        setBaseHP(8);
        getProficiancy().set(0, "Light armor");
        getProficiancy().set(1, "Simple weapons, hand crossbows, longswords, rapiers, shortswords");
        getProficiancy().set(2, "Thieves’ tools");

        this.getSkills().add("acrobatics");
        this.getSkills().add("athletics");
        this.getSkills().add("deception");
        this.getSkills().add("insight");
        this.getSkills().add("intimidation");
        this.getSkills().add("investigation");
        this.getSkills().add("perception");
        this.getSkills().add("performance");
        this.getSkills().add("persuasion");
        this.getSkills().add("sleight_of_hand");
        this.getSkills().add("stealth");
        this.skillCount = 4;

        this.equipmentString = "Pick a rapier or a shortsword,\n" +
                "then a shortbow or a shortsword,\n" +
                "also a burglar’s pack, a dungeoneer’s pack, or an explorer’s pack";
        this.getEquipment()
                .add(new Weapon("Rapier", "A slender, sharply-pointed sword suitable for thrusting attacks.", 2, 25, "gp",
                        new int[]{1, 8}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Finesse"));

        this.getEquipment().add(new Weapon("Shortsword", "A small, versatile sword.", 2, 10, "gp",
                new int[]{1, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Finesse, Light"));

        this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks with 20 arrows.", 2, 25, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Two-handed"));

        this.getEquipment().add(new Weapon("Shortsword", "A small, versatile sword.", 2, 10, "gp",
                new int[]{1, 6}, Weapon.WeaponType.MARTIAL_MELEE, Weapon.AttackType.PIERCING, "Finesse, Light"));


        this.getEquipment().add(new Misc("Burglar's Pack",
                "Includes a backpack, a crowbar, a set of dark common clothes including a hood, a belt pouch, a set of thieves' tools, and a candle.",
                16, 16, "gp"));

        this.getEquipment().add(new Misc("Dungeoneer's Pack",
                "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, and a waterskin.",
                61, 12, "gp"));

        this.getEquipment().add(new Misc("Explorer's Pack",
                "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                59, 10, "gp"));

        this.getEquipmentGiven().add(new Armor("Leather Armor", "Light armor made from tanned animal hides.", 10, 10, "gp", 11,
                ArmorType.LIGHT, false));
        this.getEquipmentGiven().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));
        this.getEquipmentGiven().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));
        this.getEquipmentGiven()
                .add(new Misc("Thieves' Tools", "A set of tools for picking locks and disabling traps.", 1, 25, "gp"));

    }

    void Sorcerer() {
        setDex();
        setCon();
        setBaseHP(6);
        getProficiancy().set(1, "Daggers, darts, slings, quarterstaffs, light crossbows");

        this.getSkills().add("arcana");
        this.getSkills().add("deception");
        this.getSkills().add("insight");
        this.getSkills().add("intimidation");
        this.getSkills().add("persuasion");
        this.getSkills().add("religion");
        this.skillCount = 2;
        this.cantripCount = 4;
        this.spellCount = 2;

    this.equipmentString = "Pick a light crossbow or any simple weapon,\n" +
            "then a component pouch or an arcane focus,\n" +
            "also a dungeoneer’s pack or an explorer’s pack.";
        this.getEquipment().add(new Weapon("Light Crossbow", "A small, one-handed crossbow with 20 bolts.", 5, 25, "gp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Loading, Two-handed"));

        this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light"));

        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Two-handed"));

        this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (30/120)"));

        this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING,
                "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light"));

        this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Thrown (20/60), Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                new int[]{1, 1}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Loading, Two-handed"));

        this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING, "Finesse, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Two-handed"));

        this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.BLUDGEONING,
                "Ammunition (range 30/120)"));

        this.getEquipment().add(new Misc("Component Pouch",
                "A small, watertight leather belt pouch for holding spell components.", 2, 25, "gp"));

        this.getEquipment().add(new Misc("Arcane Focus",
                "A crystal, an orb, a rod, a specially constructed staff, or some similar item designed to channel the power of arcane spells.",
                1, 10, "gp"));

        this.getEquipment().add(new Misc("Dungeoneer's Pack",
                "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                29, 12, "gp"));

        this.getEquipment().add(new Misc("Explorer's Pack",
                "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                59, 10, "gp"));
        this.getEquipmentGiven().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));
        this.getEquipmentGiven().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));
    }

    void Warlock() {
        setWis();
        setCha();
        setBaseHP(8);
        getProficiancy().set(0, "Light armor");
        getProficiancy().set(1, "Simple weapons");

        this.getSkills().add("arcana");
        this.getSkills().add("deception");
        this.getSkills().add("history");
        this.getSkills().add("intimidation");
        this.getSkills().add("investigation");
        this.getSkills().add("nature");
        this.getSkills().add("religion");
        this.skillCount = 2;
        this.cantripCount = 2;
        this.spellCount = 2;

        this.equipmentString = "Pick a light crossbow or any simple weapon,\n" +
                "then a component pouch or an arcane focus,\n" +
                "also a dungeoneer’s pack or an explorer’s pack.";
        this.getEquipment().add(new Weapon("Light Crossbow", "A small, one-handed crossbow with 20 bolts.", 5, 25, "gp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Loading, Two-handed"));

        this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light"));

        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Two-handed"));

        this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (30/120)"));

        this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING,
                "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light"));

        this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Thrown (20/60), Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                new int[]{1, 1}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Loading, Two-handed"));

        this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING, "Finesse, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Two-handed"));

        this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.BLUDGEONING,
                "Ammunition (range 30/120)"));

        this.getEquipment().add(new Misc("Component Pouch",
                "A small, watertight leather belt pouch for holding spell components.", 2, 25, "gp"));

        this.getEquipment().add(new Misc("Arcane Focus",
                "A crystal, an orb, a rod, a specially constructed staff, or some similar item designed to channel the power of arcane spells.",
                1, 10, "gp"));

        this.getEquipment().add(new Misc("Scholar's Pack",
                "Includes a backpack, a book of lore, a bottle of ink, an ink pen, 10 sheets of parchment, a little bag of sand, and a small knife.",
                40, 40, "gp"));

        this.getEquipment().add(new Misc("Dungeoneer's Pack",
                "Includes a backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, and a waterskin.",
                61, 12, "gp"));


        this.getEquipment().add(new Weapon("Club", "A basic wooden club.", 2, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Light"));

        this.getEquipment().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Finesse, Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Greatclub", "A large, heavy wooden club.", 10, 2, "sp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Two-handed"));

        this.getEquipment().add(new Weapon("Handaxe", "A small, versatile axe.", 2, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Javelin", "A light spear designed for throwing.", 2, 5, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Thrown (30/120)"));

        this.getEquipment().add(new Weapon("Light Hammer", "A light throwing hammer.", 2, 2, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING,
                "Light, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Mace", "A simple, effective bludgeoning weapon.", 4, 5, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Sickle", "A small, curved blade designed for cutting plants.", 2, 1, "gp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.SLASHING, "Light"));

        this.getEquipment().add(new Weapon("Spear", "A simple, versatile weapon.", 3, 1, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING,
                "Thrown (20/60), Versatile (1d8)"));

        this.getEquipment().add(new Weapon("Unarmed Strike", "A punch, kick, or other simple unarmed attack.", 0, 0, "",
                new int[]{1, 1}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, ""));

        this.getEquipment().add(new Weapon("Crossbow, Light", "A small, one-handed crossbow.", 5, 25, "gp",
                new int[]{1, 8}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Loading, Two-handed"));

        this.getEquipment().add(new Weapon("Dart", "A small, throwable projectile.", 0, 5, "cp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING, "Finesse, Thrown (20/60)"));

        this.getEquipment().add(new Weapon("Shortbow", "A small bow suitable for short-range attacks.", 2, 25, "gp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.PIERCING,
                "Ammunition (range 80/320), Two-handed"));

        this.getEquipment().add(new Weapon("Sling", "A simple leather sling for hurling projectiles.", 0, 1, "sp",
                new int[]{1, 4}, Weapon.WeaponType.SIMPLE_RANGE, Weapon.AttackType.BLUDGEONING,
                "Ammunition (range 30/120)"));

        this.getEquipmentGiven().add(new Armor("Leather Armor", "Light, flexible armor made from animal hides.", 10, 10, "gp",
                11, ArmorType.LIGHT, false));
        this.getEquipmentGiven().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
        this.getEquipmentGiven().add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));
    }

    void Wizard() {
        setWis();
        setInt();
        setBaseHP(6);
        getProficiancy().set(1, "Daggers, darts, slings, quarterstaffs, light crossbows");

        this.getSkills().add("arcana");
        this.getSkills().add("history");
        this.getSkills().add("insight");
        this.getSkills().add("investigation");
        this.getSkills().add("medicine");
        this.getSkills().add("religion");
        this.skillCount = 2;
        this.cantripCount = 3;
        this.spellCount = 2;

        his.equipmentString = "Pick a quarterstaff or a dagger,\n" +
                "then a component pouch or an arcane focus, also a scholar’s pack or an explorer’s pack";
        this.getEquipment().add(new Weapon("Quarterstaff", "A versatile, two-handed staff.", 4, 2, "sp",
                new int[]{1, 6}, Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.BLUDGEONING, "Versatile (1d8)"));

            .add(new Weapon("Dagger", "A small, easily concealable knife.", 1, 2, "gp", new int[]{1, 4},
                Weapon.WeaponType.SIMPLE_MELEE, Weapon.AttackType.PIERCING, "Finesse, Light, Thrown (20/60)"));


        this.getEquipment().add(new Misc("Component Pouch",
                "A small, watertight leather belt pouch containing various spell components.", 2, 25, "gp"));

        this.getEquipment().add(new Misc("Arcane Focus",
                "A crystal, an orb, a rod, a specially constructed staff, a wand-like length of wood, or some similar item.",
                1, 10, "gp"));

        this.getEquipment().add(new Misc("Scholar's Pack",
                "Includes a backpack, a book of lore, a bottle of ink, an ink pen, 10 sheets of parchment, a little bag of sand, and a small knife.",
                20, 40, "gp"));

        this.getEquipment().add(new Misc("Explorer's Pack",
                "Includes a backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, a waterskin, and 50 feet of hempen rope.",
                59, 10, "gp"));

        this.getEquipmentGiven().add(new Misc("Spellbook",
                "A book containing arcane symbols and formulas used by wizards to prepare their spells.", 3, 50, "gp"));
    }
}
