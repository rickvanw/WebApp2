package Classes;

/**
 * Created by rickv on 1-9-2016.
 */
public class Kamer {

    private int vierkantemeters;
    private double huurprijs;
    private String plaats;

    public Kamer(int vierkantemeters, double huurprijs, String plaats) {
        this.vierkantemeters = vierkantemeters;
        this.huurprijs = huurprijs;
        this.plaats = plaats;
    }

    public int getVierkantemeters() {
        return vierkantemeters;
    }

    public double getHuurprijs() {
        return huurprijs;
    }

    public String getPlaats() {
        return plaats;
    }

    @Override
    public String toString() {
        return "Kamer{" +
                "vierkantemeters=" + vierkantemeters +
                ", huurprijs=" + huurprijs +
                ", plaats='" + plaats + '\'' +
                '}';
    }
}
