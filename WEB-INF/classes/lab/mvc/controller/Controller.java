package lab.mvc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab.mvc.model.Person;

public class Controller extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        Person person = new Person(firstName, lastName, birthDay, sex);

        request.setAttribute("person", person);
        int anneeNaissance = 2000; 
        try {
            if (birthDay != null && birthDay.contains("/")) {
                String[] parts = birthDay.split("/");
                String anneeStr = parts[parts.length - 1]; 
                anneeNaissance = Integer.parseInt(anneeStr);
                if (anneeNaissance < 100) { 
                    anneeNaissance += (anneeNaissance < 50) ? 2000 : 1900;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Format de date invalide, on considère la personne comme jeune.");
        }

        String jspPage;
        if (anneeNaissance < 1990) {
            jspPage = "/old.jsp"; 
        } else {
            jspPage = "/young.jsp"; 
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jspPage);
        dispatcher.include(request, response);
    }
}