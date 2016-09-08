import Classes.Kamer;
import Classes.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

/**
 * Created by rickv on 31-8-2016.
 */
@WebServlet("/ShowRoomServlet")
public class ShowRoomsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Kamer> kamer_list = ((ArrayList<Kamer>) getServletContext().getAttribute("kamers"));

        int vierkanteMeter = Integer.parseInt(request.getParameter("vierkantemeter"));
        Double maximaleHuurprijs = Double.parseDouble(request.getParameter("maximalehuurprijs"));
        String plaats = request.getParameter("plaats");

        //response.getWriter().println(vierkanteMeter + " test");
        //response.getWriter().println(maximaleHuurprijs + " test2");


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
