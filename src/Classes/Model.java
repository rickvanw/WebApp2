package Classes;

import java.util.ArrayList;

/**
 * Created by rickv on 1-9-2016.
 */
public class Model {

    private static Model instance;

    private ArrayList<Kamer> kamers;
    private ArrayList<Gebruiker> gebruikers;


    private Model() {
        kamers = new ArrayList<>();
        gebruikers = new ArrayList<>();
    }


    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
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
