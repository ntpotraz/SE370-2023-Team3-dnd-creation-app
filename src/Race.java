import java.util.ArrayList;

abstract class Race {    //TODO Add interactions with stats
                        //TODO add Languages
    String ageRange;
    ArrayList<String> proficiencies = new ArrayList<String>();  //Index 0 = Armor, 1 = Weapons, = 2 = Tools
    ArrayList<Integer> statMods = new ArrayList<Integer>(); //Index 0 = strength, 1 = dexterity, 2 = constitution, 3 = intelligence, 4 = wisdom, 5 = charisma
    enum Size{
        SMALL,
        MEDIUM
    }
    ArrayList<String> traits = new ArrayList<String>();     //Temporary misc. traits for things like darkvision, resistances, etc.

    Race(){
        for(int i = 0;i<6;i++){
            statMods.add(0);
        }
        proficiencies.add("");
        proficiencies.add("");
        proficiencies.add("");
    }
}

abstract class Dwarf extends Race{
    Dwarf(){
        Size size = Size.MEDIUM;
        this.statMods.add(2,2);
        ageRange = "Dwarves mature at 50, and live to around 350.";
        proficiencies.set(1, "Battleaxe, Handaxe, Throwing Hammer, Warhammer");

        //TODO choose one, proficiency in smith, brewer, or mason's tools

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

class HillDwarf extends Dwarf{
    HillDwarf(){
        this.statMods.add(4,1);
    }
    int hillDwarfHP = 1;        //Note: hill dwarf is only class that adds 1 to hp
}

class MountainDwarf extends Dwarf{
    MountainDwarf(){
        this.statMods.set(0,2);
        this.proficiencies.set(0,"Light armor, medium armor");
    }
}

abstract class Elf extends Race{
    Elf(){
        statMods.set(1,2);
        Size size = Size.MEDIUM;
        ageRange = "Elves mature at 100, and live to around 750.";
        this.traits.add("- Darkvision: Accustom ed to twilit forests and the night\n" +
                "sky, you have superior vision in dark and dim conditions.\n" +
                "You can see in dim light within 60 feet of you as if it\n" +
                "were bright light, and in darkness as if it were dim light.\n" +
                "You can’t discern color in darkness, only shades of gray");

        //TODO: Keen Senses, gives proficiency in perception

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

class HighElf extends Elf{
    HighElf(){
        this.statMods.set(3,1);
        this.proficiencies.set(1,"Longsword, Shortsword, Shortbow, Longbow");

        //TODO: Cantrip: choose one cantrip from the wizard spell list
        //TODO: Extra Language: choose 1 language to learn
    }
}

class WoodElf extends Elf{
    WoodElf(){
        this.statMods.set(4,1);
        this.proficiencies.set(1,"Longsword, Shortsword, Shortbow, Longbow");

        //TODO: Fleet of Foot: increase walking speed to 35

        this.traits.add("- Mask of the Wild: You can attempt to hide even when\n" +
                "you are only lightly obscured by foliage, heavy rain,\n" +
                "falling snow, mist, and other natural phenomena.");

    }
}

class DarkElf extends Elf{
    DarkElf(){
        this.statMods.set(5,1);
        this.traits.add("- Superior Darkvision Your darkvision has a\n" +
                "radius of 120 feet.");
        this.traits.add("- Sunlight Sensitivity: You have disadvantage on attack\n" +
                "rolls and on Wisdom (Perception) checks that rely on\n" +
                "sight when you, the target of your attack, or whatever\n" +
                "you are trying to perceive is in direct sunlight.");
        this.traits.add("- Drow Magic: You know the dancing lights cantrip.\n" +
                "When you reach 3rd level, you can cast the faerie fire\n" +
                "spell once per day. When you reach 5th level, you can\n" +
                "also cast the darkness spell once per day. Charisma is\n" +        //TODO: this trait adds dancing lights to the players spell list
                "your spellcasting ability for these spells.");
        this.proficiencies.set(1, "Rapiers, Shortswords, Hand Crossbows");
    }
}

abstract class Halfling extends Race{
    Halfling(){
    
    }
}

class Lightfoot extends Halfling{

}

class Stout extends Halfling{

}
