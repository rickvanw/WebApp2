import Classes.Gebruiker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rickv on 30-8-2016.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Invoer ophalen
        String gebruikersnaam = request.getParameter("gebruikersnaam");
        String wachtwoord = request.getParameter("wachtwoord");

        String rol="";

        ArrayList<Gebruiker> gebruiker_lijst = ((ArrayList<Gebruiker>) getServletContext().getAttribute("users"));


        boolean user_authenticated = false;

        // Verifieerd de gebuikersgegevens
        for(Gebruiker gebruiker : gebruiker_lijst) {
            if(gebruiker.getGebruikersnaam().equalsIgnoreCase(gebruikersnaam) && gebruiker.getPassword().equalsIgnoreCase(wachtwoord)) {
                user_authenticated = true;
                rol = gebruiker.getRol();
                break;
            }
        }

        HttpSession session = request.getSession();
        if(user_authenticated) {
            session.setAttribute("gebruikersnaam", gebruikersnaam);
            if(rol.equals("huurder"))
                response.sendRedirect("homehuurder");
            else{
                response.sendRedirect("homeverhuurder");
            }
        } else {
            response.sendRedirect("fouteinlog.html");
            session.removeAttribute("username");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
