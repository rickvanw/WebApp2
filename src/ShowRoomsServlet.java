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

        ArrayList<Kamer> rooms = Model.getInstance().getkamers();

        int vierkandeMeter = request.getIntHeader("vierkante meter");
        double maximaleHuurprijs = request.getIntHeader("maximale huurprijs");
        String plaats = request.getParameter("plaats");

        
        // Prints all the rooms (toString)
        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).getVierkantemeters() >= vierkandeMeter) {
            }   if(rooms.get(i).getHuurprijs() <= maximaleHuurprijs) {
                    if(rooms.get(i).getPlaats().equalsIgnoreCase(plaats)) {
                        response.getWriter().println(rooms.get(i));
                    }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
