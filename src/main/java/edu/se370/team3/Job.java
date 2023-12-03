package edu.se370.team3;

import java.util.ArrayList;
import java.util.Scanner;

public class Job {
  private String jobTitle;
  private int baseHP;
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
    getProficiancy().set(0, "light armor");
    getProficiancy().set(1, "simple weapons, hand crossbows, longswords, rapiers, shortswords");
    getProficiancy().set(2, "Three musical instruments of your choice");

    Scanner input = new Scanner(System.in);
    System.out.printf("The Bard class gives access to any three skills,\n type the first skill :\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the second skill:\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the third skill:\n");
    getSkills().add(input.nextLine());

    System.out.printf("Equipment:\n");
    System.out.printf("type rapier, longsword, or any simple weapon:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Diplomat’s pack or an entertainer's pack:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Lute or any other musical instrument:\n");
    getEquipment().add(input.nextLine());
    getEquipment().add("Leather armor");
    getEquipment().add("Dagger");
  }

  void Cleric() {
    setJobTitle("Cleric");
    setWis();
    setCha();
    setBaseHP(8);
    getProficiancy().set(0, "Light armor, medium armor, shields");
    getProficiancy().set(1, "All simple weapons");

    Scanner input = new Scanner(System.in);
    System.out.printf("Type the first of two skills,\nHistory, Insight, Medicine, Persuasion, and Religion:\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the second skill:\n");
    getSkills().add(input.nextLine());

    System.out.printf("Equipment:\n");
    System.out.printf("Type mace, or warhammer (if proficient):\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Scale mail, leather armor, or chain mail (if proficient):\n");
    getEquipment().add(input.nextLine());
    System.out.printf("light crossbow and 20 bolts or any simple weapon:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Priest’s pack or an explorer’s pack:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Holy symbol:\n");
    getEquipment().add(input.nextLine());
    getEquipment().add("Shield");
  }

  void Druid() {
    setJobTitle("Druid");
    setInt();
    setWis();
    setBaseHP(8);
    getProficiancy().set(0, "light armor, medium armor, shields");
    getProficiancy().set(1,
        "clubs, daggers, darts, javelins, maces, quarterstaffs, scimitars, sickles, slings, spears");
    getProficiancy().set(2, "Herbalism kit");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "Type the first of two skills,\nArcana, Animal Handling, Insight, Medicine, Nature, Perception, Religion, and Survival:\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the second skill:\n");
    getSkills().add(input.nextLine());

    System.out.printf("Equipment:\n");
    System.out.printf("Type wooden shield or any simple weapon:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Scimitar or any simple melee weapon:\n");
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
    getProficiancy().set(0, "All armor, shields");
    getProficiancy().set(1, "Simple weapons, martial weapons");
    String in = "";

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "Type the first of two skills,\nAcrobatics, Animal Handling, Athletics, History, Insight, Intimidation, Perception, and Survival:\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the second skill:\n");
    getSkills().add(input.nextLine());

    System.out.printf("Equipment:\n");
    System.out.printf("Type chain mail or B for leather armor, longbow, and 20 arrows:\n");
    in = input.nextLine();
    if (in == "b") {
      getEquipment().add("leather armor");
      getEquipment().add("long bow");
      getEquipment().add("20 arrows");
    } else {
      getEquipment().add(input.nextLine());
    }

    System.out.printf("A martial weapon and a shield or two martial weapons:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("A light crossbow and 20 bolts, or two handaxes:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Dungeoneer’s pack or (b) an explorer’s pack:\n");
    getEquipment().add(input.nextLine());
  }

  void Monk() {
    setJobTitle("Monk");
    setDex();
    setStr();
    setBaseHP(8);
    getProficiancy().set(1, "simple weapons, shortswords");
    getProficiancy().set(2, "Choose one type of artisan’s tools or one musical instrument");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "Type the first of two skills,\nAcrobatics, Athletics, History, Insight, Religion, and Stealth:\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the second skill:\n");
    getSkills().add(input.nextLine());

    System.out.printf("Equipment:\n");
    System.out.printf("type shortsword or any simple weapon:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Dungeoneer’s pack or an explorer’s pack:\n");
    getEquipment().add(input.nextLine());
    getEquipment().add("10 Darts");
  }

  void Paladin() {
    setJobTitle("Paladin");
    setWis();
    setCha();
    setBaseHP(10);
    getProficiancy().set(0, "all armor, shields");
    getProficiancy().set(1, "simple weapons, martial weapons");
    String in;

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "Type the first of two skills,\nAthletics, Insight, Intimidation, Medicine, Persuasion, and Religion:\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the second skill:\n");
    getSkills().add(input.nextLine());

    System.out.printf("Equipment:\n");
    System.out.printf("Type a martial weapon then shield or B for two martial weapons:\n");
    in = input.nextLine();
    if (in == "b") {
      System.out.printf("Martial weapon 1:\n");
      getEquipment().add(input.nextLine());
      System.out.printf("Martial weapon 2:\n");
      getEquipment().add(input.nextLine());
    } else {
      getEquipment().add(input.nextLine());
      getEquipment().add(input.nextLine());
    }

    System.out.printf("Five javelins or any simple melee weapon:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("A priest’s pack or an explorer’s pack:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Dungeoneer’s pack or (b) an explorer’s pack:\n");
    getEquipment().add(input.nextLine());
    getEquipment().add("Chainmail");
    getEquipment().add("Holy symbol");
  }

  void Ranger() {
    setJobTitle("Ranger");
    setDex();
    setStr();
    setBaseHP(10);
    getProficiancy().set(0, "Light armor");
    getProficiancy().set(1, "Simple weapons, martial weapons");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "Type the first of three skills,\nAnimal Handling, Athletics, Insight, Investigation, Nature, Perception, Stealth, and Survival\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the second skill:\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the third skill:\n");
    getSkills().add(input.nextLine());

    String in;
    System.out.printf("Equipment:\n");
    System.out.printf("Type two shortswords or b for two simple melee weapons:\n");
    in = input.nextLine();
    if (in == "b") {
      System.out.printf("Simple weapon 1:\n");
      getEquipment().add(input.nextLine());
      System.out.printf("Simple weapon 2:\n");
      getEquipment().add(input.nextLine());
    } else {
      getEquipment().add("Shortsword");
      getEquipment().add("Shortsword");
    }

    System.out.printf("Type scale mail or leather armor:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Dungeoneer’s pack or an explorer’s pack:\n");
    getEquipment().add(input.nextLine());
    getEquipment().add("longbow + quiver of 20 arrows");
  }

  void Rogue() {
    setJobTitle("Rogue");
    setDex();
    setInt();
    setBaseHP(8);
    getProficiancy().set(0, "Light armor");
    getProficiancy().set(1, "Simple weapons, hand crossbows, longswords, rapiers, shortswords");
    getProficiancy().set(2, "Thieves’ tools");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "Type the first of four skills,\nAcrobatics, Athletics, Deception. Insight, Intimidation, Investigation, Perception, Performance. Persuasion, Sleight of Hand, and Stealth\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the second skill:\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the third skill:\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the fourth skill:\n");
    getSkills().add(input.nextLine());

    System.out.printf("Equipment:\n");
    System.out.printf("Type rapier or a shortsword:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Shortbow and 20 arrows or a shortsword:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Burglar’s pack, a dungeoneer’s pack, or an explorer’s pack:\n");
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
    getProficiancy().set(1, "Daggers, darts, slings, quarterstaffs, light crossbows");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "Type the first of two skills,\nArcana, Deception, Insight, Intimidation, Persuasion, and Religion:\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the second skill:\n");
    getSkills().add(input.nextLine());

    String in;
    System.out.printf("Equipment:\n");
    System.out.printf("Type any simple weapon or b for a light crossbow and 20 bolts:\n");
    in = input.nextLine();
    if (in == "b") {
      getEquipment().add("Light crossbow");
      getEquipment().add("20 Bolts");
    } else {
      getEquipment().add(in);
    }

    System.out.printf("Type component pouch or an arcane focus:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Dungeoneer’s pack or an explorer’s pack:\n");
    getEquipment().add(input.nextLine());
    getEquipment().add("Two daggers");
  }

  void Warlock() {
    setJobTitle("Warlock");
    setWis();
    setCha();
    setBaseHP(8);
    getProficiancy().set(0, "Light armor");
    getProficiancy().set(1, "Simple weapons");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "Type the first of two skills,\nArcana, Deception, History, Intimidation, Investigation, Nature, and Religion:\n");
    getSkills().add(input.nextLine());

    String in;
    System.out.printf("Equipment:\n");
    System.out.printf("Type any simple weapon or b for a light crossbow and 20 bolts:\n");
    in = input.nextLine();
    if (in == "b") {
      getEquipment().add("Light crossbow");
      getEquipment().add("20 Bolts");
    } else {
      getEquipment().add(in);
    }

    System.out.printf("Type component pouch or an arcane focus:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("scholar’s pack or a dungeoneer’s pack:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Type any simple weapon:\n");
    getEquipment().add(input.nextLine());
    getEquipment().add("Two daggers");
    getEquipment().add("Leather armor");
  }

  void Wizard() {
    setJobTitle("Wizard");
    setWis();
    setInt();
    setBaseHP(6);
    getProficiancy().set(1, "Daggers, darts, slings, quarterstaffs, light crossbows");

    Scanner input = new Scanner(System.in);
    System.out.printf(
        "Type the first of two skills,\nArcana, History, Insight, Investigation, Medicine, and Religion:\n");
    getSkills().add(input.nextLine());
    System.out.printf("Type the second skill:\n");
    getSkills().add(input.nextLine());

    System.out.printf("Equipment:\n");
    System.out.printf("Type quarterstaff or dagger:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("Type component pouch or an arcane focus:\n");
    getEquipment().add(input.nextLine());
    System.out.printf("scholar’s pack or a explorer’s pack:\n");
    getEquipment().add(input.nextLine());
    getEquipment().add("Spellbook");
  }
}