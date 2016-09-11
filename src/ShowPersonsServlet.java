import Classes.Gebruiker;
import Classes.Kamer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@WebServlet("/ShowPersonsServlet")
public class ShowPersonsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Gebruiker> gebruiker_lijst = ((ArrayList<Gebruiker>) getServletContext().getAttribute("users"));
        int visitCount = (int) getServletContext().getAttribute("visitCount");
        visitCount++;

        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("gebruikersnaam") == null) {
            response.sendRedirect("unauthorized.html");
            return;
        }



        // huidige datum toevoegen aan cookie
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        Cookie[] cookies = request.getCookies();
        String history = null;

        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("history")) {
                history = cookie.getValue();
            }
        }

        Cookie cookie = new Cookie("history", "" + date);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);


//        // Print aantal keren dat de pagin bezocht is + laatse keer bezocht
//        response.getWriter().println("Times visited: " + visitCount);
//        if(history != null)
//            response.getWriter().println("Last time visited: " + history);
//



        // HTML pagina met alle gebruikers in het model
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("Times visited: " + visitCount);
        out.println("<br>");
        out.println("Last time visited: " + history);
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Gebruikers</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H3>Gebruikers</H3>");

        for(Gebruiker gebruiker: gebruiker_lijst) {
            out.print(gebruiker.getGebruikersnaam() + "      " + gebruiker.getRol());
            out.print("<br>");
        }

        out.println("<br>");
        out.println("<a href=\"logout\">Log out</a>");
        out.println("</BODY></HTML>");
    }
}
