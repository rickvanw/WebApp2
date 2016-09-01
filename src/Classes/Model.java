package Classes;

import java.util.ArrayList;

/**
 * Created by rickv on 1-9-2016.
 */
public class Model {

    private ArrayList<Kamer> kamers = new ArrayList<>();
    private ArrayList<Gebruiker> Gebruikers = new ArrayList<>();

    public void addUser(Gebruiker gebruiker) {
        Gebruikers.add(gebruiker);
    }

}
