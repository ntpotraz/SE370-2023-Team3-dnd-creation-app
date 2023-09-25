import java.util.ArrayList;

public class RefactoredCharacter {
  private Stats abilityScores;
  private Skills skillList;

  public RefactoredCharacter() {
    ArrayList<String> prof = new ArrayList<>();
    abilityScores = new Stats(true);
    skillList = new Skills(abilityScores.getMods(), prof);
  }

  public RefactoredCharacter(boolean isStandard, ArrayList<String> prof) {
    abilityScores = new Stats(isStandard);
    skillList = new Skills(abilityScores.getMods(), prof);
  }

  public static void main(String[] args) {
    ArrayList<String> prof = new ArrayList<>();
    prof.add("medicine");
    prof.add("arcana");
    RefactoredCharacter test = new RefactoredCharacter(false, prof);

    System.out.println(test.abilityScores.toString());
    System.out.println();
    System.out.println(test.skillList.toString());
  }

}
