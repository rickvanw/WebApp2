import Classes.Gebruiker;
import Classes.Kamer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/ShowPersonsServlet")
public class ShowPersonsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Gebruiker> gebruiker_lijst = ((ArrayList<Gebruiker>) getServletContext().getAttribute("users"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Kamers</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H3>Verhuurder</H3>");
        out.println("<br>");

        for(Gebruiker gebruiker: gebruiker_lijst) {
            out.print(gebruiker.getGebruikersnaam() + "      " + gebruiker.getRol());
            out.print("<br>");
        }

        out.println("<br>");
        out.println("<a href=\"logout\">Log out</a>");
        out.println("</BODY></HTML>");
    }
}
