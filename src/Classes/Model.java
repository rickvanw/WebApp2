package Classes;

import java.util.ArrayList;

/**
 * Created by rickv on 1-9-2016.
 */
public class Model {

    private static Model instance;

    private static ArrayList<Kamer> kamers;
    private static ArrayList<Gebruiker> gebruikers;


    private Model() {
        kamers = new ArrayList<>();
        gebruikers = new ArrayList<>();
    }


    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        //dummy kamer
        Kamer kamer = new Kamer(10,10,"hengelo");
        kamers.add(kamer);

        //dummy gebruiker
        Gebruiker gebruiker = new Gebruiker("harry", "test");
        gebruikers.add(gebruiker);


        return instance;
    }

    public ArrayList getUsers() {
        return gebruikers;
    }

    public ArrayList getRooms() {
        return kamers;
    }


    public void addUser(Gebruiker gebruiker) {
        gebruikers.add(gebruiker);
    }

}
