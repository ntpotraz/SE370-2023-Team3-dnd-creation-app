import java.util.ArrayList;

public class Character {
  private Stats abilityScores;
  private Skills skillList;

  public Character() {
    ArrayList<String> prof = new ArrayList<>();
    abilityScores = new Stats(true);
    skillList = new Skills(abilityScores.getMods(), prof);
  }

  public Character(boolean isStandard, ArrayList<String> prof) {
    abilityScores = new Stats(isStandard);
    skillList = new Skills(abilityScores.getMods(), prof);
  }

  public String getAbilityScoresString() {
    return abilityScores.toString();
  }

  public String getSkillsString() {
    return skillList.toString();
  }

  public static void main(String[] args) {
    ArrayList<String> prof = new ArrayList<>();
    prof.add("medicine");
    prof.add("arcana");
    Character test = new Character(false, prof);

    System.out.println("=====Stats=====");
    System.out.println(test.getAbilityScoresString());
    System.out.println();
    System.out.println("==========Skills==========");
    System.out.println(test.getSkillsString());

  }
}
