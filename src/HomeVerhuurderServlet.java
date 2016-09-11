import Classes.Gebruiker;
import Classes.Kamer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/homeverhuurder")
public class HomeVerhuurderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Haalt de lijst met kamers op
        ArrayList<Kamer> kamer_lijst = ((ArrayList<Kamer>) getServletContext().getAttribute("kamers"));
        ArrayList<Gebruiker> gebruikers_lijst = ((ArrayList<Gebruiker>) getServletContext().getAttribute("users"));


        //Genereerd een html pagina met alle kamers van de verhuurder
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Kamers</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H3>Verhuurder</H3>");
        out.println("Uw kamers:");
        out.println("<br>");

        // Print de kamers van de ingelogde verhuurder
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("gebruikersnaam");
        for(Gebruiker gebruiker: gebruikers_lijst) {
                if(gebruiker.getGebruikersnaam().equalsIgnoreCase(username)) {
                    ArrayList<Kamer> kamers = gebruiker.getKamers();

                    for (Kamer kamer : kamers) {
                        System.out.println(kamer.toString());
                        out.print(kamer.toString());
                        out.print("<br>");
                    }
                }
        }

        out.println("<br>");
        out.println("<a href=\"addroom.html\">Kamer toevoegen</a>");
        out.println("<br>");
        out.println("<a href=\"ShowPersonsServlet\">Toon alle gebruikers</a>");
        out.println("<br>");
        out.println("<a href=\"logout\">Log out</a>");
        out.println("</BODY></HTML>");

    }
}
