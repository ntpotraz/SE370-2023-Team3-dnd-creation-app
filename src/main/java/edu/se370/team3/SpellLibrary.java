package edu.se370.team3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpellLibrary {
  private ArrayList<Spell> level1SpellList;
  private ArrayList<Spell> cantripList;
  private static ObjectMapper objMapper = getDefaultObjMapper();

  public SpellLibrary() {

  }

  private static ObjectMapper getDefaultObjMapper() {
    ObjectMapper defaultObjMapper = new ObjectMapper();

    return defaultObjMapper;
  }

  public static JsonNode parse(String src) throws IOException {
    return objMapper.readTree(src);
  }

  public static void main(String[] args) {
    String spellFile = "lib/1stspellsCantrips.json";
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayList<Spell> level1SpellList = new ArrayList<Spell>();
    ArrayList<Spell> cantripList = new ArrayList<Spell>();

    try {
      JsonNode jsonNode = objectMapper.readTree(new File(spellFile));

      String name = jsonNode.get(0).get("name").asText();
      System.out.println("Name: " + name);

      int level = jsonNode.get(0).get("level").asInt();
      System.out.println("Level: " + level);

      String school = jsonNode.get(0).get("school").asText();
      System.out.println("School: " + school);

      int rounds = jsonNode.get(0).get("time").get(0).get("number").asInt();
      System.out.println("Rounds: " + rounds);

      String actionType = jsonNode.get(0).get("time").get(0).get("unit").asText();
      System.out.println("Action type: " + actionType);

      int range = jsonNode.get(0).get("range").get("distance").get("amount").asInt();
      System.out.println("Range: " + range + " ft");

      // Chromatic Orb needs to be a special case
      String damageType = jsonNode.get(0).get("damageInflict").get(0).asText();
      System.out.println("Damage Type: " + damageType);

      // if
      // (jsonNode.get(0).get("duration").get(0).get("type").toString().equals("instant"))
      // {
      String duration = jsonNode.get(0).get("duration").get(0).get("type").asText();
      System.out.println("Duration: " + duration);
      // }

    } catch (

    IOException e) {
      e.printStackTrace();
    }
  }
}