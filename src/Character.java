import java.util.*;

abstract class Character {
    int strength;
    int strengthMod;
    int dexterity;
    int dexterityMod;
    int constitution;
    int constitutionMod;
    int intelligence;
    int intelligenceMod;
    int wisdom;
    int wisdomMod;
    int charisma;
    int charismaMod;
    final int level = 1;
    int hp = 0;
    int ac = 10;
    int initiative;
    int speed;

    //Saving throws and skill proficiencies   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v
    Boolean strengthSV = false;
    Boolean dexteritySV = false;
    Boolean constitutionSV = false;
    Boolean intelligenceSV = false;
    Boolean wisdomSV = false;
    Boolean charismaSV = false;

    Boolean acrobatics = false;
    Boolean animalHandling = false;
    Boolean arcana = false;
    Boolean athletics = false;
    Boolean deception = false;
    Boolean history = false;
    Boolean insight = false;
    Boolean intimidation = false;
    Boolean investigation = false;
    Boolean medicine = false;
    Boolean nature = false;
    Boolean perception = false;
    Boolean performance = false;
    Boolean persuasion = false;
    Boolean religion = false;
    Boolean sleightOfHand = false;
    Boolean stealth = false;
    Boolean survival = false;

    final int profBonus = 2;
    final int inspiration = 0;

    Character(){
        strength = dexterity = constitution = intelligence = wisdom = charisma = 0;
        strengthMod = dexterityMod = constitutionMod = intelligenceMod = wisdomMod = charismaMod = 0;
    }

    void printStats(){
        System.out.println("Strength: " + strength + "  Modifier: " + strengthMod);
        System.out.println("Dexterity: " + dexterity + "    Modifier: " + dexterityMod);
        System.out.println("Constitution: " + constitution + "  Modifier: " + constitutionMod);
        System.out.println("Intelligence: " + intelligence + "  Modifier: " + intelligenceMod);
        System.out.println("Wisdom: " + wisdom + "  Modifier: " + wisdomMod);
        System.out.println("Charisma: " + charisma + "  Modifier: " + charismaMod);
    }

    void generateStats(){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0;i<6;i++){
        int roll1 = rand.nextInt(6) + 1;
        int lowest = roll1;
        int roll2 = rand.nextInt(6) + 1;
        if(lowest >= roll2){
            lowest = roll2;
        }
        int roll3 = rand.nextInt(6) + 1;
        if(lowest >= roll3){
            lowest = roll3;
        }
        int roll4 = rand.nextInt(6) + 1;
        if(lowest >= roll4){
            lowest = roll4;
        }
        int totalRoll = roll1+roll2+roll3+roll4-lowest;
        System.out.println("Stat: "+totalRoll);
        numbers.add(totalRoll);
        }

        int index = 0;
        boolean changeFlag = false;
        System.out.println("What is your Strength score?");
        while(changeFlag != true){
            int num = scan.nextInt();
            for(int i = 0;i<numbers.size();i++){
            if(numbers.get(index) == num){
                changeFlag = true;
                this.strength = num;
                numbers.remove(index);
                break;
            }
            index++;
        }
        if(changeFlag == false){
            index = 0;
            System.out.println("Error: Number not available. Try again.");
        }
        }
        
        index = 0;
        changeFlag = false;
        System.out.println("What is your Dexterity score?");
        while(changeFlag != true){
            int num = scan.nextInt();
            for(int i = 0;i<numbers.size();i++){
            if(numbers.get(index) == num){
                changeFlag = true;
                this.dexterity = num;
                numbers.remove(index);
                break;
            }
            index++;
        }
        if(changeFlag == false){
            index = 0;
            System.out.println("Error: Number not available. Try again.");
        }
        }

        index = 0;
        changeFlag = false;
        System.out.println("What is your Constitution score?");
        while(changeFlag != true){
            int num = scan.nextInt();
            for(int i = 0;i<numbers.size();i++){
            if(numbers.get(index) == num){
                changeFlag = true;
                this.constitution = num;
                numbers.remove(index);
                break;
            }
            index++;
        }
        if(changeFlag == false){
            index = 0;
            System.out.println("Error: Number not available. Try again.");
        }
        }
        
        index = 0;
        changeFlag = false;
        System.out.println("What is your Intelligence score?");
        while(changeFlag != true){
            int num = scan.nextInt();
            for(int i = 0;i<numbers.size();i++){
            if(numbers.get(index) == num){
                changeFlag = true;
                this.intelligence = num;
                numbers.remove(index);
                break;
            }
            index++;
        }
        if(changeFlag == false){
            index = 0;
            System.out.println("Error: Number not available. Try again.");
        }
        }

        index = 0;
        changeFlag = false;
        System.out.println("What is your Wisdom score?");
        while(changeFlag != true){
            int num = scan.nextInt();
            for(int i = 0;i<numbers.size();i++){
            if(numbers.get(index) == num){
                changeFlag = true;
                this.wisdom = num;
                numbers.remove(index);
                break;
            }
            index++;
        }
        if(changeFlag == false){
            index = 0;
            System.out.println("Error: Number not available. Try again.");
        }
        }

        index = 0;
        changeFlag = false;
        System.out.println("What is your Charisma score?");
        while(changeFlag != true){
            int num = scan.nextInt();
            for(int i = 0;i<numbers.size();i++){
            if(numbers.get(index) == num){
                changeFlag = true;
                this.charisma = num;
                numbers.remove(index);
                break;
            }
            index++;
        }
        if(changeFlag == false){
            index = 0;
            System.out.println("Error: Number not available. Try again.");
        }
        }
        scan.close();
    }

    void generateStatMods(){
        if(strength <= 10){
            double temp = (this.strength - 10);
            temp = Math.abs(temp);
            temp = Math.round(temp/2);
            this.strengthMod = (int)(temp-2*temp);
        }
        else{
            this.strengthMod = (this.strength - 10)/2;
        }
        if(dexterity <= 10){
            double temp = (this.dexterity - 10);
            temp = Math.abs(temp);
            temp = Math.round(temp/2);
            this.dexterityMod = (int)(temp-2*temp);
        }
        else{
            this.dexterityMod = (this.dexterity - 10)/2;
        }
        if(constitution <= 10){
            double temp = (this.constitution - 10);
            temp = Math.abs(temp);
            temp = Math.round(temp/2);
            this.constitutionMod = (int)(temp-2*temp);
        }
        else{
            this.constitutionMod = (this.constitution - 10)/2;
        }
        if(intelligence <= 10){
            double temp = (this.intelligence - 10);
            temp = Math.abs(temp);
            temp = Math.round(temp/2);
            this.intelligenceMod = (int)(temp-2*temp);
        }
        else{
            this.intelligenceMod = (this.intelligence - 10)/2;
        }
        if(wisdom <= 10){
            double temp = (this.wisdom - 10);
            temp = Math.abs(temp);
            temp = Math.round(temp/2);
            this.wisdomMod = (int)(temp-2*temp);
        }
        else{
            this.wisdomMod = (this.wisdom - 10)/2;
        }
        if(charisma <= 10){
            double temp = (this.charisma - 10);
            temp = Math.abs(temp);
            temp = Math.round(temp/2);
            this.charismaMod = (int)(temp-2*temp);
        }
        else{
            this.charismaMod = (this.charisma - 10)/2;
        }
    }

    public static void main(String[] args) throws Exception {
        //Area to test code
    }
}

class Barbarian extends Character{
    //Constructor   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v

    Barbarian(){
        strengthSV = true;
        constitutionSV = true;
        hp = 12;
    }

    

    //Class Abilities   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v   v

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
    }
