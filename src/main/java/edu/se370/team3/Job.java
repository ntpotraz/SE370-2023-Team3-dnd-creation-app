package edu.se370.team3;

import java.util.ArrayList;
import java.util.Scanner;

public class Job {
  private String jobTitle;
  private int baseHP;
  private int[] hitDie;
  // to be added to finalHP in character class while calculating final stats
  private ArrayList<String> proficienciesTypes = new ArrayList<>();
  // Arraylist index 0 = armor, 1 = weapons, 2 = tools
  private ArrayList<String> skills = new ArrayList<>();
  private ArrayList<String> equipment = new ArrayList<>();

  // Changed these to the primative and not the Class Boolean
  private boolean strengthSV;
  private boolean dexteritySV;
  private boolean constitutionSV;
  private boolean intelligenceSV;
  private boolean wisdomSV;
  private boolean charismaSV;

  Job() {
    this.jobTitle = "Jobless";
    this.baseHP = 0;
    this.hitDie = new int[] { 0, 0 }; // 0: # of dice, 1: # of sides
    this.proficienciesTypes.add("");
    this.proficienciesTypes.add("");
    this.proficienciesTypes.add("");

    this.strengthSV = false;
    this.dexteritySV = false;
    this.constitutionSV = false;
    this.intelligenceSV = false;
    this.wisdomSV = false;
    this.charismaSV = false;
  }

  Job(String job) {
    this();
    setJob(job);
  }

  public void setJob(String job) {
    job = job.toLowerCase();
    switch (job) {
      case "barbarian":
        this.Barbarian();
        break;
      case "bard":
        this.Bard();
        break;
      case "cleric":
        this.Cleric();
        break;
      case "druid":
        this.Druid();
        break;
      case "fighter":
        this.Fighter();
        break;
      case "monk":
        this.Monk();
        break;
      case "paladin":
        this.Paladin();
        break;
      case "ranger":
        this.Ranger();
        break;
      case "rogue":
        this.Rogue();
        break;
      case "sorcerer":
        this.Sorcerer();
        break;
      case "warlock":
        this.Warlock();
        break;
      case "wizard":
        this.Wizard();
        break;
      default:
        this.Bard();
    }
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String title) {
    this.jobTitle = title;
  }

  public int getBaseHP() {
    return baseHP;
  }

  public void setBaseHP(int hp) {
    this.baseHP = hp;
  }

  public void setHitDie(int[] hd) {
    this.hitDie = hd;
  }

  public int[] getHitDie() {
    return this.hitDie;
  }

  public boolean getStr() {
    return strengthSV;
  }

  public void setStr() {
    this.strengthSV = true;
  }

  public boolean getDex() {
    return dexteritySV;
  }

  public void setDex() {
    this.dexteritySV = true;
  }

  public boolean getCon() {
    return constitutionSV;
  }

  public void setCon() {
    this.constitutionSV = true;
  }

  public boolean getInt() {
    return intelligenceSV;
  }

  public void setInt() {
    this.intelligenceSV = true;
  }

  public boolean getWis() {
    return wisdomSV;
  }

  public void setWis() {
    this.wisdomSV = true;
  }

  public boolean getCha() {
    return charismaSV;
  }

  public void setCha() {
    this.charismaSV = true;
  }

  public ArrayList<String> getSkills() {
    return skills;
  }

  public ArrayList<String> getProficiancy() {
    return proficienciesTypes;
  }

  public ArrayList<String> getEquipment() {
    return equipment;
  }

  void Barbarian() {
    setJobTitle("Barbarian");
    setStr();
    setCon();
    setBaseHP(12);
    setHitDie(new int[] { 1, 12 });
    getProficiancy().set(0, "light armor, medium armor, shields");
    getProficiancy().set(1, "simple weapons, martial weapons");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "\nType the first of the following skills that you'd like,\nAnimal Handling, Athletics, Intimidation, Nature, Perception, Survival:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf(
        "\nType the second of the following skills that you'd like,\nAnimal Handling, Athletics, Intimidation, Nature, Perception, Survival:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());

    System.out.printf("\nEquipment:\n");
    System.out.printf("type Greataxe or any martial melee weapon:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nTwo handaxes or any simple weapon:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    getEquipment().add("Explorer’s pack");
    getEquipment().add("Four javalins");
  }

  void Bard() {
    setJobTitle("Bard");
    setDex();
    setCha();
    setBaseHP(8);
    setHitDie(new int[] { 1, 8 });
    getProficiancy().set(0, "light armor");
    getProficiancy().set(1, "simple weapons, hand crossbows, longswords, rapiers, shortswords");
    getProficiancy().set(2, "Three musical instruments of your choice");

    Scanner input = new Scanner(System.in);
    System.out.printf("\nThe Bard class gives access to any three skills,\n type the first skill :\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the second skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the third skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());

    System.out.printf("\nEquipment:\n");
    System.out.printf("type rapier, longsword, or any simple weapon:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nDiplomat’s pack or an entertainer's pack:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nLute or any other musical instrument:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    getEquipment().add("Leather armor");
    getEquipment().add("Dagger");
  }

  void Cleric() {
    setJobTitle("Cleric");
    setWis();
    setCha();
    setBaseHP(8);
    setHitDie(new int[] { 1, 8 });
    getProficiancy().set(0, "Light armor, medium armor, shields");
    getProficiancy().set(1, "All simple weapons");

    Scanner input = new Scanner(System.in);
    System.out.printf("\nType the first of two skills,\nHistory, Insight, Medicine, Persuasion, and Religion:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the second skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());

    System.out.printf("\nEquipment:\n");
    System.out.printf("Type mace, or warhammer (if proficient):\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nScale mail, leather armor, or chain mail (if proficient):\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nlight crossbow and 20 bolts or any simple weapon:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nPriest’s pack or an explorer’s pack:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nHoly symbol:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    getEquipment().add("Shield");
  }

  void Druid() {
    setJobTitle("Druid");
    setInt();
    setWis();
    setBaseHP(8);
    setHitDie(new int[] { 1, 8 });
    getProficiancy().set(0, "light armor, medium armor, shields");
    getProficiancy().set(1,
        "clubs, daggers, darts, javelins, maces, quarterstaffs, scimitars, sickles, slings, spears");
    getProficiancy().set(2, "Herbalism kit");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "\nType the first of two skills,\nArcana, Animal Handling, Insight, Medicine, Nature, Perception, Religion, and Survival:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the second skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());

    System.out.printf("\nEquipment:\n");
    System.out.printf("Type wooden shield or any simple weapon:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nScimitar or any simple melee weapon:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    getEquipment().add("Leather armor");
    getEquipment().add("Explorers pack");
    getEquipment().add("Druidic focus");
  }

  void Fighter() {
    setJobTitle("Fighter");
    setStr();
    setCon();
    setBaseHP(10);
    setHitDie(new int[] { 1, 10 });
    getProficiancy().set(0, "All armor, shields");
    getProficiancy().set(1, "Simple weapons, martial weapons");
    String in = "";

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "\nType the first of two skills,\nAcrobatics, Animal Handling, Athletics, History, Insight, Intimidation, Perception, and Survival:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the second skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());

    System.out.printf("\nEquipment:\n");
    System.out.printf("Type chain mail or B for leather armor, longbow, and 20 arrows:\n");
    System.out.print(">>> ");
    in = input.nextLine();
    if (in == "b") {
      getEquipment().add("leather armor");
      getEquipment().add("long bow");
      getEquipment().add("20 arrows");
    } else {
      System.out.print(">>> ");
      getEquipment().add(in);
    }

    System.out.printf("\nA martial weapon and a shield or two martial weapons:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nA light crossbow and 20 bolts, or two handaxes:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nDungeoneer’s pack or (b) an explorer’s pack:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
  }

  void Monk() {
    setJobTitle("Monk");
    setDex();
    setStr();
    setBaseHP(8);
    setHitDie(new int[] { 1, 8 });
    getProficiancy().set(1, "simple weapons, shortswords");
    getProficiancy().set(2, "Choose one type of artisan’s tools or one musical instrument");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "\nType the first of two skills,\nAcrobatics, Athletics, History, Insight, Religion, and Stealth:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the second skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());

    System.out.printf("\nEquipment:\n");
    System.out.printf("type shortsword or any simple weapon:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nDungeoneer’s pack or an explorer’s pack:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    getEquipment().add("10 Darts");
  }

  void Paladin() {
    setJobTitle("Paladin");
    setWis();
    setCha();
    setBaseHP(10);
    setHitDie(new int[] { 1, 10 });
    getProficiancy().set(0, "all armor, shields");
    getProficiancy().set(1, "simple weapons, martial weapons");
    String in;

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "\nType the first of two skills,\nAthletics, Insight, Intimidation, Medicine, Persuasion, and Religion:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the second skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());

    System.out.printf("\nEquipment:\n");
    System.out.printf("Type a martial weapon then shield or B for two martial weapons:\n");
    System.out.print(">>> ");
    in = input.nextLine();
    if (in == "b") {
      System.out.printf("\nMartial weapon 1:\n");
      System.out.print(">>> ");
      getEquipment().add(input.nextLine());
      System.out.printf("\nMartial weapon 2:\n");
      System.out.print(">>> ");
      getEquipment().add(input.nextLine());
    } else {
      System.out.print(">>> ");
      getEquipment().add(input.nextLine());
      System.out.print(">>> ");
      getEquipment().add(input.nextLine());
    }

    System.out.printf("\nFive javelins or any simple melee weapon:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nA priest’s pack or an explorer’s pack:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nDungeoneer’s pack or (b) an explorer’s pack:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    getEquipment().add("Chainmail");
    getEquipment().add("Holy symbol");
  }

  void Ranger() {
    setJobTitle("Ranger");
    setDex();
    setStr();
    setBaseHP(10);
    setHitDie(new int[] { 1, 10 });
    getProficiancy().set(0, "Light armor");
    getProficiancy().set(1, "Simple weapons, martial weapons");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "\nType the first of three skills,\nAnimal Handling, Athletics, Insight, Investigation, Nature, Perception, Stealth, and Survival\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the second skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the third skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());

    String in;
    System.out.printf("\nEquipment:\n");
    System.out.printf("Type two shortswords or b for two simple melee weapons:\n");
    System.out.print(">>> ");
    in = input.nextLine();
    if (in == "b") {
      System.out.printf("\nSimple weapon 1:\n");
      System.out.print(">>> ");
      getEquipment().add(input.nextLine());
      System.out.printf("\nSimple weapon 2:\n");
      System.out.print(">>> ");
      getEquipment().add(input.nextLine());
    } else {
      getEquipment().add("Shortsword");
      getEquipment().add("Shortsword");
    }

    System.out.printf("\nType scale mail or leather armor:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nDungeoneer’s pack or an explorer’s pack:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    getEquipment().add("longbow + quiver of 20 arrows");
  }

  void Rogue() {
    setJobTitle("Rogue");
    setDex();
    setInt();
    setBaseHP(8);
    setHitDie(new int[] { 1, 8 });
    getProficiancy().set(0, "Light armor");
    getProficiancy().set(1, "Simple weapons, hand crossbows, longswords, rapiers, shortswords");
    getProficiancy().set(2, "Thieves’ tools");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "\nType the first of four skills,\nAcrobatics, Athletics, Deception. Insight, Intimidation, Investigation, Perception, Performance. Persuasion, Sleight of Hand, and Stealth\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the second skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the third skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the fourth skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());

    System.out.printf("\nEquipment:\n");
    System.out.printf("Type rapier or a shortsword:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nShortbow and 20 arrows or a shortsword:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nBurglar’s pack, a dungeoneer’s pack, or an explorer’s pack:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    getEquipment().add("Leather armor");
    getEquipment().add("Two daggers");
    getEquipment().add("Theives tools");
  }

  void Sorcerer() {
    setJobTitle("Sorcerer");
    setDex();
    setCon();
    setBaseHP(6);
    setHitDie(new int[] { 1, 6 });
    getProficiancy().set(1, "Daggers, darts, slings, quarterstaffs, light crossbows");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "\nType the first of two skills,\nArcana, Deception, Insight, Intimidation, Persuasion, and Religion:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the second skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());

    String in;
    System.out.printf("\nEquipment:\n");
    System.out.printf("Type any simple weapon or b for a light crossbow and 20 bolts:\n");
    System.out.print(">>> ");
    in = input.nextLine();
    if (in == "b") {
      getEquipment().add("Light crossbow");
      getEquipment().add("20 Bolts");
    } else {
      getEquipment().add(in);
    }

    System.out.printf("\nType component pouch or an arcane focus:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nDungeoneer’s pack or an explorer’s pack:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    getEquipment().add("Two daggers");
  }

  void Warlock() {
    setJobTitle("Warlock");
    setWis();
    setCha();
    setBaseHP(8);
    setHitDie(new int[] { 1, 8 });
    getProficiancy().set(0, "Light armor");
    getProficiancy().set(1, "Simple weapons");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "\nType the first of two skills,\nArcana, Deception, History, Intimidation, Investigation, Nature, and Religion:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());

    String in;
    System.out.printf("\nEquipment:\n");
    System.out.printf("Type any simple weapon or b for a light crossbow and 20 bolts:\n");
    System.out.print(">>> ");
    in = input.nextLine();
    if (in == "b") {
      getEquipment().add("Light crossbow");
      getEquipment().add("20 Bolts");
    } else {
      getEquipment().add(in);
    }

    System.out.printf("\nType component pouch or an arcane focus:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nScholar’s pack or a dungeoneer’s pack:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nType any simple weapon:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    getEquipment().add("Two daggers");
    getEquipment().add("Leather armor");
  }

  void Wizard() {
    setJobTitle("Wizard");
    setWis();
    setInt();
    setBaseHP(6);
    setHitDie(new int[] { 1, 6 });
    getProficiancy().set(1, "Daggers, darts, slings, quarterstaffs, light crossbows");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "\nType the first of two skills,\nArcana, History, Insight, Investigation, Medicine, and Religion:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());
    System.out.printf("\nType the second skill:\n");
    System.out.print(">>> ");
    getSkills().add(input.nextLine());

    System.out.printf("\nEquipment:\n");
    System.out.printf("Type quarterstaff or dagger:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nType component pouch or an arcane focus:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    System.out.printf("\nScholar’s pack or a explorer’s pack:\n");
    System.out.print(">>> ");
    getEquipment().add(input.nextLine());
    getEquipment().add("Spellbook");
  }
}