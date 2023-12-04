package edu.se370.team3;

import java.util.ArrayList;

public class Skills {
  // Bool: Proficient, Int: Modifier, String: Name, Integer: Stat index
  private ArrayList<Skill> skillList = new ArrayList<>();

  // Sets up the skills with a base case
  public Skills() {
    this.skillList.add(new Skill(false, 0, "acrobatics", 1));
    this.skillList.add(new Skill(false, 0, "animal_handling", 4));
    this.skillList.add(new Skill(false, 0, "arcana", 3));
    this.skillList.add(new Skill(false, 0, "athletics", 0));
    this.skillList.add(new Skill(false, 0, "deception", 5));
    this.skillList.add(new Skill(false, 0, "history", 3));
    this.skillList.add(new Skill(false, 0, "insight", 4));
    this.skillList.add(new Skill(false, 0, "intimidation", 5));
    this.skillList.add(new Skill(false, 0, "investigation", 3));
    this.skillList.add(new Skill(false, 0, "medicine", 4));
    this.skillList.add(new Skill(false, 0, "nature", 3));
    this.skillList.add(new Skill(false, 0, "perception", 4));
    this.skillList.add(new Skill(false, 0, "performance", 5));
    this.skillList.add(new Skill(false, 0, "persuasion", 5));
    this.skillList.add(new Skill(false, 0, "religion", 3));
    this.skillList.add(new Skill(false, 0, "sleight_of_hand", 1));
    this.skillList.add(new Skill(false, 0, "stealth", 1));
    this.skillList.add(new Skill(false, 0, "survival", 4));
  }

  public void insertModifiers(int[] mods) {
    for (Skill skill : this.skillList) {
      skill.setModifier(mods[skill.getIndex()]);
    }
  }

  public ArrayList<Skill> getSkills() {
    return this.skillList;
  }

  public void addProficiency(String name) {
    name = name.toLowerCase();
    for (Skill skill : this.skillList) {
      if (skill.getName().equals(name)) {
        skill.setProficient(true);
        skill.setModifier(skill.getModifier() + 2);
      }
    }
  }

  public void addProficiency(ArrayList<String> names) {
    for (String name : names) {
      addProficiency(name);
    }
  }

  public String toString() {
    String output = "";
    for (Skill skill : this.skillList) {
      output += skill.isProficient() + " | " + skill.getModifier() + " | " +
          skill.getName() + " | " + skill.getIndex() + "\n";
    }
    return output;
  }
}

class Skill {
  public boolean proficient;
  public int modifier;
  public final String name;
  public final int statIndex;

  public Skill(boolean proficient, int modifier, String name, int statIndex) {
    this.proficient = proficient;
    this.modifier = modifier;
    this.name = name;
    this.statIndex = statIndex;
  }

  public boolean isProficient() {
    return proficient;
  }

  public void setProficient(boolean proficient) {
    this.proficient = proficient;
  }

  public int getModifier() {
    return modifier;
  }

  public void setModifier(int modifier) {
    this.modifier = modifier;
  }

  public String getName() {
    return name;
  }

  public int getIndex() {
    return statIndex;
  }
}