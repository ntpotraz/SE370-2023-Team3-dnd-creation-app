package edu.se370.team3;

import java.util.Scanner;

public class Character {
  private String characterName;
  private int health;
  private int ac;
  private int[] hitDie;
  private Job job;
  private Race race;
  private Stats stats;
  private Skills skills;
  private Spellbook spellbook;

  public Character() {
    this.characterName = "";
    this.health = 0;
    this.ac = 10;
    this.hitDie = new int[] { 0, 0 }; // 0: # of dice, 1: # of sides (0d1)
    this.race = new Blank();
    this.job = new Job();
    this.stats = new Stats();
    this.skills = new Skills();
    this.spellbook = new Spellbook();
  }

  public void setName(String name) {
    this.characterName = name;
  }

  public String getName() {
    return this.characterName;
  }

  public void addHealth(int hp) {
    this.health += hp;
  }

  public int getHealth() {
    return this.health;
  }

  public void addAC(int armor) {
    this.ac += armor;
  }

  public int getAC() {
    return this.ac;
  }

  public void setHitDie(int[] hd) {
    this.hitDie = hd;
  }

  public String getHitDie() {
    return this.hitDie[0] + "d" + this.hitDie[1];
  }

  public Job getJob() {
    return this.job;
  }

  public void setJob(String input) {
    switch (input) {
      case "1":
        this.job.Barbarian();
        break;
      case "2":
        this.job.Bard();
        break;
      case "3":
        this.job.Cleric();
        break;
      case "4":
        this.job.Druid();
        break;
      case "5":
        this.job.Fighter();
        break;
      case "6":
        this.job.Monk();
        break;
      case "7":
        this.job.Paladin();
        break;
      case "8":
        this.job.Ranger();
        break;
      case "9":
        this.job.Rogue();
        break;
      case "10":
        this.job.Sorcerer();
        break;
      case "11":
        this.job.Warlock();
        break;
      case "12":
        this.job.Wizard();
        break;
      default:
        this.job.Bard();
        break;
    }
  }

  public Race getRace() {
    return this.race;
  }

  public void setRace(String input) {
    String newRace;
    switch (input) {
      case "1":
        newRace = "hilldwarf";
        break;
      case "2":
        newRace = "mountaindwarf";
        break;
      case "3":
        newRace = "highelf";
        break;
      case "4":
        newRace = "woodelf";
        break;
      case "5":
        newRace = "darkelf";
        break;
      case "6":
        newRace = "lightfoot";
        break;
      case "7":
        newRace = "stout";
        break;
      case "8":
        newRace = "human";
        break;
      case "9":
        newRace = "dragonborn";
        break;
      case "10":
        newRace = "forestgnome";
        break;
      case "11":
        newRace = "rockgnome";
        break;
      case "12":
        newRace = "halfelf";
        break;
      case "13":
        newRace = "halforc";
        break;
      case "14":
        newRace = "tiefling";
        break;
      default:
        newRace = "human";
        break;
    }
    this.race = this.race.createRace(newRace);
  }

  public Stats getStats() {
    return this.stats;
  }

  public Skills getSkills() {
    return this.skills;
  }

  public static void main(String[] args) throws Exception {
    Scanner kb = new Scanner(System.in);
    String input = "";
    Character character = new Character();

    System.out.println("Welcome the Dungeons and Dragon Character Creator!");
    System.out.print("Enter character name:\n>>> ");
    input = kb.nextLine();
    character.setName(input);
    System.out.println("\nFrom the list below, please enter a number for your desired race:");
    System.out.print(
        "1. Hill Dwarf\n" +
            "2. Mountain Dwarf\n" +
            "3. High Elf\n" +
            "4. Wood Elf\n" +
            "5. Dark Elf\n" +
            "6. Lightfoot\n" +
            "7. Stout\n" +
            "8. Human\n" +
            "9. Dragonborn\n" +
            "10. Forest Gnome\n" +
            "11. Rock Gnome\n" +
            "12. Half Elf\n" +
            "13. Half Orc\n" +
            "14. Tiefling\n>>> ");
    input = kb.nextLine();
    character.setRace(input);
    character.addHealth(character.getRace().getHealthModifer());

    System.out.println("\nPlease choose desired Class from the list below:");
    System.out.println(
        "1. Barbarian\n" +
            "2. Bard\n" +
            "3. Cleric\n" +
            "4. Druid\n" +
            "5. Fighter\n" +
            "6. Monk\n" +
            "7. Paladin\n" +
            "8. Ranger\n" +
            "9. Rogue\n" +
            "10. Sorcerer\n" +
            "11. Warlock\n" +
            "12. Wizard");
    System.out.print(">>> ");
    input = kb.nextLine();
    character.setJob(input);
    character.addHealth(character.getJob().getBaseHP());
    character.setHitDie(character.getJob().getHitDie());

    System.out.println("\nHealth: " + character.getHealth());
    System.out.println("Hit Dice: " + character.getHitDie());

    System.out.println("\nWould you like to roll for your stats, or use the standard array: { 15, 14, 13, 12, 10, 8 }");
    System.out.print("1. Roll\n2. Standard Array\n>>> ");
    input = kb.nextLine();

    if (input.equals("1")) {
      System.out.println("\nRolling for stats, you will do this a total of 6 times");
      for (int i = 0; i < 6; i++) {
        System.out.print("Press 'Enter' to roll\n>>> ");
        kb.nextLine();
        System.out.println();
        character.getStats().rollDice();
        System.out.println("Stats: " + character.getStats().getStatList() + "\n");
      }

    } else {
      character.getStats().useStandardArray();
    }
    System.out.println("\nHere are your points to allocate to your stats:");
    System.out.println(character.getStats().getStatList());

    kb.close();
  }
}
