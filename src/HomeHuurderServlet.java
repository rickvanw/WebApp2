import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by rubenassink on 09-09-16.
 */
@WebServlet("/homehuurder")
public class HomeHuurderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Doorverwijzing naar startpagina voor huurders (WEB-INF)
        getServletContext().getRequestDispatcher("/WEB-INF/homeHuurder.html").forward(request, response);
    }
}
