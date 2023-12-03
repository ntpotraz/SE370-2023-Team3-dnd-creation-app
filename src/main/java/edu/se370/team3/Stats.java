package edu.se370.team3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Stats {
  private int[] statLevel = new int[6];
  private int[] statModifiers = new int[6];
  private ArrayList<Integer> statList;
  private Scanner k = new Scanner(System.in);

  public Stats() {
    setStat(0, 0);
    setStat(1, 0);
    setStat(2, 0);
    setStat(3, 0);
    setStat(4, 0);
    setStat(5, 0);
    this.statList = new ArrayList<Integer>();
  }

  public void rollDice() {
    Roll roll = new Roll();
    System.out.println("You rolled " + roll.getLowestDie() + ", " + roll.getFirstDice() + ", " + roll.getSecondDice()
        + ", " + roll.getThirdDice());
    System.out
        .println("Your low roll of " + roll.getLowestDie() + " will be thrown out for a total of " + roll.getTotal());
    this.statList.add(roll.getTotal());
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
    if (level > 25)
      level = 25;
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

  public void useStandardArray() {
    int[] stdArray = { 15, 14, 13, 12, 10, 8 };
    for (int stat : stdArray) {
      this.statList.add(stat);
    }
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

  @Override
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
    Stats test = new Stats();
    test.rollDice();
  }
}

class Roll {
  private int lowestDice;
  private int dice1;
  private int dice2;
  private int dice3;
  private int total;

  public Roll() {
    Random rng = new Random();
    int roll1 = rng.nextInt(6) + 1;
    int roll2 = rng.nextInt(6) + 1;
    int roll3 = rng.nextInt(6) + 1;
    int roll4 = rng.nextInt(6) + 1;

    ArrayList<Integer> rollSet = new ArrayList<Integer>();
    rollSet.add(roll1);
    rollSet.add(roll2);
    rollSet.add(roll3);
    rollSet.add(roll4);

    int lowest = 7;
    for (int roll : rollSet) {
      if (roll < lowest)
        lowest = roll;
    }
    this.lowestDice = lowest;
    rollSet.remove(rollSet.indexOf(lowest));
    this.dice1 = rollSet.remove(0);
    this.dice2 = rollSet.remove(0);
    this.dice3 = rollSet.remove(0);
    this.total = this.dice1 + this.dice2 + this.dice3;
  }

  public int getLowestDie() {
    return this.lowestDice;
  }

  public int getFirstDice() {
    return this.dice1;
  }

  public int getSecondDice() {
    return this.dice2;
  }

  public int getThirdDice() {
    return this.dice3;
  }

  public int getTotal() {
    return this.total;
  }
}
