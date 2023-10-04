import java.util.ArrayList;
import java.util.Scanner;

abstract class Background {         //TODO: 13 backgrounds
    ArrayList<String> proficiencies = new ArrayList<>();
    ArrayList<String> skills = new ArrayList<>();
    ArrayList<String> languages = new ArrayList<>();
    ArrayList<String> equipment = new ArrayList<>();

    Background(){
        //Default constructor to be overloaded
    }

    public static void main(String[] args) {
    //Area for testing code

    }
}

class Acolyte extends Background{
    Acolyte(){

    }
}
