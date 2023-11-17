package se370.group3;

import java.util.ArrayList;
import java.util.Scanner;

public class Job {
    private int baseHP;
    // to be added to finalHP in character class while calculating final stats
    ArrayList<String> proficienciesTypes = new ArrayList<String>();
    // Arraylist index 0 = armor, 1 = weapons, 2 = tools
    ArrayList<String> skills = new ArrayList<String>();

    private Boolean strengthSV;
    private Boolean dexteritySV;
    private Boolean constitutionSV;
    private Boolean intelligenceSV;
    private Boolean wisdomSV;
    private Boolean charismaSV;

    Job() {
        baseHP = 0;
        proficienciesTypes.add("");
        proficienciesTypes.add("");
        proficienciesTypes.add("");
        strengthSV = false;
        dexteritySV = false;
        constitutionSV = false;
        intelligenceSV = false;
        wisdomSV = false;
        charismaSV = false;
    }

    int getBaseHP() {
        return baseHP;
    }

    Boolean getStr() {
        return strengthSV;
    }

    Boolean getDex() {
        return dexteritySV;
    }

    Boolean getCon() {
        return constitutionSV;
    }

    Boolean getInt() {
        return intelligenceSV;
    }

    Boolean getWis() {
        return wisdomSV;
    }

    Boolean getCha() {
        return charismaSV;
    }

    ArrayList<String> getSkills() {
        return skills;
    }

    ArrayList<String> getProficiancy() {
        return proficienciesTypes;
    }


        void Barbarian() {
            strengthSV = true;
            constitutionSV = true;
            baseHP = 12;
            proficienciesTypes.set(0, "light armor, medium armor, shields");
            proficienciesTypes.set(1, "simple weapons, martial weapons");

            Scanner input = new Scanner(System.in);
            System.out.printf(
                    "Type the first of the following skills that you'd like,\nAnimal Handling, Athletics, Intimidation, Nature, Perception, Survival:\n");
            skills.add(input.nextLine());
            System.out.printf(
                    "Type the second of the following skills that you'd like,\n*Animal Handling, Athletics, Intimidation, Nature, Perception, Survival:\n");
            skills.add(input.nextLine());
        }

        // Class Abilities v v v v v v v v v v v v v v v v v v v v

        String rage = "In battle, you fight with primal ferocity. On your turn,\r\n" + //
                "you can enter a rage as a bonus action.\r\n" + //
                "   While raging, you gain the following benefits if you\r\n" + //
                "aren't wearing heavy armor:\r\n" + //
                "- You have advantage on Strength checks and Strength\r\n" + //
                "saving throws.\r\n" + //
                "- When you make a melee weapon attack using\r\n" + //
                "Strength, you gain a bonus to the damage roll that\r\n" + //
                "increases as you gain levels as a barbarian, as shown\r\n" + //
                "in the Rage Damage colum n of the Barbarian table.\r\n" + //
                "- You have resistance to bludgeoning, piercing, and\r\n" + //
                "slashing damage.";


        void Bard() {
            dexteritySV = true;
            charismaSV = true;
            baseHP = 8;
            proficienciesTypes.set(0, "light armor");
            proficienciesTypes.set(1, "simple weapons, hand crossbows, longswords, rapiers, shortswords");
            proficienciesTypes.set(2, "Three musical instruments of your choice");

            Scanner input = new Scanner(System.in);
            System.out.printf("The Bard class gives access to any three skills,\n type the first skill :\n");
            skills.add(input.nextLine());
            System.out.printf("Type the second skill:\n");
            skills.add(input.nextLine());
            System.out.printf("Type the third skill:\n");
            skills.add(input.nextLine());
        }


        void Cleric() {
            wisdomSV = true;
            charismaSV = true;
            baseHP = 8;
            proficienciesTypes.set(0, "Light armor, medium armor, shields");
            proficienciesTypes.set(1, "All simple weapons");

            Scanner input = new Scanner(System.in);
            System.out.printf("Type the first of two skills,\nHistory, Insight, Medicine, Persuasion, and Religion:\n");
            skills.add(input.nextLine());
            System.out.printf("Type the second skill:\n");
            skills.add(input.nextLine());

        }


      void Druid() {
            intelligenceSV = true;
            wisdomSV = true;
            baseHP = 8;
            proficienciesTypes.set(0, "light armor, medium armor, shields");
            proficienciesTypes.set(1,
                    "clubs, daggers, darts, javelins, maces, quarterstaffs, scimitars, sickles, slings, spears");
            proficienciesTypes.set(2, "Herbalism kit");

            Scanner input = new Scanner(System.in);
            System.out.printf(
                    "Type the first of two skills,\nArcana, Animal Handling, Insight, Medicine, Nature, Perception, Religion, and Survival:\n");
            skills.add(input.nextLine());
            System.out.printf("Type the second skill:\n");
            skills.add(input.nextLine());
        }


    void Fighter() {
            strengthSV = true;
            constitutionSV = true;
            baseHP = 10;
            proficienciesTypes.set(0, "All armor, shields");
            proficienciesTypes.set(1, "Simple weapons, martial weapons");

            Scanner input = new Scanner(System.in);
            System.out.printf(
                    "Type the first of two skills,\nAcrobatics, Animal Handling, Athletics, History, Insight, Intimidation, Perception, and Survival:\n");
            skills.add(input.nextLine());
            System.out.printf("Type the second skill:\n");
            skills.add(input.nextLine());

        }


    void Monk() {
            dexteritySV = true;
            strengthSV = true;
            baseHP = 8;
            proficienciesTypes.set(1, "simple weapons, shortswords");
            proficienciesTypes.set(2, "Choose one type of artisan’s tools or one musical instrument");

            Scanner input = new Scanner(System.in);
            System.out.printf(
                    "Type the first of two skills,\nAcrobatics, Athletics, History, Insight, Religion, and Stealth:\n");
            skills.add(input.nextLine());
            System.out.printf("Type the second skill:\n");
            skills.add(input.nextLine());
        }


    void Paladin() {
            wisdomSV = true;
            charismaSV = true;
            baseHP = 10;
            proficienciesTypes.set(0, "all armor, shields");
            proficienciesTypes.set(1, "simple weapons, martial weapons");

            Scanner input = new Scanner(System.in);
            System.out.printf(
                    "Type the first of two skills,\nAthletics, Insight, Intimidation, Medicine, Persuasion, and Religion:\n");
            skills.add(input.nextLine());
            System.out.printf("Type the second skill:\n");
            skills.add(input.nextLine());
        }


    void Ranger() {
            dexteritySV = true;
            strengthSV = true;
            baseHP = 10;
            proficienciesTypes.set(0, "Light armor");
            proficienciesTypes.set(1, "Simple weapons, martial weapons");

            Scanner input = new Scanner(System.in);
            System.out.printf(
                    "Type the first of three skills,\nAnimal Handling, Athletics, Insight, Investigation, Nature, Perception, Stealth, and Survival\n");
            skills.add(input.nextLine());
            System.out.printf("Type the second skill:\n");
            skills.add(input.nextLine());
            System.out.printf("Type the third skill:\n");
            skills.add(input.nextLine());
        }


    void Rogue() {
            dexteritySV = true;
            intelligenceSV = true;
            baseHP = 8;
            proficienciesTypes.set(0, "Light armor");
            proficienciesTypes.set(1, "Simple weapons, hand crossbows, longswords, rapiers, shortswords");
            proficienciesTypes.set(2, "Thieves’ tools");

            Scanner input = new Scanner(System.in);
            System.out.printf(
                    "Type the first of four skills,\nAcrobatics, Athletics, Deception. Insight, Intimidation, Investigation, Perception, Performance. Persuasion, Sleight of Hand, and Stealth\n");
            skills.add(input.nextLine());
            System.out.printf("Type the second skill:\n");
            skills.add(input.nextLine());
            System.out.printf("Type the third skill:\n");
            skills.add(input.nextLine());
            System.out.printf("Type the fourth skill:\n");
            skills.add(input.nextLine());
        }


    void Sorcerer() {
            dexteritySV = true;
            constitutionSV = true;
            baseHP = 6;
            proficienciesTypes.set(1, "Daggers, darts, slings, quarterstaffs, light crossbows");

            Scanner input = new Scanner(System.in);
            System.out.printf(
                    "Type the first of two skills,\nArcana, Deception, Insight, Intimidation, Persuasion, and Religion:\n");
            skills.add(input.nextLine());
            System.out.printf("Type the second skill:\n");
            skills.add(input.nextLine());
        }


    void Warlock() {
            wisdomSV = true;
            charismaSV = true;
            baseHP = 8;
            proficienciesTypes.set(0, "Light armor");
            proficienciesTypes.set(1, "Simple weapons");

            Scanner input = new Scanner(System.in);
            System.out.printf(
                    "Type the first of two skills,\nArcana, Deception, History, Intimidation, Investigation, Nature, and Religion:\n");
            skills.add(input.nextLine());
            System.out.printf("Type the second skill:\n");
            skills.add(input.nextLine());
        }


    void Wizard() {
            wisdomSV = true;
            intelligenceSV = true;
            baseHP = 6;
            proficienciesTypes.set(1, "Daggers, darts, slings, quarterstaffs, light crossbows");

            Scanner input = new Scanner(System.in);
            System.out.printf(
                    "Type the first of two skills,\nArcana, History, Insight, Investigation, Medicine, and Religion:\n");
            skills.add(input.nextLine());
            System.out.printf("Type the second skill:\n");
            skills.add(input.nextLine());
        }

}
