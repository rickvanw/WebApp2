package Classes; /**
 * Created by rubenassink on 07-09-16.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public Listener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        ArrayList<Gebruiker> user_list = new ArrayList<>();
        user_list.add(new Gebruiker("wouter", "secret", "huurder"));
        user_list.add(new Gebruiker("Henk", "secret", "verhuurder"));
        user_list.add(new Gebruiker("Jan", "secret", "huurder"));

        ArrayList<Kamer> kamer_list = new ArrayList<>();
        kamer_list.add(new Kamer(10,10,"hengelo"));
        kamer_list.add(new Kamer(19,2,"enschede"));
        kamer_list.add(new Kamer(130,13,"glanerbrug"));

        int visitCount=0;

        sce.getServletContext().setAttribute("users", user_list);
        sce.getServletContext().setAttribute("kamers", kamer_list);
        sce.getServletContext().setAttribute("visitCount", visitCount);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
