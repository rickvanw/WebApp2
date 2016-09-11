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

        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("username") == null) {
            response.sendRedirect("unauthorized.html");
            return;
        }

        ArrayList<Kamer> kamer_list = ((ArrayList<Kamer>) getServletContext().getAttribute("kamers"));

        if (request.getParameter("vierkantemeters") == null || request.getParameter("vierkantemeters").isEmpty() || request.getParameter("huurprijs") == null || request.getParameter("huurprijs").isEmpty()
                || request.getParameter("plaats") == null || request.getParameter("plaats").isEmpty()){

            response.getWriter().println("Voer bij elk veld een waarde in");

        }else {
        int vierkanteMeter = Integer.parseInt(request.getParameter("vierkantemeters"));
        double huurprijs = Double.parseDouble(request.getParameter("huurprijs"));
        String plaats = request.getParameter("plaats");

            // Create room with the recieved parameters
            Kamer kamer = new Kamer(vierkanteMeter, huurprijs, plaats);

            // Add room to Context
            kamer_list.add(kamer);

            response.sendRedirect("homeverhuurder");


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
