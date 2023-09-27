import java.util.ArrayList;

public class Character {
  private Stats abilityScores;
  private Skills skillList;

  // Creates a Character with using Default Ability Scores and no proficient
  // skills
  public Character() {
    ArrayList<String> prof = new ArrayList<>();
    this.abilityScores = new Stats();
    this.skillList = new Skills(this.abilityScores.getMods(), prof);
  }

  // Creates a Character in a way that mimicks irl character creation
  // if isStandard is true, it uses the standard ability score array
  // if true, it will mimic dice rolling as layed out by the rulebook
  // prof is a list of proficient skills
  public Character(boolean isStandard, ArrayList<String> prof) {
    this.abilityScores = new Stats(isStandard);
    this.skillList = new Skills(this.abilityScores.getMods(), prof);
  }

  // Creates a Character using an int array, to assign Ability Score directly
  // Throws Exception if the int array does not equal 6
  public Character(int[] n, ArrayList<String> prof) throws Exception {
    this.abilityScores = new Stats(n);
    this.skillList = new Skills(this.abilityScores.getMods(), prof);
  }

  // Creates a Character using Default Ability Score and no proficient skills
  public Character(ArrayList<String> prof) {
    this.abilityScores = new Stats();
    this.skillList = new Skills(this.abilityScores.getMods(), prof);
  }

  // Returns the ablitityScores object
  // can use getStats() to get the int array of stats
  // and use getMods() to get the int array of ablility score modifiers
  // Can also use getStr() or getStrMod(), etc, for a specific score
  public Stats getStats() { return this.abilityScores; }

  public Skills getSkills() { return this.skillList; }

  public String getAbilityScoresString() {
    return this.abilityScores.toString();
  }

  public String getSkillsString() { return this.skillList.toString(); }

  class Race {

    String ageRange;
    ArrayList<String> proficiencies =
        new ArrayList<String>(); // Index 0 = Armor, 1 = Weapons, = 2 = Tools
    int statMods[] = new int[6];

    enum Size { SMALL, MEDIUM }

    // Temporary misc. traits for things like darkvision,
    // resistances, etc.
    ArrayList<String> traits = new ArrayList<String>();

    Race() {
      int mods[] = {2, 0, 2, 0, 2, 0};
      this.statMods = mods;
      this.proficiencies.add("Light Armor");
      this.proficiencies.add("Shortsword");
      this.proficiencies.add("Blacksmith Tools");
    }
  }

  public static void main(String[] args) throws Exception {
    int arr[] = {11, 12, 13, 14, 15, 16};
    ArrayList<String> prof = new ArrayList<>();
    prof.add("medicine");
    prof.add("arcana");

    // Character autoCreate = new Character();
    // System.out.println("=====Stats=====");
    // System.out.println(autoCreate.getAbilityScoresString());
    // System.out.println("==========Skills==========");
    // System.out.println(autoCreate.getSkillsString());

    Character customCreate = new Character(arr, prof);
    System.out.println("=====Stats=====");
    System.out.println(customCreate.getAbilityScoresString());
    System.out.println("==========Skills==========");
    System.out.println(customCreate.getSkillsString());
    System.out.println("Cha Mod: " + customCreate.getStats().getChaMod());
  }
}
