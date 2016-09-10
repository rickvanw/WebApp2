package Classes;

/**
 * Created by rickv on 1-9-2016.
 */
public class Gebruiker {

    private String gebruikersnaam;
    private String password;
    private String rol;

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

    @Override
    public String toString() {
        return "Gebruiker{" +
                "gebruikersnaam='" + gebruikersnaam + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
