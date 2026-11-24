import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        HttpSession session = request.getSession();
        session.setAttribute("user", username);

        out.println("<html><head><meta charset='UTF-8'></head><body>");
        out.println("<h2>Welcome " + username + "</h2>");
        out.println("<p>You are now logged in.</p>");
        out.println("<a href='items.html'>Go to items.html</a>");
        out.println("</body></html>");
    }
}