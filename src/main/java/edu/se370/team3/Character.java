package edu.se370.team3;

import java.util.ArrayList;

public class Character {
  private String characterName;
  private int health;
  private int ac;
  private int[] hitDie;
  private ArrayList<Item> backpack;
  private ArrayList<String> chosenSkills;
  private Job job;
  private Race race;
  private Background background;
  private Stats stats;
  private Skills skills;
  private Spellbook spellbook;

  public Character() {
    this.characterName = "";
    this.health = 0;
    this.ac = 10;
    this.hitDie = new int[] { 1, this.health }; // 0: # of dice, 1: # of sides (0d1)
    this.backpack = new ArrayList<Item>();
    this.chosenSkills = new ArrayList<String>();
    this.race = new Blank();
    this.job = new Job();
    this.background = new Clean();
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

  public String getHitDie() {
    return this.hitDie[0] + "d" + this.hitDie[1];
  }

  public void addAC(int armor) {
    this.ac += armor;
  }

  public int getAC() {
    return this.ac;
  }

  public void addItem(Item item) {
    this.backpack.add(item);
  }

  // This takes skills from Background and Race and adds it to Skills as well
  // as returns the list of the skills

  public ArrayList<String> getGivenSkills() {
    ArrayList<String> givenSkills = new ArrayList<String>();
    givenSkills.addAll(this.race.getSkills());

    for (String skill : this.background.getSkills()) {
      if (!givenSkills.contains(skill))
        givenSkills.add(skill);
    }
    this.skills.addProficiency(givenSkills);

    return givenSkills;
  }

  public ArrayList<String> getItemList() {
    ArrayList<String> itemNames = new ArrayList<String>();
    for (Item item : this.backpack) {
      itemNames.add(item.getName());
    }
    return itemNames;
  }

  public Job getJob() {
    return this.job;
  }

  public void setJob(String input) {
    switch (input) {
      case "Barbarian":
        this.job.Barbarian();
        break;
      case "Bard":
        this.job.Bard();
        break;
      case "Cleric":
        this.job.Cleric();
        break;
      case "Druid":
        this.job.Druid();
        break;
      case "Fighter":
        this.job.Fighter();
        break;
      case "Monk":
        this.job.Monk();
        break;
      case "Paladin":
        this.job.Paladin();
        break;
      case "Ranger":
        this.job.Ranger();
        break;
      case "Rogue":
        this.job.Rogue();
        break;
      case "Sorcerer":
        this.job.Sorcerer();
        break;
      case "Warlock":
        this.job.Warlock();
        break;
      case "Wizard":
        this.job.Wizard();
        break;
      default:
        this.job.Bard();
        break;
    }
  }

  public Background getBackground() {
    return this.background;
  }

  public void setBackground(String input) {
    String newBackground;
    switch (input) {
      case "Acolyte":
        newBackground = "acolyte";
        break;
      case "Charlatan":
        newBackground = "charlatan";
        break;
      case "Criminal":
        newBackground = "criminal";
        break;
      case "Entertainer":
        newBackground = "entertainer";
        break;
      case "Folkhero":
        newBackground = "folkhero";
        break;
      case "Guildartisan":
        newBackground = "guildartisan";
        break;
      case "Hermit":
        newBackground = "hermit";
        break;
      case "Noble":
        newBackground = "noble";
        break;
      case "Outlander":
        newBackground = "outlander";
        break;
      case "Sage":
        newBackground = "sage";
        break;
      case "Sailor":
        newBackground = "sailor";
        break;
      case "Soldier":
        newBackground = "soldier";
        break;
      case "Urchin":
        newBackground = "urchin";
        break;
      default:
        newBackground = "folkhero";
        break;
    }
    this.background = this.background.createBackground(newBackground);
  }

  public Race getRace() {
    return this.race;
  }

  public void setRace(String input) {
    String newRace;
    switch (input) {
      case "Hill Dwarf":
        newRace = "hilldwarf";
        break;
      case "Mountain Dwarf":
        newRace = "mountaindwarf";
        break;
      case "High Elf":
        newRace = "highelf";
        break;
      case "Wood Elf":
        newRace = "woodelf";
        break;
      case "Dark Elf":
        newRace = "darkelf";
        break;
      case "Lightfoot":
        newRace = "lightfoot";
        break;
      case "Stout":
        newRace = "stout";
        break;
      case "Human":
        newRace = "human";
        break;
      case "Dragonborn":
        newRace = "dragonborn";
        break;
      case "Forest Gnome":
        newRace = "forestgnome";
        break;
      case "Rock Gnome":
        newRace = "rockgnome";
        break;
      case "Half Elf":
        newRace = "halfelf";
        break;
      case "Half Orc":
        newRace = "halforc";
        break;
      case "Tiefling":
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

  public Spellbook getSpellbook() {
    return this.spellbook;
  }

}