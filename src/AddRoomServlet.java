import Classes.Gebruiker;
import Classes.Kamer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rubenassink on 01-09-16.
 */
@WebServlet("/AddRoomServlet")
public class AddRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Haalt lijst met kamers op uit model
        ArrayList<Kamer> kamer_list = ((ArrayList<Kamer>) getServletContext().getAttribute("kamers"));
        ArrayList<Gebruiker> gebruikers_lijst = ((ArrayList<Gebruiker>) getServletContext().getAttribute("users"));


        // Checkt of de gebruiker is ingelogd
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("gebruikersnaam") == null) {
            response.sendRedirect("unauthorized.html");
            return;
        }
        String username = (String) session.getAttribute("gebruikersnaam");


        // Controlleert of alle velden zijn ingevuld
        if (request.getParameter("vierkantemeters") == null || request.getParameter("vierkantemeters").isEmpty() || request.getParameter("huurprijs") == null || request.getParameter("huurprijs").isEmpty()
                || request.getParameter("plaats") == null || request.getParameter("plaats").isEmpty()){

            response.getWriter().println("Voer bij elk veld een waarde in");

        }else {
        int vierkanteMeter = Integer.parseInt(request.getParameter("vierkantemeters"));
        double huurprijs = Double.parseDouble(request.getParameter("huurprijs"));
        String plaats = request.getParameter("plaats");

            // Maakt een nieuwe kamer aan met de ingevoerde gegevens
            Kamer kamer = new Kamer(vierkanteMeter, huurprijs, plaats);

            // Voegt de kamer toe aan het model
            kamer_list.add(kamer);

            // Voegt de kamer toe aan de huidig ingelogde gebruiker
            for(Gebruiker gebruiker: gebruikers_lijst) {
                if(gebruiker.getGebruikersnaam().equalsIgnoreCase(username)) {
                    System.out.println(gebruiker.getGebruikersnaam());
                    gebruiker.addRoomToUser(kamer);
                }
            }

            response.sendRedirect("homeverhuurder");


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
