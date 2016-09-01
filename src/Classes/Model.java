package Classes;

import java.util.ArrayList;

/**
 * Created by rickv on 1-9-2016.
 */
public class Model {

    private static Model instance;

    private  ArrayList<Kamer> kamers;
    private  ArrayList<Gebruiker> gebruikers;


    private Model() {
        kamers = new ArrayList<>();
        gebruikers = new ArrayList<>();

        //dummy kamer
        Kamer kamer = new Kamer(10,10,"hengelo");
        kamers.add(kamer);

        //dummy gebruiker
        Gebruiker gebruiker = new Gebruiker("harry", "test");
        gebruikers.add(gebruiker);
    }


    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }

        return instance;
    }

    public ArrayList getGebruikers() {
        return gebruikers;
    }

    public ArrayList getkamers() {
        return kamers;
    }


    public void addUser(Gebruiker gebruiker) {
        gebruikers.add(gebruiker);
    }

    public void addKamer(Kamer kamer) {
        kamers.add(kamer);
    }

}
