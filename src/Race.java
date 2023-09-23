import java.util.ArrayList;

abstract class Race {    //TODO Add interactions with stats

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
        ageRange = "Dwarves mature at 50, and live to around 350.";
        proficiencies.set(1, "Battleaxe, Handaxe, Throwing Hammer, Warhammer");
        this.traits.add("- Darkvision. Accustomed to life underground, you\r\n" +
                "have superior vision in dark and dim conditions. You\r\n" +
                "can see in dim light within 60 feet of you as if it were\r\n" +
                "bright light, and in darkness as if it were dim light. You\r\n" +
                "can't discern color in darkness, only shades of gray.");
        this.traits.add("- Dwarven Resilience. You have advantage on saving\r\n" +
                "throws against poison, and you have resistance against\r\n" +
                "poison damage.");
    }


}

class hillDwarf extends Dwarf{
    hillDwarf(){
    this.statMods.add(4,1);
    }
    int hillDwarfHP = 1;
}

class mountainDwarf extends Dwarf{
    mountainDwarf(){
    this.statMods.set(0,2);
    this.proficiencies.set(0,"Light armor, medium armor");
    }
}

abstract class Elf extends Race{
    Elf(){
        statMods.set(1,2);
        Size size = Size.MEDIUM;
        ageRange = "Elves mature at 100, and live to around 750.";
        //TODO Add rest of elf features

    }
}

class HighElf extends Elf{

}

class WoodElf extends Elf{

}

class DarkElf extends Elf{

}
