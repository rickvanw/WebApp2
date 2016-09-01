import Classes.Gebruiker;
import Classes.Model;

import javax.jws.WebParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rickv on 1-9-2016.
 */
@WebServlet("/RegistreerServlet")
public class RegistreerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gebruikersnaam = request.getParameter("gebruikersnaam");
        String wachtwoord = request.getParameter("wachtwoord");
        boolean legeInput = false;

        // Check of gebruikersnaam / wachtwoord velden leeg zijn
        if (gebruikersnaam.isEmpty() || wachtwoord.isEmpty()){
            legeInput = true;
        }

        // TODO Checken of gebruiker al bestaat

        ArrayList<Gebruiker> gebruikers = Model.getInstance().getGebruikers();
        boolean exists = false;

        for (int i = 0; i < gebruikers.size(); i++) {

            if(gebruikers.get(i).getGebruikersnaam().equals(gebruikersnaam)){
                exists = true;
            }
        }
        if(exists) {
            response.sendRedirect("registratiefout.html");
        }else if (legeInput){
            response.sendRedirect("fouteinlog.html");
        }else{

            response.sendRedirect("login.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
