package edu.se370.team3;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Background {         //TODO: 13 backgrounds
    private ArrayList<String> proficiencies = new ArrayList<>();    //Index 0 = armor, 1 = weapons, 2 = tools
    private ArrayList<String> skills = new ArrayList<>();
    private ArrayList<String> languages = new ArrayList<>();
    private ArrayList<String> equipment = new ArrayList<>();

    Background(){
        //Default constructor to be overloaded
        this.proficiencies.add("");
        this.proficiencies.add("");
        this.proficiencies.add("");
    }
    public void questions(){
        //Generic background questions function to be overloaded
    }

    public ArrayList<String> getProficiencies() {
        return proficiencies;
    }
    public void setProficiencies(int index, String proficiency) {
        this.proficiencies.set(index, proficiency);
    }
    public ArrayList<String> getSkills() {
        return skills;
    }
    public void setSkills(String input) {
        this.skills.add(input);
    }
    public ArrayList<String> getLanguages() {
        return languages;
    }
    public void setLanguages(String language) {
        this.languages.add(language);
    }
    public void addLanguage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a language to learn Pre-existing languages are:");
        System.out.println("Common, Dwarvish, Elvish, Giant, Gnomish, Goblin, Halfling, Orc,\n"+
                "Abyssal, Celestial, Draconic, Deep Speech, Infernal, Primordial, Sylvan, and Undercommon.");
        String input = scan.nextLine();
        this.setLanguages(input);
        scan.close();
    }

    //TODO: Space for getters and setters for equipment(Damien)

    public static void main(String[] args) {
        //Area for testing code

    }
}

/*
Backgrounds are organized as follows:
    - proficiencies
    - skills
    - equipment
    - languages
    - questions
 */

class Acolyte extends Background{
    Acolyte(){
        this.setSkills("insight");
        this.setSkills("religion");
        //TODO: equipment(Damien)
        this.questions();
    }
    public void questions(){
        System.out.println("You learn 2 languages.");
        this.addLanguage();
        this.addLanguage();
    }
}

class Charlatan extends Background{
    Charlatan(){
        this.setProficiencies(2, "Disguise kit, Forgery kit");
        this.setSkills("deception");
        this.setSkills("sleight_of_hand");
        //TODO: equipment(Damien)
    }
}

class Criminal extends Background{
    Criminal(){
        this.setSkills("deception");
        this.setSkills("stealth");
        //TODO: equipment(Damien)
        this.questions();
    }
    public void questions(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose one type of gaming set you are proficient in.");
        String input = scan.nextLine();
        this.setProficiencies(2, "Thieves' tools, " + input);
        scan.close();
    }
}

class Entertainer extends Background{
    Entertainer(){
        this.setSkills("acrobatics");
        this.setSkills("performance");
        //TODO: equipment(Damien)
        this.questions();
    }
    public void questions(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a musical instrument to be proficient in.");
        String input = scan.nextLine();
        this.setProficiencies(2, "Disguise kit, " + input);
        scan.close();
    }
}

class FolkHero extends Background{
    FolkHero(){
        this.setSkills("animal_handling");
        this.setSkills("survival");
        //TODO: equipment(Damien)
        this.questions();
    }
    public void questions(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose one type of artisan's tools to be proficient in.");
        String tool = scan.nextLine();
        this.setProficiencies(2, tool + "Land Vehicles");
        scan.close();
    }
}

class GuildArtisan extends Background{
    GuildArtisan(){
        this.setSkills("insight");
        this.setSkills("persuasion");
        //TODO: equipment(Damien)
        this.questions();
    }
    public void questions(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose one type of artisan's tools to be proficient in.");
        String input = scan.nextLine();
        this.setProficiencies(2, input);
        this.addLanguage();
        scan.close();
    }
}

class Hermit extends Background{
    Hermit(){
        this.setProficiencies(2,"Herbalism kit");
        this.setSkills("medicine");
        this.setSkills("religion");
    //TODO: equipment(Damien)
        this.addLanguage();
    }
}

class Noble extends Background{
    Noble(){
        this.setSkills("history");
        this.setSkills("persuasion");
        //TODO: equipment(Damien)
        this.questions();
    }
    public void questions(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose one type of gaming set you are proficient in.");
        String input = scan.nextLine();
        this.setProficiencies(2,input);
        this.addLanguage();
        scan.close();
    }
}

class OutLander extends Background{
    OutLander(){
        this.setSkills("athletics");
        this.setSkills("survival");
        //TODO: equipment(Damien)
        this.questions();
    }
    public void questions(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a musical instrument to be proficient in.");
        String input = scan.nextLine();
        this.setProficiencies(2,input);
        this.addLanguage();
    }
}

class Sage extends Background{
    Sage(){
        this.setSkills("arcana");
        this.setSkills("history");
        //TODO: equipment(Damien)
    }
    public void questions(){
        System.out.println("You learn 2 languages.");
        this.addLanguage();
        this.addLanguage();
    }
}

class Sailor extends Background{
    Sailor(){
        this.setProficiencies(2,"Navigator's tools, water vehicles");
        this.setSkills("athletics");
        this.setSkills("perception");
        //TODO: equipment(Damien)
    }
}

class Soldier extends Background{
    Soldier(){
        this.setSkills("athletics");
        this.setSkills("intimidation");
        //TODO: equipment(Damien)
        this.questions();
    }
    public void questions(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose one type of gaming set you are proficient in.");
        String input = scan.nextLine();
        this.setProficiencies(2, "Land vehicles, " + input);
        scan.close();
    }
}

class Urchin extends Background{
    Urchin(){
        this.setProficiencies(2,"Disguise kit, Thieves' tools");
        this.setSkills("sleight_of_hand");
        this.setSkills("stealth");
        //TODO: equipment(Damien)
    }
}
