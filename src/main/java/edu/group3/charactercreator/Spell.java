public class Spell {
    public enum DamageType {
        PSYCHIC,
        LIGHTNING,
        RADIANT,
        ACID,
        BLUDGEONING,
        COLD,
        FIRE,
        FORCE,
        NECROTIC,
        POISON,
        THUNDER
    };

    public enum School {
        DIVINATION,
        NECROMANCY,
        EVOCATION,
        ILLUSION,
        ABJURATION,
        CONJURATION,
        TRANSMUTATION,
        ENCHANTMENT
    };

    private String name;
    private String description;
    private int level; // 0: Cantrip, 1: Level 1
    private int range;
    private DamageType damageType;
    private School school;
    private int duration;
    private Time time;

    public Spell(String name,
            String description,
            int level,
            int range,
            String damageType,
            char school,
            int duration,
            int rounds,
            String actionType) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.range = range;
        this.duration = duration;
        this.time = new Time(rounds, actionType);

        damageType = damageType.toLowerCase();

        switch (damageType) {
            case "psychic":
                this.damageType = DamageType.PSYCHIC;
                break;
            case "lightning":
                this.damageType = DamageType.LIGHTNING;
                break;
            case "radiant":
                this.damageType = DamageType.RADIANT;
                break;
            case "acid":
                this.damageType = DamageType.ACID;
                break;
            case "bludgeoning":
                this.damageType = DamageType.BLUDGEONING;
                break;
            case "cold":
                this.damageType = DamageType.COLD;
                break;
            case "fire":
                this.damageType = DamageType.FIRE;
                break;
            case "force":
                this.damageType = DamageType.FORCE;
                break;
            case "necrotic":
                this.damageType = DamageType.NECROTIC;
                break;
            case "poison":
                this.damageType = DamageType.POISON;
                break;
            case "thunder":
                this.damageType = DamageType.THUNDER;
                break;
            default:
                this.damageType = DamageType.FORCE;
                break;
        }

        switch (school) {
            case 'D':
            case 'd':
                this.school = School.DIVINATION;
                break;
            case 'N':
            case 'n':
                this.school = School.NECROMANCY;
                break;
            case 'V':
            case 'v':
                this.school = School.EVOCATION;
                break;
            case 'I':
            case 'i':
                this.school = School.ILLUSION;
                break;
            case 'A':
            case 'a':
                this.school = School.ABJURATION;
                break;
            case 'C':
            case 'c':
                this.school = School.CONJURATION;
                break;
            case 'T':
            case 't':
                this.school = School.TRANSMUTATION;
                break;
            case 'E':
            case 'e':
                this.school = School.ENCHANTMENT;
                break;
            default:
                this.school = School.DIVINATION;
                break;
        }

    }

    public Spell() {
        this("Eldritch Blast", "Eldritch blast paaaawnch", 0, 120, "force", 'V', 0, 1, "action");
    }

    public String getLevel() {
        switch (this.level) {
            case 0:
                return "Cantrip";
            case 1:
                return "Level 1 Spell";
            default:
                return "Level -1 Spell";
        }
    }

    @Override
    public String toString() {
        String output = "";

        output += "========== " + this.name + " ==========\n";
        output += "Spell Level: " + this.getLevel();
        output += "\nRange: " + this.range + " meters";
        output += "\nDamage Type: " + this.damageType;
        output += "\nSchool of Magic: " + this.school;
        output += "\nDuration: " + this.duration + " rounds";
        output += "\nCast time: " + this.time;
        output += "\n======================";
        for (int i = 0; i < this.name.length(); i++) {
            output += "=";
        }
        output += "\nDescription: " + this.description;
        return output;
    }

    public static void main(String[] args) {
        Spell testSpell = new Spell();

        System.out.println(testSpell);
    }
}

class Time {
    public enum Unit {
        ACTION,
        BONUS
    }

    private int number;
    private Unit unit;

    public Time(int number, Unit unit) {
        this.number = number;
        this.unit = unit;
    }

    public Time(int number, String unit) {
        this.number = number;
        unit = unit.toLowerCase();

        switch (unit) {
            case "action":
                this.unit = Unit.ACTION;
                break;
            case "bonus":
                this.unit = Unit.BONUS;
                break;
            default:
                this.unit = Unit.ACTION;
                break;
        }
    }

    public int getRounds() {
        return this.number;
    }

    public void setRounds(int num) {
        this.number = num;
    }

    public Unit getTypeOfAction() {
        return unit;
    }

    public void setTypeOfAction(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return this.number + " round, using up your " + this.unit + " slot";
    }
}
