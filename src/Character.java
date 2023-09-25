import java.util.ArrayList;

public class Character {
  private Stats abilityScores;
  private Skills skillList;

  // Creates a Character with using Default Ability Scores and no proficient
  // skills
  public Character() {
    ArrayList<String> prof = new ArrayList<>();
    abilityScores = new Stats();
    skillList = new Skills(abilityScores.getMods(), prof);
  }

  // Creates a Character in a way that mimicks irl character creation
  // if isStandard is true, it uses the standard ability score array
  // if true, it will mimic dice rolling as layed out by the rulebook
  // prof is a list of proficient skills
  public Character(boolean isStandard, ArrayList<String> prof) {
    abilityScores = new Stats(isStandard);
    skillList = new Skills(abilityScores.getMods(), prof);
  }

  // Creates a Character using an int array, to assign Ability Score directly
  // Throws Exception if the int array does not equal 6
  public Character(int[] n, ArrayList<String> prof) throws Exception {
    abilityScores = new Stats(n);
    skillList = new Skills(abilityScores.getMods(), prof);
  }

  // Creates a Character using Default Ability Score and no proficient skills
  public Character(ArrayList<String> prof) {
    abilityScores = new Stats();
    skillList = new Skills(abilityScores.getMods(), prof);
  }

  public String getAbilityScoresString() {
    return abilityScores.toString();
  }

  public String getSkillsString() {
    return skillList.toString();
  }

  public static void main(String[] args) throws Exception {
    int arr[] = { 11, 12, 13, 14, 15, 16 };
    ArrayList<String> prof = new ArrayList<>();
    prof.add("medicine");
    prof.add("arcana");

    // Character autoCreate = new Character();
    // System.out.println("=====Stats=====");
    // System.out.println(autoCreate.getAbilityScoresString());
    // System.out.println();
    // System.out.println("==========Skills==========");
    // System.out.println(autoCreate.getSkillsString());

    Character customCreate = new Character(arr, prof);
    System.out.println("=====Stats=====");
    System.out.println(customCreate.getAbilityScoresString());
    System.out.println();
    System.out.println("==========Skills==========");
    System.out.println(customCreate.getSkillsString());
  }
}
