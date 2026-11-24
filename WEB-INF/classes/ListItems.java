import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

public class ListItems extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        if (items == null) {
            items = new ArrayList<String>();
        }

        String newItem = request.getParameter("newItem");
        if (newItem != null && !newItem.isEmpty()) {
            items.add(newItem);
        }
        session.setAttribute("items", items);

        display(response, items);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();

        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        if (items == null) {
            items = new ArrayList<String>();
        }

        display(response, items);
    }

    private void display(HttpServletResponse response, ArrayList<String> items)
            throws IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><meta charset='UTF-8'></head><body>");
        out.println("<h2>List of items</h2>");
        out.println("<ul>");
        for (String item : items) {
            out.println("<li>" + item + "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
}