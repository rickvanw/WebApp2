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
import java.util.Arrays;

/**
 * Created by rickv on 1-9-2016.
 */
@WebServlet("/RegistreerServlet")
public class RegistreerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String gebruikersnaam = request.getParameter("gebruikersnaam");
        String wachtwoord = request.getParameter("wachtwoord");
        boolean legeInput = false;
        boolean exists = false;

        ArrayList<Gebruiker> user_list = ((ArrayList<Gebruiker>) getServletContext().getAttribute("users"));


        // Check of gebruikersnaam / wachtwoord velden leeg zijn
        if (gebruikersnaam.isEmpty() || wachtwoord.isEmpty()){
            legeInput = true;
        }else {


            for (int i = 0; i < user_list.size(); i++) {

                if (user_list.get(i).getGebruikersnaam().equals(gebruikersnaam)) {
                    exists = true;

                }
            }

            if(!exists){
                Gebruiker gebruiker = new Gebruiker(gebruikersnaam, wachtwoord);
                user_list.add(gebruiker);

                for(Gebruiker user: user_list) {
                    System.out.println(user.getGebruikersnaam());
                }

            }
        }

        // Verwijzingen naar juiste html pagina's
        if(legeInput) {
            response.sendRedirect("fouteinlog.html");
        }else if (exists){
            response.sendRedirect("registratiefout.html");
        }else{

            response.sendRedirect("login.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
