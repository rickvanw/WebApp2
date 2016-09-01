package Classes;

/**
 * Created by rickv on 1-9-2016.
 */
public class Gebruiker {

    private String gebruikersnaam;
    private String password;

    public Gebruiker(String gebruikersnaam, String password) {
        this.gebruikersnaam = gebruikersnaam;
        this.password = password;

    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getPassword() {
        return password;
    }
}
