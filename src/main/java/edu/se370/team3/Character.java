package edu.se370.team3;

public class Character {
  private String characterName;
  private int health;
  private int ac;
  private int[] hitDie;
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
    this.hitDie = new int[] { 0, 0 }; // 0: # of dice, 1: # of sides (0d1)
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

  public Background getBackground() {
    return this.background;
  }

  public void setBackground(String input) {
    String newBackground;
    switch (input) {
      case "1":
        newBackground = "acolyte";
        break;
      case "2":
        newBackground = "charlatan";
        break;
      case "3":
        newBackground = "criminal";
        break;
      case "4":
        newBackground = "entertainer";
        break;
      case "5":
        newBackground = "folkhero";
        break;
      case "6":
        newBackground = "guildartisan";
        break;
      case "7":
        newBackground = "hermit";
        break;
      case "8":
        newBackground = "noble";
        break;
      case "9":
        newBackground = "outlander";
        break;
      case "10":
        newBackground = "sage";
        break;
      case "11":
        newBackground = "sailor";
        break;
      case "12":
        newBackground = "soldier";
        break;
      case "13":
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

  public Spellbook getSpellbook() {
    return this.spellbook;
  }

}
