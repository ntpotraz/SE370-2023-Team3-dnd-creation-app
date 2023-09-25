import java.util.ArrayList;

//TODO getters and setters
abstract class Race { // TODO race specific questions
                      // TODO add Languages
        String ageRange;
        int speed;
        ArrayList<String> proficiencies = new ArrayList<String>(); // Index 0 = Armor, 1 = Weapons, = 2 = Tools
        int[] statMods = { 0, 0, 0, 0, 0, 0 }; // Index 0 = strength, 1 = dexterity, 2 = constitution, 3 = intelligence,
                                               // 4 = wisdom, 5 = charisma

        enum Size {
                SMALL,
                MEDIUM
        }

        ArrayList<String> traits = new ArrayList<String>(); // Temporary misc. traits for things like darkvision,
                                                            // resistances, etc.

        Race() {
                proficiencies.add("");
                proficiencies.add("");
                proficiencies.add("");
        }

        public static void main(String[] args) throws Exception {
                // Area for testing code

        }
}

// Dwarf v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

abstract class Dwarf extends Race {
        Dwarf() {
                speed = 25;
                Size size = Size.MEDIUM;
                this.statMods[2] += 2;
                ageRange = "Dwarves mature at 50, and live to around 350.";
                proficiencies.set(1, "Battleaxe, Handaxe, Throwing Hammer, Warhammer");

                // TODO choose one, proficiency in smith, brewer, or mason's tools

                this.traits.add("- Darkvision: Accustomed to life underground, you\r\n" +
                                "have superior vision in dark and dim conditions. You\r\n" +
                                "can see in dim light within 60 feet of you as if it were\r\n" +
                                "bright light, and in darkness as if it were dim light. You\r\n" +
                                "can't discern color in darkness, only shades of gray.");
                this.traits.add("- Dwarven Resilience: You have advantage on saving\r\n" +
                                "throws against poison, and you have resistance against\r\n" +
                                "poison damage.");
        }

}

class HillDwarf extends Dwarf {
        HillDwarf() {
                this.statMods[4] += 1;
        }

        int hillDwarfHP = 1; // Note: hill dwarf is only class that adds 1 to hp
}

class MountainDwarf extends Dwarf {
        MountainDwarf() {
                this.statMods[0] += 2;
                this.proficiencies.set(0, "Light armor, medium armor");
        }
}

// Elf v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

abstract class Elf extends Race {
        Elf() {
                speed = 30;
                this.statMods[1] += 2;
                Size size = Size.MEDIUM;
                ageRange = "Elves mature at 100, and live to around 750.";
                this.traits.add("- Darkvision: Accustom ed to twilit forests and the night\n" +
                                "sky, you have superior vision in dark and dim conditions.\n" +
                                "You can see in dim light within 60 feet of you as if it\n" +
                                "were bright light, and in darkness as if it were dim light.\n" +
                                "You can’t discern color in darkness, only shades of gray");

                // TODO: Keen Senses, gives proficiency in perception

                this.traits.add("- Fey Ancestry: You have advantage on saving throws\n" +
                                "against being charmed, and magic can’t put you to sleep.");
                this.traits.add("- Trance: Elves don’t need to sleep. Instead, they\n" +
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
                this.statMods[3] = +1;
                this.proficiencies.set(1, "Longsword, Shortsword, Shortbow, Longbow");

                // TODO: Cantrip: choose one cantrip from the wizard spell list
                // TODO: Extra Language: choose 1 language to learn
        }
}

class WoodElf extends Elf {
        WoodElf() {
                this.statMods[4] += 1;
                this.proficiencies.set(1, "Longsword, Shortsword, Shortbow, Longbow");

                // TODO: Fleet of Foot: increase walking speed to 35

                this.traits.add("- Mask of the Wild: You can attempt to hide even when\n" +
                                "you are only lightly obscured by foliage, heavy rain,\n" +
                                "falling snow, mist, and other natural phenomena.");

        }
}

class DarkElf extends Elf {
        DarkElf() {
                this.statMods[5] += 1;
                this.traits.add("- Superior Darkvision Your darkvision has a\n" +
                                "radius of 120 feet.");
                this.traits.add("- Sunlight Sensitivity: You have disadvantage on attack\n" +
                                "rolls and on Wisdom (Perception) checks that rely on\n" +
                                "sight when you, the target of your attack, or whatever\n" +
                                "you are trying to perceive is in direct sunlight.");
                this.traits.add("- Drow Magic: You know the dancing lights cantrip.\n" +
                                "When you reach 3rd level, you can cast the faerie fire\n" +
                                "spell once per day. When you reach 5th level, you can\n" +
                                "also cast the darkness spell once per day. Charisma is\n" + // TODO: this trait adds
                                                                                             // dancing lights to the
                                                                                             // players spell list
                                "your spellcasting ability for these spells.");
                this.proficiencies.set(1, "Rapiers, Shortswords, Hand Crossbows");
        }
}

// Halfling v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

abstract class Halfling extends Race {
        Halfling() {
                this.statMods[1] += 2;
                ageRange = "Halflings mature at 20, and live to around 200,";
                Size size = Size.SMALL;
                speed = 25;
                this.traits.add("- Lucky: When you roll a 1 on an attack roll, ability\r\n" + //
                                "check, or saving throw, you can reroll the die and must\r\n" + //
                                "use the new roll");
                this.traits.add("- Brave: You have advantage on saving throws against\r\n" + //
                                "being frightened.");
                this.traits.add("- Halfling Nimbleness: You can move through the\r\n" + //
                                "space of any creature that is of a size larger than yours");

                // TODO Languages are common and halfling
        }
}

class Lightfoot extends Halfling {
        Lightfoot() {
                this.statMods[5] += 1;
                this.traits.add("Naturally Stealthy. You can attempt to hide even\r\n" + //
                                "when you are obscured only by a creature that is at least\r\n" + //
                                "one size larger than you");
        }
}

class Stout extends Halfling {
        Stout() {
                this.statMods[2] += 1;
                this.traits.add("Stout Resilience. You have advantage on saving\r\n" + //
                                "throws against poison, and you have resistance\r\n" + //
                                "against poison damage");
        }
}

// Human v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

class Human extends Race {
        Human() {
                for (int i = 0; i < 6; i++) {
                        this.statMods[i] += 1;
                }
                this.ageRange = "Humans mature at 18, and live to around 80.";
                Size size = Size.MEDIUM;
                speed = 30;

                // TODO languages are common, and pick one of your choosing
        }
}

// TODO: Optional, add in variant human

// Dragonborn v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

class Dragonborn extends Race {
        Dragonborn() {
                this.statMods[0] += 2;
                this.statMods[5] += 1;
                this.ageRange = "Dragonborn mature at 15, and live to around 80.";
                Size size = Size.MEDIUM;
                this.speed = 30;

                // TODO: Decision for draconic ancestry

                this.traits.add("- Breath Weapon: You can use your action to exhale\r\n" + //
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
                this.traits.add("- Damage Resistance: You have resistance to the\r\n" + //
                                "damage type associated with your draconic ancestry.");
                // TODO languages are common and draconic
        }
}

// Gnome v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

abstract class Gnome extends Race {
        Gnome() {
                this.statMods[3] += 2;
                this.ageRange = "Gnomes mature at 18, and live to around 350-500.";
                Size size = Size.SMALL;
                this.speed = 25;
                this.traits.add("- Darkvision: Accustomed to life underground, you have\r\n" + //
                                "superior vision in dark and dim conditions. You can\r\n" + //
                                "see in dim light within 60 feet of you as if it were bright\r\n" + //
                                "light, and in darkness as if it were dim light. You can't\r\n" + //
                                "discern color in darkness, only shades of gray");
                this.traits.add("- Gnome Cunning: You have advantage on all\r\n" + //
                                "Intelligence, Wisdom , and Charisma saving throws\r\n" + //
                                "against magic");
                // TODO languages are common and gnomish
        }
}

class ForestGnome extends Gnome {
        ForestGnome() {
                this.statMods[1] += 1;

                // TODO: adds minor illusion to spell list

                this.traits.add("- Speak with Small Beasts: Through sounds and\r\n" + //
                                "gestures, you can communicate simple ideas with Small\r\n" + //
                                "or smaller beasts. Forest gnomes love animals and often\r\n" + //
                                "keep squirrels, badgers, rabbits, moles, woodpeckers,\r\n" + //
                                "and other creatures as beloved pets");
        }
}

class RockGnome extends Gnome {
        RockGnome() {
                this.statMods[2] += 1;
                this.traits.add("- Artificer's Lore: Whenever you make an Intelligence\r\n" + //
                                "(History) check related to magic items, alchemical\r\n" + //
                                "objects, or technological devices, you can add twice your\r\n" + //
                                "proficiency bonus, instead of any proficiency bonus you\r\n" + //
                                "normally apply");
                this.traits.add("- Tinker: You have proficiency with artisan's tools\r\n" + //
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
                                "soldier. When placed on the ground, the toy m oves\r\n" + //
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
                this.proficiencies.set(2, "Artisian's tools");
        }
}

// HalfElf v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

class HalfElf extends Race {
        HalfElf() {
                this.statMods[5] += 2;
                // TODO: choose 2 other stats, cannot be the same, increase by 1
                this.ageRange = "Half Elves mature at 18, and live to around 180.";
                Size size = Size.MEDIUM;
                this.speed = 30;
                this.traits.add("- Darkvision: Thanks to your elf blood, you have\r\n" + //
                                "superior vision in dark and dim conditions. You can\r\n" + //
                                "see in dim light within 60 feet of you as if it were bright\r\n" + //
                                "light, and in darkness as if it were dim light. You can't\r\n" + //
                                "discern color in darkness, only shades of gray");
                this.traits.add("- Fey Ancestry: You have advantage on saving throws\r\n" + //
                                "against being charmed, and magic can't put you to sleep");

                // TODO: gain proficiency in 2 skills of your choice
                // TODO: languages are comon, elvish, and one of your choice
        }
}

// HalfOrc v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

class HalfOrc extends Race {
        HalfOrc() {
                this.statMods[0] += 2;
                this.statMods[2] += 1;
                this.ageRange = "Half Orcs mature at 14, and live to around 75.";
                Size size = Size.MEDIUM;
                this.speed = 30;
                this.traits.add("- Darkvision: Thanks to your orc blood, you have\r\n" + //
                                "superior vision in dark and dim conditions. You can\r\n" + //
                                "see in dim light within 60 feet of you as if it w ere bright\r\n" + //
                                "light, and in darkness as if it were dim light. You can't\r\n" + //
                                "discern color in darkness, only shades of gray");

                // TODO add proficiency in meanacing

                this.traits.add("- Relentless Endurance: When you are reduced to\r\n" + //
                                "0 hit points but not killed outright, you can drop to 1 hit\r\n" + //
                                "point instead. You can't use this feature again until you\r\n" + //
                                "finish a long rest.");
                this.traits.add("- Savage Attacks: When you score a critical hit with\r\n" + //
                                "a melee weapon attack, you can roll one of the weapon's\r\n" + //
                                "damage dice one additional time and add it to the extra\r\n" + //
                                "damage of the critical hit");
                // TODO languages are common and orc
        }
}

// Tiefling v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v

class Tiefling extends Race {
        Tiefling() {
                this.statMods[3] += 1;
                this.statMods[5] += 2;
                this.ageRange = "Tieflings mature at 18, and live to around 90.";
                Size size = Size.MEDIUM;
                this.speed = 30;
                this.traits.add("- Darkvision: Thanks to your infernal heritage, you\r\n" + //
                                "have superior vision in dark and dim conditions. You\r\n" + //
                                "can see in dim light within 60 feet of you as if it were\r\n" + //
                                "bright light, and in darkness as if it were dim light. You\r\n" + //
                                "can't discern color in darkness, only shades of gray");
                this.traits.add("Hellish Resistance. You have resistance\r\n" + //
                                "to fire damage");
                this.traits.add("- Infernal Legacy: You know the thaumaturgy cantrip.\r\n" + //
                                "Once you reach 3rd level, you can cast the hellish\r\n" + // //TODO trait adds
                                                                                           // thamaturgy spell
                                "rebuke spell once per day as a 2nd-level spell. Once you\r\n" + //
                                "reach 5th level, you can also cast the darkness spell\r\n" + //
                                "once per day. Charisma is your spellcasting ability for\r\n" + //
                                "these spells");
                // TODO languages are common and infernal
        }
}
