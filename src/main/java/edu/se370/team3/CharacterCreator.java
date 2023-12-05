package edu.se370.team3;

import java.util.Scanner;

public class CharacterCreator {
  public static void main(String[] args) throws Exception {
    Scanner kb = new Scanner(System.in);
    String input = "";
    Character character = new Character();
    Race characterRace = character.getRace();
    Job characterJob = character.getJob();
    Stats characterStats = character.getStats();
    Skills characterSkills = character.getSkills();

    System.out.println("Welcome the Dungeons and Dragon Character Creator!");

    // name
    System.out.print("Enter character name:\n>>> ");
    input = kb.nextLine();
    character.setName(input);
    // job
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

    // race
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

    // background
    System.out.println("\nPlease choose desired Background from the list below:");
    System.out.println(
        "1. Acolyte\n" +
            "2. Charlatan\n" +
            "3. Criminal\n" +
            "4. Entertainer\n" +
            "5. Folk Hero\n" +
            "6. Guild Artisan\n" +
            "7. Hermit\n" +
            "8. Noble\n" +
            "9. Outlander\n" +
            "10. Sage\n" +
            "11. Sailor\n" +
            "12. Soldier\n" +
            "13. Urchin");
    System.out.print(">>> ");
    input = kb.nextLine();
    character.setBackground(input);
    System.out.println("Background: " + character.getBackground().getBackgroundTitle());

    // stats
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
    System.out.println("Here are your points to allocate to your stats:");
    System.out.println(character.getStats().getStatList());

    while (character.getStats().getStatList().size() != 0) {
      System.out.println("\nSelect a skill to allocate {" + character.getStats().getFirstStatInList() + "} to");
      System.out.println(
          "1. Strength (" + character.getStats().getStr() + ")\n" +
              "2. Dexterity (" + character.getStats().getDex() + ")\n" +
              "3. Constitution (" + character.getStats().getCon() + ")\n" +
              "4. Intelligence (" + character.getStats().getInt() + ")\n" +
              "5. Wisdom (" + character.getStats().getWis() + ")\n" +
              "6. Charisma (" + character.getStats().getCha() + ")");
      System.out.print(">>> ");
      character.getStats().selectStat(kb.nextInt() - 1);
    }
    character.getStats().modifyStats(character.getRace().getStatMods());
    character.addHealth(character.getStats().getDexMod());
    System.out.println("\nStats:");
    System.out.println(character.getStats().toString());

    // skills
    System.out.println("Here are your skill proficiencies based on previous choices:");
    character.getSkills().insertModifiers(character.getStats().getMods());
    character.getSkills().addProficiency(character.getJob().getSkills());
    character.getSkills().addProficiency(character.getBackground().getSkills());
    System.out.println(character.getSkills().toString());
    kb.close();

    // spells
    character.getSpellbook().setJob(character.getJob().getJobTitle());
    character.getSpellbook().addSpells(character.getRace().getSpells());
    character.getSpellbook().addSpells(character.getRace().getCantrips());
    System.out.println("\nSpells:");
    character.getSpellbook().printSpellbook();

    System.out.println("\n\n~~~~~~~~~~ Character Sheet ~~~~~~~~~~");
    System.out.println("You created a " +
        character.getRace().getRace() + " " + character.getJob().getJobTitle() +
        " named " + character.getName() + " with " + character.getHealth() +
        " HP. You have background of " + character.getBackground().getBackgroundTitle() + "\n\n");
    System.out.println("Here are you stats and skills:");
    System.out.println(character.getStats().toString());
    System.out.println(character.getSkills().toString());
    System.out.println("\nFinally, here is your spellbook:");
    character.getSpellbook().printSpellbook();
  }
}