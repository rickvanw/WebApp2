import Classes.Kamer;
import Classes.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rubenassink on 01-09-16.
 */
@WebServlet("/AddRoomServlet")
public class AddRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int vierkanteMeter = request.getIntHeader("vierkantemeters");
        double huurprijs = request.getIntHeader("huurprijs");
        String plaats = request.getParameter("plaats");

        Model model = Model.getInstance();
        Kamer kamer = new Kamer(vierkanteMeter, huurprijs, plaats);

        model.addKamer(kamer);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}