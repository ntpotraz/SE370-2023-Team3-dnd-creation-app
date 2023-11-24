import java.util.ArrayList;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class SpellList {
  private ArrayList<Spell> spellLibrary;

  public SpellList() {
    try {
      Object obj = parser.parse(new FileReader("../lib/1stspellsCantrips.json");
      JSONObject jsonObj = (JSONObject)obj;
    }
  }
}
