import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowSession extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        Integer visits = (Integer) session.getAttribute("visitCount");

        out.println("<html><head><meta charset='UTF-8'></head><body>");

        if (visits == null) {
            out.println("<h2>Welcome on my site</h2>");
            visits = 1;
        } else {
            out.println("<h2>Welcome back</h2>");
            visits = visits + 1;
        }
        session.setAttribute("visitCount", visits);

        out.println("<p>Number of visits: " + visits + "</p>");
        Integer activeSessions = (Integer) getServletContext().getAttribute("activeSessions");
        if (activeSessions == null) activeSessions = 0;
        out.println("<p>Nombre d'utilisateurs connectés (sessions actives) : " + activeSessions + "</p>");
        out.println("</body></html>");
    }
}