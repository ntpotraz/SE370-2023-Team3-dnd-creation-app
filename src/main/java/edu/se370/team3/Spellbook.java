package edu.se370.team3;

import java.io.IOException;
import java.util.ArrayList;

public class Spellbook {
  private SpellLibrary library;
  private ArrayList<Spell> spellBook;
  private String job;

  public Spellbook() {
    this.job = "Formless";
    this.library = new SpellLibrary();
    this.spellBook = new ArrayList<Spell>();
  }

  public void setJob(String job) {
    this.job = job;
    this.library.setJobLibrary(this.job);
  }

  public void addSpell(String name) throws IOException {
    this.spellBook.add(this.library.getSpell(name));
  }

  public void addSpells(ArrayList<String> spells) throws IOException {
    if (spells.size() != 0) {
      for (String spell : spells) {
        this.addSpell(spell);
      }
    }
  }

  public ArrayList<String> getAvailableCantrips() {
    return this.library.getJobCantripNames();
  }

  public ArrayList<String> getAvailableSpells() {
    return this.library.getJobSpellNames();
  }

  public void removeSpell(String name) {
    this.library.removeSpell(name);
  }

  public void printSpellbook() {
    for (Spell spell : this.spellBook) {
      System.out.println(spell.getLevel() + " | " + spell.getName());
    }
  }

  public String getSpellbookAsString() {
    StringBuilder sb = new StringBuilder();
    for (Spell spell : this.spellBook) {
      sb.append(spell.getLevel()).append(" | ").append(spell.getName()).append("\n");
    }
    return sb.toString();
  }
}
