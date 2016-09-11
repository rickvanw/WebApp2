package Classes;

import java.util.ArrayList;

/**
 * Created by rickv on 1-9-2016.
 */
public class Gebruiker {

    private String gebruikersnaam;
    private String password;
    private String rol;
    private ArrayList<Kamer> kamers = new ArrayList<>();

    public Gebruiker(String gebruikersnaam, String password, String rol) {
        this.gebruikersnaam = gebruikersnaam;
        this.password = password;
        this.rol = rol;

    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public void addRoomToUser(Kamer kamer) {
        kamers.add(kamer);
    }

    public ArrayList<Kamer> getKamers() {
        return kamers;
    }

    @Override
    public String toString() {
        return "Gebruiker{" +
                "gebruikersnaam='" + gebruikersnaam + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
