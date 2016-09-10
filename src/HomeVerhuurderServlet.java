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


@WebServlet("/homeverhuurder")
public class HomeVerhuurderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Kamer> kamer_lijst = ((ArrayList<Kamer>) getServletContext().getAttribute("kamers"));


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Kamers</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H3>Verhuurder</H3>");
        out.println("<br>");
        out.println("<br>");

        for(Kamer kamer: kamer_lijst) {
            out.print(kamer.toString());
            out.print("<br>");
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
