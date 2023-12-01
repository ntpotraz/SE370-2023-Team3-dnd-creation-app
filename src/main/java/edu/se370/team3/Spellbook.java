package edu.se370.team3;

import java.util.ArrayList;

public class Spellbook {
    private static SpellLibrary library = new SpellLibrary();
    private ArrayList<Spell> spellBook;

    public Spellbook(ArrayList<String> spellBook) {
        if (spellBook.size() == 0) {
            this.spellBook = new ArrayList<Spell>();
        } else {
            for (String spellName : spellBook) {
                this.spellBook.add(library.getSpell(spellName));
            }
        }
    }

    public Spellbook() {
        this(new ArrayList<String>());
    }

}
