package edu.se370.team3;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Background { // TODO: 13 backgrounds
  private String bg;
  private ArrayList<String> proficiencies = new ArrayList<>(); // Index 0 = armor, 1 = weapons, 2 = tools
  private ArrayList<String> skills = new ArrayList<>();
  private ArrayList<String> languages = new ArrayList<>();
  private ArrayList<String> equipment = new ArrayList<>();

  Background() {
    // Default constructor to be overloaded
    this.bg = "Formless";
    this.proficiencies.add("");
    this.proficiencies.add("");
    this.proficiencies.add("");
  }

  public Background createBackground(String type) {
    type = type.toLowerCase();
    switch (type) {
      case "acolyte":
        return new Acolyte();
      case "charlatan":
        return new Charlatan();
      case "criminal":
        return new Criminal();
      case "entertainer":
        return new Entertainer();
      case "folkhero":
        return new FolkHero();
      case "guildartisan":
        return new GuildArtisan();
      case "hermit":
        return new Hermit();
      case "noble":
        return new Noble();
      case "outlander":
        return new OutLander();
      case "sage":
        return new Sage();
      case "sailor":
        return new Sailor();
      case "urchin":
        return new Urchin();
      default:
        return new FolkHero();
    }
  }

  public void setBackgroundTitle(String newBG) {
    this.bg = newBG;
  }

  public String getBackgroundTitle() {
    return this.bg;
  }

  public void questions() {
    // Generic background questions function to be overloaded
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

  public void addLanguage() {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nChoose a language to learn Pre-existing languages are:");
    System.out.println("Common, Dwarvish, Elvish, Giant, Gnomish, Goblin, Halfling, Orc,\n" +
        "Abyssal, Celestial, Draconic, Deep Speech, Infernal, Primordial, Sylvan, and Undercommon.");
    System.out.print(">>> ");
    String input = scan.nextLine();
    this.setLanguages(input);
  }

  // TODO: Space for getters and setters for equipment(Damien)

  public static void main(String[] args) {
    // Area for testing code

  }
}

/*
 * Backgrounds are organized as follows:
 * - proficiencies
 * - skills
 * - equipment
 * - languages
 * - questions
 */

class Clean extends Background {
  Clean() {
  }
}

class Acolyte extends Background {
  Acolyte() {
    this.setBackgroundTitle("Acolyte");
    this.setSkills("insight");
    this.setSkills("religion");
    // TODO: equipment(Damien)
    // this.questions();
  }

  public void questions() {
    System.out.println("\nYou learn 2 languages.");
    this.addLanguage();
    this.addLanguage();
  }
}

class Charlatan extends Background {
  Charlatan() {
    this.setBackgroundTitle("Charlatan");
    this.setProficiencies(2, "Disguise kit, Forgery kit");
    this.setSkills("deception");
    this.setSkills("sleight_of_hand");
    // TODO: equipment(Damien)
  }
}

class Criminal extends Background {
  Criminal() {
    this.setBackgroundTitle("Criminal");
    this.setSkills("deception");
    this.setSkills("stealth");
    // TODO: equipment(Damien)
    // this.questions();
  }

  public void questions() {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nChoose one type of gaming set you are proficient in.");
    System.out.print(">>> ");
    String input = scan.nextLine();
    this.setProficiencies(2, "Thieves' tools, " + input);
  }
}

class Entertainer extends Background {
  Entertainer() {
    this.setBackgroundTitle("Entertainer");
    this.setSkills("acrobatics");
    this.setSkills("performance");
    // TODO: equipment(Damien)
    // this.questions();
  }

  public void questions() {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nChoose a musical instrument to be proficient in.");
    System.out.print(">>> ");
    String input = scan.nextLine();
    this.setProficiencies(2, "Disguise kit, " + input);
  }
}

class FolkHero extends Background {
  FolkHero() {
    this.setBackgroundTitle("Folk Hero");
    this.setSkills("animal_handling");
    this.setSkills("survival");
    // TODO: equipment(Damien)
    // this.questions();
  }

  public void questions() {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nChoose one type of artisan's tools to be proficient in.");
    System.out.print(">>> ");
    String tool = scan.nextLine();
    this.setProficiencies(2, tool + "Land Vehicles");
  }
}

class GuildArtisan extends Background {
  GuildArtisan() {
    this.setBackgroundTitle("Guild Artisan");
    this.setSkills("insight");
    this.setSkills("persuasion");
    // TODO: equipment(Damien)
    // this.questions();
  }

  public void questions() {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nChoose one type of artisan's tools to be proficient in.");
    System.out.print(">>> ");
    String input = scan.nextLine();
    this.setProficiencies(2, input);
    this.addLanguage();
  }
}

class Hermit extends Background {
  Hermit() {
    this.setBackgroundTitle("Hermit");
    this.setProficiencies(2, "Herbalism kit");
    this.setSkills("medicine");
    this.setSkills("religion");
    // TODO: equipment(Damien)
    this.addLanguage();
  }
}

class Noble extends Background {
  Noble() {
    this.setBackgroundTitle("Noble");
    this.setSkills("history");
    this.setSkills("persuasion");
    // TODO: equipment(Damien)
    // this.questions();
  }

  public void questions() {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nChoose one type of gaming set you are proficient in.");
    System.out.print(">>> ");
    String input = scan.nextLine();
    this.setProficiencies(2, input);
    this.addLanguage();
  }
}

class OutLander extends Background {
  OutLander() {
    this.setBackgroundTitle("Outlander");
    this.setSkills("athletics");
    this.setSkills("survival");
    // TODO: equipment(Damien)
    // this.questions();
  }

  public void questions() {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nChoose a musical instrument to be proficient in.");
    System.out.print(">>> ");
    String input = scan.nextLine();
    this.setProficiencies(2, input);
    this.addLanguage();
  }
}

class Sage extends Background {
  Sage() {
    this.setBackgroundTitle("Sage");
    this.setSkills("arcana");
    this.setSkills("history");
    // TODO: equipment(Damien)
  }

  public void questions() {
    System.out.println("\nYou learn 2 languages.");
    this.addLanguage();
    this.addLanguage();
  }
}

class Sailor extends Background {
  Sailor() {
    this.setBackgroundTitle("Sailor");
    this.setProficiencies(2, "Navigator's tools, water vehicles");
    this.setSkills("athletics");
    this.setSkills("perception");
    // TODO: equipment(Damien)
  }
}

class Soldier extends Background {
  Soldier() {
    this.setBackgroundTitle("Soldier");
    this.setSkills("athletics");
    this.setSkills("intimidation");
    // TODO: equipment(Damien)
    // this.questions();
  }

  public void questions() {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nChoose one type of gaming set you are proficient in.");
    System.out.print(">>> ");
    String input = scan.nextLine();
    this.setProficiencies(2, "Land vehicles, " + input);
  }
}

class Urchin extends Background {
  Urchin() {
    this.setBackgroundTitle("Urchin");
    this.setProficiencies(2, "Disguise kit, Thieves' tools");
    this.setSkills("sleight_of_hand");
    this.setSkills("stealth");
    // TODO: equipment(Damien)
  }
}
