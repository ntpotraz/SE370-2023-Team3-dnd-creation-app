package edu.se370.team3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpellLibrary {
  private ArrayList<Spell> level1SpellList;
  private ArrayList<Spell> cantripList;

  public SpellLibrary() {
    String spellFile = "lib/1stspellsCantrips.json";
    ObjectMapper objectMapper = new ObjectMapper();
    this.level1SpellList = new ArrayList<Spell>();
    this.cantripList = new ArrayList<Spell>();

    try {

      JsonNode jsonNode = objectMapper.readTree(new File(spellFile));

      for (JsonNode entry : jsonNode) {

        String name = entry.get("name").asText();
        int level = entry.get("level").asInt();
        String school = entry.get("school").asText();
        int rounds = entry.get("time").get(0).get("number").asInt();
        String actionType = entry.get("time").get(0).get("unit").asText();
        int range = 0;
        if (entry.get("range").get("distance").has("amount")) {
          range = entry.get("range").get("distance").get("amount").asInt();
        }
        String damageType = "none";
        if (entry.has("damageInflict")) { // Chromatic Orb needs to be a special case
          damageType = entry.get("damageInflict").get(0).asText();
        }
        String durationType = "instant";
        int duration = 0;
        if (entry.get("duration").get(0).get("type").asText().equals("timed")) {
          durationType = entry.get("duration").get(0).get("duration").get("type").asText();
          duration = entry.get("duration").get(0).get("duration").get("amount").asInt();
        }
        String description = "";
        for (JsonNode desc : entry.get("entries")) {
          description += desc.asText() + " ";
        }

        Spell spell = new Spell(name, level, school, rounds, actionType, range, damageType, durationType, duration,
            description);

        if (level == 0) {
          this.cantripList.add(spell);
        } else {
          this.level1SpellList.add(spell);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Spell getSpell(String name) {
    name = name.toLowerCase();
    for (Spell spell : cantripList) {
      if (spell.getName().toLowerCase().equals(name))
        return spell;
    }
    for (Spell spell : level1SpellList) {
      if (spell.getName().toLowerCase().equals(name))
        return spell;
    }
    return new Spell();
  }

  public static void main(String[] args) {

    SpellLibrary library = new SpellLibrary();

    // ArrayList<String> test = new ArrayList<String>();
    // for (Spell spell : library.cantripList) {
    // test.add(spell.getName());
    // }
    // System.out.println(test);

    System.out.println("Number of cantrips: " + library.cantripList.size());
    System.out.println("Number of level 1 spells: " + library.level1SpellList.size());
    System.out.println();
    System.out.println(library.getSpell("eldritch blast"));
    System.out.println(library.getSpell("detect magic"));

  }
}
