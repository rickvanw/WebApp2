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

        // Prints all the rooms (toString)
        for (Gebruiker gebruiker: gebruiker_lijst) {
            response.getWriter().println(gebruiker.toString() + " rol: " + gebruiker.getRol());
        }


    }
}
