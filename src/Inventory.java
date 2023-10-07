import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> currency;
    private ArrayList<Item> backpack;

    public Inventory() {
        this.backpack = new ArrayList<Item>();
        currency = new HashMap<>();
        currency.put("cp", 0);
        currency.put("sp", 0);
        currency.put("ep", 0);
        currency.put("gp", 0);
        currency.put("pp", 0);
    }

    public static void main(String[] args) {
        Misc testMisc = new Misc();
        Armor testArmor = new Armor();
        Weapon testWeapon = new Weapon();
        System.out.println(testMisc.toString());
        System.out.println(testArmor.toString());
        System.out.println(testWeapon.toString());
    }
}
