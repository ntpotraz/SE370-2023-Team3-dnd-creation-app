import java.util.ArrayList;

abstract class Race {    //TODO Add interactions with stats
 
int age;
int speed;
enum Size{
    SMALL,
    MEDIUM
}
ArrayList<String> languages = new ArrayList<String>();
ArrayList<String> traits = new ArrayList<String>();

Race(){
    languages.add("Common");
}   
}

abstract class Dwarf extends Race{
    Dwarf(){
        Size size = Size.MEDIUM;
        this.speed = 25;
        this.languages.add("Dwarvish");
        this.traits.add("- Darkvision. Accustomed to life underground, you\r\n" +
                "have superior vision in dark and dim conditions. You\r\n" +
                "can see in dim light within 60 feet of you as if it were\r\n" +
                "bright light, and in darkness as if it were dim light. You\r\n" +
                "can't discern color in darkness, only shades of gray.");
        this.traits.add("- Dwarven Resilience. You have advantage on saving\r\n" +
                "throws against poison, and you have resistance against\r\n" +
                "poison damage.");
        this.traits.add("Dwarven Combat Training. You have proficiency\r\n" +
                "with the battleaxe, handaxe, throwing hammer,\r\n" +
                "and warhammer.");
    }


}

class hillDwarf extends Dwarf{
    hillDwarf(){

    }
}

class mountainDwarf extends Dwarf{
    mountainDwarf(){
        
    }
}
