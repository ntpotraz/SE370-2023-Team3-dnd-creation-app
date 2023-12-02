package edu.se370.team3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Spellbook {
    private SpellLibrary library;
    private ArrayList<Spell> spellBook;
    private String job;

    public Spellbook(String job, ArrayList<String> spellBook) {
        this.job = job;
        this.library = new SpellLibrary(this.job);
        if (spellBook.size() == 0) {
            this.spellBook = new ArrayList<Spell>();
        } else {
            for (String spellName : spellBook) {
                this.spellBook.add(library.getSpell(spellName));
            }
        }
    }

    public Spellbook(String job) {
        this(job, new ArrayList<String>());
    }

    public Spellbook() {
        this("bard", new ArrayList<String>());
    }

    public void addSpell(String name) throws IOException {
        this.spellBook.add(this.library.getSpell(name));
    }

    public void removeSpell(String name) {
        this.library.removeSpell(name);
    }

    public void printSpellbook() {
        System.out.println("~~~~~~~~~ Spellbook ~~~~~~~~~");
        for (Spell spell : this.spellBook) {
            System.out.println(spell.getLevel() + " | " + spell.getName());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void main(String[] args) {
        Spellbook spellbook = new Spellbook("paladin");
        Scanner kb = new Scanner(System.in);
        String input = "";

        while (!input.equals("end")) {
            System.out.println("~~~~~~~~ Cantrips ~~~~~~~~");
            for (String name : spellbook.library.getJobCantripNames()) {
                System.out.println(name);
            }
            System.out.println();
            System.out.println("~~~~~~~~ Spells ~~~~~~~~");
            for (String name : spellbook.library.getJobSpellNames()) {
                System.out.println(name);
            }
            System.out.println();

            System.out.print("Enter spell name:\n>>> ");
            input = kb.nextLine();
            System.out.println("Input: " + input);
            try {
                if (!input.equals("end")) {
                    spellbook.addSpell(input);
                    spellbook.removeSpell(input);
                    spellbook.printSpellbook();
                }
            } catch (IOException e) {
                System.out.println("!!!Invalid spell name!!!");
            }
        }
        System.out.println("~~~~~~~~~ Final Spellbook ~~~~~~~~~");
        spellbook.printSpellbook();
        kb.close();
    }
}
