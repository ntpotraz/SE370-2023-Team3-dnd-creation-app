import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

abstract class Race { // TODO decisions that add spells
    private String ageRange;
    private int speed;
    private ArrayList<String> languages = new ArrayList<>();
    private ArrayList<String> proficiencies = new ArrayList<>(); // Index 0 = Armor, 1 = Weapons, = 2 = Tools
    private int[] statMods = { 0, 0, 0, 0, 0, 0 }; // Index 0 = strength, 1 = dexterity, 2 = constitution, 3 =
                                                   // intelligence, 4 = wisdom, 5 = charisma

    public enum Size {
        SMALL,
        MEDIUM
    }

    private Size size;
    private ArrayList<String> traits = new ArrayList<>(); // Temporary misc. traits for things like darkvision,
                                                          // resistances, etc.
    private ArrayList<String> skills = new ArrayList<>();

    Race() {
        proficiencies.add("");
        proficiencies.add("");
        proficiencies.add("");
        languages.add("Common, ");
        setSize("MEDIUM");
        setSpeed(30);
        this.raceQuestions();
    }

    public static Race createRace(String type) {
        type = type.toLowerCase();
        switch (type) {
            case "hilldwarf":
                return new HillDwarf();
            case "mountaindwarf":
                return new MountainDwarf();
            case "highelf":
                return new HighElf();
            case "woodelf":
                return new WoodElf();
            case "darkelf":
                return new DarkElf();
            case "lightfoot":
                return new Lightfoot();
            case "stout":
                return new Stout();
            case "human":
                return new Human();
            case "dragonborn":
                return new Dragonborn();
            case "forestgnome":
                return new ForestGnome();
            case "rockgnome":
                return new RockGnome();
            case "halfelf":
                return new HalfElf();
            case "halforc":
                return new HalfOrc();
            case "tiefling":
                return new Tiefling();
            default:
                return new Human();
        }
    }

    // getters and setters vvv
    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int[] getStatMods() {
        return statMods;
    }

    public void setStatMods(int index, int mod) {
        this.statMods[index] += mod;
    }

    public void printStatMods() {
        for (int i = 0; i < 6; i++) {
            System.out.println(this.statMods[i]);
        }
    }

    public Size getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size == "MEDIUM") {
            this.size = Size.MEDIUM;
        } else if (size == "SMALL") {
            this.size = Size.SMALL;
        } else {
            System.out.println("A size error has been made.");
        }
    }

    public void printSize() {
        System.out.println(this.getSize());
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(String language) {
        this.languages.add(language);
    }

    public void printLanguages() {
        System.out.print("Languages: ");
        for (int i = 0; i < this.languages.size(); i++) {
            System.out.print(this.getLanguages().get(i));
        }
        System.out.print("\n");
    }

    public ArrayList<String> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(int index, String proficiency) {
        this.proficiencies.set(index, proficiency);
    }

    public void printProficiencies() {
        for (int i = 0; i < 3; i++) {
            System.out.print(this.getProficiencies().get(i));
        }
    }

    public ArrayList<String> getTraits() {
        return traits;
    }

    public void setTraits(String trait) {
        this.traits.add(trait);
    }

    public void printTraits() {
        for (int i = 0; i < this.traits.size(); i++) {
            System.out.println(this.traits.get(i));
        }
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(String input) {
        this.skills.add(input);
    }

    public void printSkills() {
        System.out.println("Skill Proficiencies:");
        for (int i = 0; i < this.skills.size(); i++) {
            System.out.println(this.skills.get(i));
        }
    }

    // Added this since 'this.raceQuestions()' was throwing an error in the
    // constructor
    public void raceQuestions() {
        System.out.println("Race not selected");
    }

    public static void main(String[] args) throws Exception {
        // Area for testing code

    }
}

/*
 * Race classes are organized as follows:
 * - stat changes
 * - speed
 * - size
 * - age ranges
 * - proficiencies
 * - languages
 * - misc. traits
 * - raceQuestions function
 */

// Dwarf v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

abstract class Dwarf extends Race {
    Dwarf() {
        this.setStatMods(2, 2);
        this.setSpeed(25);
        this.setAgeRange("Dwarves mature at 50, and live to around 350.");
        this.setProficiencies(1, "Battleaxe, Handaxe, Throwing Hammer, Warhammer, ");
        this.setLanguages("Dwarvish");
        this.setTraits("- Darkvision: Accustomed to life underground, you\r\n" +
                "have superior vision in dark and dim conditions. You\r\n" +
                "can see in dim light within 60 feet of you as if it were\r\n" +
                "bright light, and in darkness as if it were dim light. You\r\n" +
                "can't discern color in darkness, only shades of gray.");
        this.setTraits("- Dwarven Resilience: You have advantage on saving\r\n" +
                "throws against poison, and you have resistance against\r\n" +
                "poison damage.");
    }

    public void raceQuestions() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose one tool proficiency in smithing(s), brewing(b), or masonry(m).");
        Boolean correctString = false;
        while (correctString == false) {
            String input = scan.nextLine();
            if (Objects.equals(input, "s")) {
                this.setProficiencies(2, "Smithing Tools");
                correctString = true;
            } else if (Objects.equals(input, "b")) {
                this.setProficiencies(2, "Brewing Tools");
                correctString = true;
            } else if (Objects.equals(input, "m")) {
                this.setProficiencies(2, "Masons Tools");
                correctString = true;
            } else {
                System.out.println("That isn't an option. Try again.");
            }
        }
        scan.close();
    }

}

class HillDwarf extends Dwarf {
    HillDwarf() {
        this.setStatMods(4, 1);
    }

    int hillDwarfHP = 1; // Note: hill dwarf is only class that adds 1 to hp
}

class MountainDwarf extends Dwarf {
    MountainDwarf() {
        this.setStatMods(0, 2);
        this.setProficiencies(0, "Light armor, medium armor");
    }
}

// Elf v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

abstract class Elf extends Race {
    Elf() {
        this.setStatMods(1, 2);
        this.setAgeRange("Elves mature at 100, and live to around 750.");
        this.setSkills("perception");
        this.setLanguages("Elvish");
        this.setTraits("- Darkvision: Accustom ed to twilit forests and the night\n" +
                "sky, you have superior vision in dark and dim conditions.\n" +
                "You can see in dim light within 60 feet of you as if it\n" +
                "were bright light, and in darkness as if it were dim light.\n" +
                "You can't discern color in darkness, only shades of gray");
        this.setTraits("- Fey Ancestry: You have advantage on saving throws\n" +
                "against being charmed, and magic can't put you to sleep.");
        this.setTraits("- Trance: Elves don't need to sleep. Instead, they\n" +
                "meditate deeply, remaining semiconscious, for 4\n" +
                "hours a day. (The Common word for such meditation\n" +
                "is “trance.”) While meditating, you can dream after a\n" +
                "fashion; such dreams are actually mental exercises that\n" +
                "have become reflexive through years of practice. After\n" +
                "resting in this way, you gain the same benefit that a\n" +
                "human does from 8 hours of sleep.");

    }
}

class HighElf extends Elf {
    HighElf() {
        this.setStatMods(3, 1);
        this.setProficiencies(1, "Longsword, Shortsword, Shortbow, Longbow");

        // TODO: Cantrip: choose one cantrip from the wizard spell list
    }

    public void raceQuestions() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What additional language would you like to learn? Pre-existing languages are:");
        System.out.println("Dwarvish, Giant, Gnomish, Goblin, Halfling, Orc,\n" +
                "Abyssal, Celestial, Draconic, Deep Speech, Infernal, Primordial, Sylvan, and Undercommon.");
        String input = scan.nextLine();
        this.setLanguages(input);
        scan.close();
    }
}

class WoodElf extends Elf {
    WoodElf() {
        this.setStatMods(4, 1);
        this.setSpeed(35);
        this.setProficiencies(1, "Longsword, Shortsword, Shortbow, Longbow");
        this.setTraits("- Mask of the Wild: You can attempt to hide even when\n" +
                "you are only lightly obscured by foliage, heavy rain,\n" +
                "falling snow, mist, and other natural phenomena.");

    }
}

class DarkElf extends Elf {
    DarkElf() {
        this.setStatMods(5, 1);
        this.setProficiencies(1, "Rapiers, Shortswords, Hand Crossbows");
        this.setTraits("- Superior Darkvision Your darkvision has a\n" +
                "radius of 120 feet.");
        this.setTraits("- Sunlight Sensitivity: You have disadvantage on attack\n" +
                "rolls and on Wisdom (Perception) checks that rely on\n" +
                "sight when you, the target of your attack, or whatever\n" +
                "you are trying to perceive is in direct sunlight.");
        this.setTraits("- Drow Magic: You know the dancing lights cantrip.\n" +
                "When you reach 3rd level, you can cast the faerie fire\n" +
                "spell once per day. When you reach 5th level, you can\n" +
                "also cast the darkness spell once per day. Charisma is\n" + // TODO: this trait adds dancing lights to
                                                                             // the players spell list
                "your spellcasting ability for these spells.");
    }
}

// Halfling v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

abstract class Halfling extends Race {
    Halfling() {
        this.setStatMods(1, 2);
        this.setSpeed(25);
        this.setSize("SMALL");
        this.setAgeRange("Halflings mature at 20, and live to around 200,");
        this.setLanguages("Halfling");
        this.setTraits("- Lucky: When you roll a 1 on an attack roll, ability\r\n" + //
                "check, or saving throw, you can reroll the die and must\r\n" + //
                "use the new roll");
        this.setTraits("- Brave: You have advantage on saving throws against\r\n" + //
                "being frightened.");
        this.setTraits("- Halfling Nimbleness: You can move through the\r\n" + //
                "space of any creature that is of a size larger than yours");
    }
}

class Lightfoot extends Halfling {
    Lightfoot() {
        this.setStatMods(5, 1);
        this.setTraits("Naturally Stealthy. You can attempt to hide even\r\n" + //
                "when you are obscured only by a creature that is at least\r\n" + //
                "one size larger than you");
    }
}

class Stout extends Halfling {
    Stout() {
        this.setStatMods(2, 1);
        this.setTraits("Stout Resilience. You have advantage on saving\r\n" + //
                "throws against poison, and you have resistance\r\n" + //
                "against poison damage");
    }
}

// Human v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

class Human extends Race {
    Human() {
        for (int i = 0; i < 6; i++) {
            this.setStatMods(i, 1);
        }
        this.setAgeRange("Humans mature at 18, and live to around 80.");
    }

    public void raceQuestions() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What additional language would you like to learn? Pre-existing languages are:");
        System.out.println("Dwarvish, Elvish, Giant, Gnomish, Goblin, Halfling, Orc,\n" +
                "Abyssal, Celestial, Draconic, Deep Speech, Infernal, Primordial, Sylvan, and Undercommon.");
        String input = scan.nextLine();
        this.setLanguages(input);
        scan.close();
    }
}

// TODO: Optional, add in variant human

// Dragonborn v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

class Dragonborn extends Race {
    Dragonborn() {

        this.setStatMods(0, 2);
        this.setStatMods(5, 1);
        this.setAgeRange("Dragonborn mature at 15, and live to around 80.");
        this.setLanguages("Draconic");
        this.setTraits("- Breath Weapon: You can use your action to exhale\r\n" + //
                "destructive energy. Your draconic ancestry determines\r\n" + //
                "the size, shape, and damage type of the exhalation.\r\n" + //
                "When you use your breath weapon, each creature in\r\n" + //
                "the area of the exhalation must make a saving throw,\r\n" + //
                "the type of which is determined by your draconic\r\n" + //
                "ancestry. The DC for this saving throw equals 8 +\r\n" + //
                "your Constitution modifier + your proficiency bonus. A\r\n" + //
                "creature takes 2d6 damage on a failed save, and half\r\n" + //
                "as much damage on a successful one. The damage\r\n" + //
                "increases to 3d6 at 6th level, 4d6 at 11th level, and 5d6\r\n" + //
                "at 16th level");
        this.setTraits("- Damage Resistance: You have resistance to the\r\n" + //
                "damage type associated with your draconic ancestry.");

    }

    public void raceQuestions() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your Draconic Ancestry?"); // Make draconic ancestry matrix
        String[][] rows = { { "Black", "Blue", "Brass", "Bronze", "Copper", "Gold", "Green", "Red", "Silver", "White" },
                { "Acid", "Lightning", "Fire", "Lightning", "Acid", "Fire", "Poison", "Fire", "Cold", "Cold" },
                { "5 by 30ft line (Dex save)", "5 by 30ft line (Dex save)", "5 by 30ft line (Dex save)",
                        "5 by 30ft line (Dex save)", "5 by 30ft line (Dex save)", "15ft cone (Con save)",
                        "15ft cone (Con save)", "15ft cone (Con save)", "15ft cone (Con save)",
                        "15ft cone (Con save)" } };
        for (int i = 0; i < 10; i++) {
            System.out.print(rows[0][i] + " | ");
            System.out.print(rows[1][i] + " | ");
            System.out.print(rows[2][i] + "\n" + "\n");
        }
        String input = scan.nextLine();
        input = input.toLowerCase();
        switch (input) {
            case "black":
                this.setTraits("- Black Draconic Ancestry: Your breath weapon and resistance is acid.");
                break;
            case "blue":
                this.setTraits("- Blue Draconic Ancestry: Your breath weapon and resistance is lightning.");
                break;
            case "brass":
                this.setTraits("- Brass Draconic Ancestry: Your breath weapon and resistance is fire.");
                break;
            case "bronze":
                this.setTraits("- Bronze Draconic Ancestry: Your breath weapon and resistance is lightning.");
                break;
            case "copper":
                this.setTraits("- Copper Draconic Ancestry: Your breath weapon and resistance is acid.");
                break;
            case "gold":
                this.setTraits("- Gold Draconic Ancestry: Your breath weapon and resistance is fire.");
                break;
            case "green":
                this.setTraits("- Green Draconic Ancestry: Your breath weapon and resistance is poison.");
                break;
            case "red":
                this.setTraits("- Red Draconic Ancestry: Your breath weapon and resistance is red.");
                break;
            case "silver":
                this.setTraits("- Silver Draconic Ancestry: Your breath weapon and resistance is cold.");
                break;
            case "white":
                this.setTraits("- White Draconic Ancestry: Your breath weapon and resistance is cold.");
                break;
            default:
                break;
        }
        scan.close();
    }
}

// Gnome v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

abstract class Gnome extends Race {
    Gnome() {
        this.setStatMods(3, 2);
        this.setSpeed(25);
        this.setSize("SMALL");
        this.setAgeRange("Gnomes mature at 18, and live to around 350-500.");
        this.setLanguages("Gnomish");
        this.setTraits("- Darkvision: Accustomed to life underground, you have\r\n" + //
                "superior vision in dark and dim conditions. You can\r\n" + //
                "see in dim light within 60 feet of you as if it were bright\r\n" + //
                "light, and in darkness as if it were dim light. You can't\r\n" + //
                "discern color in darkness, only shades of gray");
        this.setTraits("- Gnome Cunning: You have advantage on all\r\n" + //
                "Intelligence, Wisdom , and Charisma saving throws\r\n" + //
                "against magic");
    }
}

class ForestGnome extends Gnome {
    ForestGnome() {
        this.setStatMods(1, 1);

        // TODO: adds minor illusion to spell list

        this.setTraits("- Speak with Small Beasts: Through sounds and\r\n" + //
                "gestures, you can communicate simple ideas with Small\r\n" + //
                "or smaller beasts. Forest gnomes love animals and often\r\n" + //
                "keep squirrels, badgers, rabbits, moles, woodpeckers,\r\n" + //
                "and other creatures as beloved pets");
    }
}

class RockGnome extends Gnome {
    RockGnome() {
        this.setStatMods(2, 1);
        this.setProficiencies(2, "Artisian's tools");
        this.setTraits("- Artificer's Lore: Whenever you make an Intelligence\r\n" + //
                "(History) check related to magic items, alchemical\r\n" + //
                "objects, or technological devices, you can add twice your\r\n" + //
                "proficiency bonus, instead of any proficiency bonus you\r\n" + //
                "normally apply");
        this.setTraits("- Tinker: You have proficiency with artisan's tools\r\n" + //
                "(tinker's tools). Using those tools, you can spend 1\r\n" + //
                "hour and 10 gp worth of materials to construct a Tiny\r\n" + //
                "clockwork device (AC 5, 1 hp). The device ceases\r\n" + //
                "to function after 24 hours (unless you spend 1 hour\r\n" + //
                "repairing it to keep the device functioning), or when\r\n" + //
                "you use your action to dismantle it; at that time, you can\r\n" + //
                "reclaim the materials used to create it. You can have up\r\n" + //
                "to three such devices active at a time.\r\n" + //
                "When you create a device, choose one of the\r\n" + //
                "following options:\r\n" + //
                "Clockwork Toy. This toy is a clockwork animal, monster,\r\n" + //
                "or person, such as a frog, mouse, bird, dragon, or\r\n" + //
                "soldier. When placed on the ground, the toy moves\r\n" + //
                "5 feet across the ground on each of your turns in a\r\n" + //
                "random direction. It makes noises as appropriate\r\n" + //
                "to the creature it represents.\r\n" + //
                "Fire Starter. The device produces a miniature\r\n" + //
                "flame, which you can use to light a candle,\r\n" + //
                "torch, or campfire. Using the device\r\n" + //
                "requires your action.\r\n" + //
                "Music Box. When opened, this music box\r\n" + //
                "plays a single song at a moderate volume.\r\n" + //
                "The box stops playing when it\r\n" + //
                "reaches the song's end or\r\n" + //
                "when it is closed.");
    }
}

// HalfElf v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

class HalfElf extends Race {
    HalfElf() {
        this.setStatMods(5, 2);
        this.setAgeRange("Half Elves mature at 18, and live to around 180.");
        this.setLanguages("Elvish, ");
        this.setTraits("- Darkvision: Thanks to your elf blood, you have\r\n" + //
                "superior vision in dark and dim conditions. You can\r\n" + //
                "see in dim light within 60 feet of you as if it were bright\r\n" + //
                "light, and in darkness as if it were dim light. You can't\r\n" + //
                "discern color in darkness, only shades of gray");
        this.setTraits("- Fey Ancestry: You have advantage on saving throws\r\n" + //
                "against being charmed, and magic can't put you to sleep");
    }

    public void raceQuestions() {
        Scanner scan = new Scanner(System.in);
        // Increases 2 different stats by 1
        System.out.println("Pick first stat to increase by 1.");
        int index = scan.nextInt();
        this.chooseStats(index);
        System.out.println("Pick second stat to increase by 1.");
        int index2 = scan.nextInt();
        while (index == index2) {
            System.out.println("You cannot pick the same stat twice. Pick again.");
            index2 = scan.nextInt();
        }
        this.chooseStats(index2);

        // Chooses a language
        scan.nextLine();
        System.out.println("What additional language would you like to learn? Pre-existing languages are:");
        System.out.println("Dwarvish, Giant, Gnomish, Goblin, Halfling, Orc,\n" +
                "Abyssal, Celestial, Draconic, Deep Speech, Infernal, Primordial, Sylvan, and Undercommon.");
        String input = scan.nextLine();
        this.setLanguages(input);

        // Chooses 2 skills to become proficient in
        System.out.println("Possible skills are:");
        System.out.println("Athletics, Acrobatics, Sleight of Hand, Stealth, Arcana, History, Investigation, Nature,\n"
                +
                "Religion, Animal Handling, Insight, Medicine, Perception, Survival, Deception, Intimidation, Performance, and Persuasion.");
        System.out.println("Pick first skill to become proficient in.");
        String skill1 = scan.nextLine();
        skill1 = skill1.toLowerCase();
        skill1 = skillUnderline(skill1);
        this.setSkills(skill1);
        System.out.println("Pick second skill to become proficient in.");
        String skill2 = scan.nextLine();
        skill2 = skill2.toLowerCase();
        skill2 = skillUnderline(skill2);
        this.setSkills(skill2);
        scan.close();
    }

    public void chooseStats(int index) {
        this.getStatMods()[index] += 1;
    }

    public String skillUnderline(String skill) {
        switch (skill) {
            case "sleight of hand":
                skill = "sleight_of_hand";
                break;
            case "animal handling":
                skill = "animal_handling";
                break;
            default:
                break;
        }
        return skill;
    }
}

// HalfOrc v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

class HalfOrc extends Race {
    HalfOrc() {

        this.setStatMods(0, 2);
        this.setStatMods(2, 1);
        this.setAgeRange("Half Orcs mature at 14, and live to around 75.");
        this.setSkills("intimidation");
        this.setLanguages("Orc");
        this.setTraits("- Darkvision: Thanks to your orc blood, you have\r\n" + //
                "superior vision in dark and dim conditions. You can\r\n" + //
                "see in dim light within 60 feet of you as if it were bright\r\n" + //
                "light, and in darkness as if it were dim light. You can't\r\n" + //
                "discern color in darkness, only shades of gray");
        this.setTraits("- Relentless Endurance: When you are reduced to\r\n" + //
                "0 hit points but not killed outright, you can drop to 1 hit\r\n" + //
                "point instead. You can't use this feature again until you\r\n" + //
                "finish a long rest.");
        this.setTraits("- Savage Attacks: When you score a critical hit with\r\n" + //
                "a melee weapon attack, you can roll one of the weapon's\r\n" + //
                "damage dice one additional time and add it to the extra\r\n" + //
                "damage of the critical hit");
    }
}

// Tiefling v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

class Tiefling extends Race {
    Tiefling() {
        this.setStatMods(3, 1);
        this.setStatMods(5, 2);
        this.setAgeRange("Tieflings mature at 18, and live to around 90.");
        this.setLanguages("Infernal");
        this.setTraits("- Darkvision: Thanks to your infernal heritage, you\r\n" + //
                "have superior vision in dark and dim conditions. You\r\n" + //
                "can see in dim light within 60 feet of you as if it were\r\n" + //
                "bright light, and in darkness as if it were dim light. You\r\n" + //
                "can't discern color in darkness, only shades of gray");
        this.setTraits("Hellish Resistance. You have resistance\r\n" + //
                "to fire damage");
        this.setTraits("- Infernal Legacy: You know the thaumaturgy cantrip.\r\n" + //
                "Once you reach 3rd level, you can cast the hellish\r\n" + // //TODO trait adds thamaturgy spell
                "rebuke spell once per day as a 2nd-level spell. Once you\r\n" + //
                "reach 5th level, you can also cast the darkness spell\r\n" + //
                "once per day. Charisma is your spellcasting ability for\r\n" + //
                "these spells");
    }
}
