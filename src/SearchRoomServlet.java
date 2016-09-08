import Classes.Kamer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rickv on 31-8-2016.
 */
@WebServlet("/SearchRoomServlet")
public class SearchRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Kamer> kamer_list = ((ArrayList<Kamer>) getServletContext().getAttribute("kamers"));

        int vierkanteMeter = Integer.parseInt(request.getParameter("vierkantemeter"));
        Double maximaleHuurprijs = Double.parseDouble(request.getParameter("maximalehuurprijs"));
        String plaats = request.getParameter("plaats");


        if (vierkanteMeter == 0 || maximaleHuurprijs == 0 || plaats.isEmpty()){
            response.sendRedirect("fouteinlog.html");
        }

        // Prints all the rooms (toString)
        for (int i = 0; i < kamer_list.size(); i++) {
            if(kamer_list.get(i).getVierkantemeters() == vierkanteMeter) {
            }   if(kamer_list.get(i).getHuurprijs() <= maximaleHuurprijs) {
                if(kamer_list.get(i).getPlaats().equalsIgnoreCase(plaats)) {
                    response.getWriter().println(kamer_list.get(i).toString());
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
