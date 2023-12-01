package edu.se370.team3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpellLibrary {
  private String job;
  private ArrayList<Spell> spellList;
  private ArrayList<Spell> cantripList;

  private ArrayList<Spell> jobSpells = new ArrayList<Spell>();
  private ArrayList<Spell> jobCantrips = new ArrayList<Spell>();

  private List<String> bardCantripList = List.of(
      "blade ward",
      "dancing lights",
      "friends",
      "light",
      "mage hand",
      "mending",
      "message",
      "minor illusion",
      "prestidigitation",
      "true strike",
      "vicious mockery");
  private List<String> bardSpellList = List.of(
      "animal friendship",
      "bane",
      "charm person",
      "comprehend languages",
      "cure wounds",
      "detect magic",
      "disguise self",
      "dissonant whispers",
      "faerie fire",
      "feather fall",
      "healing word",
      "heroism",
      "hideous laughter",
      "identify",
      "illusory script",
      "longstrider",
      "silent image",
      "sleep",
      "speak with animals",
      "tasha's hideous laughter",
      "thunderwave",
      "unseen servant");
  private List<String> clericCantripList = List.of(
      "guidance",
      "light",
      "mending",
      "resistance",
      "sacred flame",
      "spare the dying",
      "thaumaturgy");
  private List<String> clericSpellList = List.of(
      "bane",
      "bless",
      "command",
      "create or destroy water",
      "cure wounds",
      "detect evil and good",
      "detect magic",
      "detect poison and disease",
      "guiding bolt",
      "healing word",
      "inflict wounds",
      "protection from evil and good",
      "purify food and drink",
      "sanctuary",
      "shield of faith");
  private List<String> druidCantripList = List.of(
      "druidcraft",
      "guidance",
      "mending",
      "poison spray",
      "produce flame",
      "resistance",
      "shillelagh",
      "thorn whip");
  private List<String> druidSpellList = List.of(
      "animal friendship",
      "charm person",
      "create or destroy water",
      "cure wounds",
      "detect magic",
      "detect poison and disease",
      "entangle",
      "faerie fire",
      "fog cloud",
      "goodberry",
      "healing word",
      "jump",
      "longstrider",
      "purify food and drink",
      "speak with animals",
      "thunderwave");
  private List<String> paladinCantripList = List.of();
  private List<String> paladinSpellList = List.of(
      "bless",
      "command",
      "compelled duel",
      "cure wounds",
      "detect evil and good",
      "detect magic",
      "detect poison and disease",
      "divine favor",
      "heroism",
      "protection from evil and good",
      "purify food and drink",
      "searing smite",
      "shield of faith",
      "thunderous smite",
      "wrathful smite");
  private List<String> rangerCantripList = List.of();
  private List<String> rangerSpellList = List.of(
      "alarm",
      "animal friendship",
      "cure wounds",
      "detect magic",
      "detect poison and disease",
      "ensnaring strike",
      "fog cloud",
      "goodberry",
      "hail of thorns",
      "hunter's mark",
      "jump",
      "longstrider",
      "speak with animals");
  private List<String> sorcererCantripList = List.of(
      "acid splash",
      "blade ward",
      "chill touch",
      "dancing lights",
      "fire bolt",
      "friends",
      "light",
      "mage hand",
      "mending",
      "message",
      "minor illusion",
      "poison spray",
      "prestidigitation",
      "ray of frost",
      "shocking grasp",
      "true strike");
  private List<String> sorcererSpellList = List.of(
      "burning hands",
      "charm person",
      "chromatic orb",
      "color spray",
      "comprehend languages",
      "detect magic",
      "disguise self",
      "expeditious retreat",
      "false life",
      "feather fall",
      "fog cloud",
      "jump",
      "mage armor",
      "magic missle",
      "ray of sickness",
      "shield",
      "silent image",
      "sleep",
      "thunderwave",
      "witch bolt");
  private List<String> warlockCantripList = List.of(
      "blade ward",
      "chill touch",
      "eldritch blast",
      "friends",
      "mage hand",
      "minor illusion",
      "poison spray",
      "prestidigitation",
      "true strike");
  private List<String> warlockSpellList = List.of(
      "armor of agathys",
      "arms of hadar",
      "charm person",
      "comprehend languages",
      "expeditious retreat",
      "hellish rebuke",
      "hex",
      "illusory script",
      "protection from evil and good",
      "unseen servant",
      "witch bolt");
  private List<String> wizardCantripList = List.of(
      "acid splash",
      "blade ward",
      "chill touch",
      "dancing lights",
      "fire bolt",
      "friends",
      "light",
      "mage hand",
      "mending",
      "message",
      "minor illusion",
      "poison spray",
      "prestidigitation",
      "ray of frost",
      "shocking grasp",
      "true strike");
  private List<String> wizardSpellList = List.of(
      "alarm",
      "burning hands",
      "charm person",
      "chromatic orb",
      "color spray",
      "comprehend languages",
      "detect magic",
      "disguise self",
      "expeditious retreat",
      "false life",
      "feather fall",
      "find familiar",
      "floating disk",
      "fog cloud",
      "grease",
      "hideous laughter",
      "identify",
      "illusory script",
      "jump",
      "longstrider",
      "mage armor",
      "magic missle",
      "protection from good and evil",
      "ray of sickness",
      "shield",
      "silent image",
      "sleep",
      "tasha's hideous laughter",
      "tenser's floating disk",
      "tunderwave",
      "unseen servant",
      "witch bolt");

  public SpellLibrary(String job) {
    this.job = job.toLowerCase();

    String spellFile = "lib/1stspellsCantrips.json";
    ObjectMapper objectMapper = new ObjectMapper();
    this.spellList = new ArrayList<Spell>();
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
          this.spellList.add(spell);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    List<String> tempCantrips;
    List<String> tempSpells;

    switch (this.job) {
      case "bard":
        tempCantrips = bardCantripList;
        tempSpells = bardSpellList;
        break;
      case "cleric":
        tempCantrips = clericCantripList;
        tempSpells = clericSpellList;
        break;
      case "druid":
        tempCantrips = druidCantripList;
        tempSpells = druidSpellList;
        break;
      case "paladin":
        tempCantrips = paladinCantripList;
        tempSpells = paladinSpellList;
        break;
      case "ranger":
        tempCantrips = rangerCantripList;
        tempSpells = rangerSpellList;
        break;
      case "sorcerer":
        tempCantrips = sorcererCantripList;
        tempSpells = sorcererSpellList;
        break;
      case "warlock":
        tempCantrips = warlockCantripList;
        tempSpells = warlockSpellList;
        break;
      case "wizard":
        tempCantrips = wizardCantripList;
        tempSpells = wizardSpellList;
        break;
      default:
        tempCantrips = List.of();
        tempSpells = List.of();
        break;
    }

    for (Spell spell : this.cantripList) {
      String spellName = spell.getName().toLowerCase();
      if (tempCantrips.contains(spellName)) {
        this.jobCantrips.add(spell);
      }
    }
    for (Spell spell : this.spellList) {
      String spellName = spell.getName().toLowerCase();
      if (tempSpells.contains(spellName)) {
        this.jobSpells.add(spell);
      }
    }

  }

  public SpellLibrary() {
    this("bard");
  }

  public Spell getSpell(String name) {
    name = name.toLowerCase();
    for (Spell spell : cantripList) {
      if (spell.getName().toLowerCase().equals(name))
        return spell;
    }
    for (Spell spell : spellList) {
      if (spell.getName().toLowerCase().equals(name))
        return spell;
    }
    return new Spell();
  }

  public ArrayList<Spell> getJobSpells() {
    return this.jobSpells;
  }

  public ArrayList<Spell> getJobCantrips() {
    return this.jobCantrips;
  }

  public ArrayList<String> getJobSpellNames() {
    ArrayList<String> nameList = new ArrayList<String>();

    for (Spell spell : this.jobSpells) {
      nameList.add(spell.getName());
    }

    return nameList;
  }

  public ArrayList<String> getJobCantripNames() {
    ArrayList<String> nameList = new ArrayList<String>();

    for (Spell spell : this.jobCantrips) {
      nameList.add(spell.getName());
    }

    return nameList;
  }

  public static void main(String[] args) {

    SpellLibrary library = new SpellLibrary("sorcerer");

    // ArrayList<String> test = new ArrayList<String>();
    // for (Spell spell : library.cantripList) {
    // test.add(spell.getName());
    // }
    // System.out.println(test);

    System.out.println("Number of cantrips: " + library.cantripList.size());
    System.out.println("Number of level 1 spells: " + library.spellList.size());
    System.out.println();
    // System.out.println(library.getSpell("eldritch blast"));
    // System.out.println(library.getSpell("detect magic"));

    System.out.println(library.getJobCantripNames());
    System.out.println(library.getJobSpellNames());
  }
}
