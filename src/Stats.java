import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Stats {
  private int[] statLevel = new int[6];
  private int[] statModifiers = new int[6];
  private Scanner k = new Scanner(System.in);

  public Stats() {
    // Fills Ability Points with all 10s
    for (int i = 0; i < 6; i++) {
      setStat(i, 10);
    }
  }

  // Fill Ability Points with a custom number
  public Stats(int n) {
    // Fills both arrays with 0's
    for (int i = 0; i < 6; i++) {
      setStat(i, n);
    }
  }

  // Set Ability Points using a int array
  public Stats(int[] stats) throws Exception {
    if (stats.length != 6)
      throw new Exception("Invalid length int array");

    for (int i = 0; i < 6; i++)
      setStat(i, stats[i]);
  }

  public Stats(boolean isStandard) {
    ArrayList<Integer> statArray = new ArrayList<>();
    // If player decides to use the standard set of scores
    if (isStandard) {
      statArray.add(15);
      statArray.add(14);
      statArray.add(13);
      statArray.add(12);
      statArray.add(10);
      statArray.add(8);
    } else { // If they player decides to role the dice
      Random rng = new Random();
      ArrayList<Integer> dice = new ArrayList<>(4);

      // This whole thing mimics how it's done with real dice You role 4, throw
      // out the lowest role, add the 3 remaining numbers. You do that a total
      // of 6 times and those are what your stats will be
      for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 4; j++) {
          dice.add(rng.nextInt(6) + 1);
        }
        int lowestDie = 7;
        int lowestDieIndex = -1;
        for (int index = 0; index < 4; index++) {
          if (dice.get(index) < lowestDie) {
            lowestDie = dice.get(index);
            lowestDieIndex = index;
          }
        }
        dice.remove(lowestDieIndex);
        statArray.add(dice.get(0) + dice.get(1) + dice.get(2));
        dice.removeAll(dice);
      }
    }
    // Sorts the stats from highest to lowest
    Collections.sort(statArray, Collections.reverseOrder());

    // Runs through the rolled stats and lets you set what your character stats
    // will be
    while (statArray.size() != 0) {
      System.out.println("\n=====Current=Roles=====");
      System.out.println(statArray);
      System.out.println("=======================\n");
      setStat(chooseStat(statArray.get(0)), statArray.get(0));
      statArray.remove(0);
    }
  }

  // How the player picks what roles he wants for what stats
  public int chooseStat(int score) {
    boolean validInput = false;
    int index = -1;

    while (!validInput) {
      System.out.println("Choose what Stat to put " + score + " into: ");
      System.out.println("1. Stength (" + this.getStr() + ")");
      System.out.println("2. Dexterity (" + this.getDex() + ")");
      System.out.println("3. Constitution (" + this.getCon() + ")");
      System.out.println("4. Intelligence (" + this.getInt() + ")");
      System.out.println("5. Wisdom (" + this.getWis() + ")");
      System.out.println("6. Charisma (" + this.getCha() + ")");
      System.out.print(">>> ");
      index = k.nextInt() - 1;
      if (containsValue(index) != 0) {
        System.out.println("\nStat has already been chosen! Choose again\n");
      } else {
        validInput = true;
      }
    }
    return index;
  }

  // Checks to see if the stat has already been entered
  public int containsValue(int index) {
    switch (index) {
      case 0:
        return getStr();
      case 1:
        return getDex();
      case 2:
        return getCon();
      case 3:
        return getInt();
      case 4:
        return getWis();
      case 5:
        return getCha();
      default:
        break;
    }
    return 0;
  }

  // Sets the character stat
  private void setStat(int stat, int level) {
    this.statLevel[stat] = level;
    setMod(stat);
  }

  // Calculates what the stat modifier will be based on the stat level
  private void setMod(int stat) {
    int level;
    switch (this.statLevel[stat]) {
      case 1:
        level = -5;
        break;
      case 2:
      case 3:
        level = -4;
        break;
      case 4:
      case 5:
        level = -3;
        break;
      case 6:
      case 7:
        level = -2;
        break;
      case 8:
      case 9:
        level = -1;
        break;
      case 10:
      case 11:
        level = 0;
        break;
      case 12:
      case 13:
        level = 1;
        break;
      case 14:
      case 15:
        level = 2;
        break;
      case 16:
      case 17:
        level = 3;
        break;
      case 18:
      case 19:
        level = 4;
        break;
      case 20:
      case 21:
        level = 5;
        break;
      case 22:
      case 23:
        level = 6;
        break;
      case 24:
      case 25:
        level = 7;
        break;
      default:
        level = -10;
        break;
    }
    this.statModifiers[stat] = level;
  }

  public void modifyStats(int[] modifier) throws Exception {
    if (modifier.length != 6)
      throw new Exception("Modifier needs to be a int array of length 6");

    int newStats[] = getStats();
    for (int i = 0; i < 6; i++) {
      newStats[i] += modifier[i];
      setStat(i, newStats[i]);
    }
  }

  public int[] getStats() {
    return this.statLevel;
  }

  public int[] getMods() {
    return this.statModifiers;
  }

  public int getStr() {
    return this.statLevel[0];
  }

  public int getStrMod() {
    return this.statModifiers[0];
  }

  public int getDex() {
    return this.statLevel[1];
  }

  public int getDexMod() {
    return this.statModifiers[1];
  }

  public int getCon() {
    return this.statLevel[2];
  }

  public int getConMod() {
    return this.statModifiers[2];
  }

  public int getInt() {
    return this.statLevel[3];
  }

  public int getIntMod() {
    return this.statModifiers[3];
  }

  public int getWis() {
    return this.statLevel[4];
  }

  public int getWisMod() {
    return this.statModifiers[4];
  }

  public int getCha() {
    return this.statLevel[5];
  }

  public int getChaMod() {
    return this.statModifiers[5];
  }

  public void closeScanner() {
    k.close();
  }

  public String toString() {
    String output = "\nStr: " + this.getStr() + " | " + this.getStrMod() +
        "\nDex: " + this.getDex() + " | " + this.getDexMod() +
        "\nCon: " + this.getCon() + " | " + this.getConMod() +
        "\nInt: " + this.getInt() + " | " + this.getIntMod() +
        "\nWis: " + this.getWis() + " | " + this.getWisMod() +
        "\nCha: " + this.getCha() + " | " + this.getChaMod() + "\n";

    return output;
  }

  public static void main(String[] args) throws Exception {
    int stats[] = { 15, 14, 13, 12, 10, 8 };
    int modifier[] = { 10, 10, 10, 10, 10, 10 };
    Stats testStats = new Stats(stats);
    System.out.printf("\nStats before modifier: %s", testStats.toString());
    testStats.modifyStats(modifier);
    System.out.printf("\nStats after modifier: %s", testStats.toString());
  }
}
