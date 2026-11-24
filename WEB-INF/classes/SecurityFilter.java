import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SecurityFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SecurityFilter : init()");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        System.out.println("SecurityFilter : BEFORE " + req.getRequestURI());

        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            System.out.println("SecurityFilter : access granted");
            chain.doFilter(request, response);
            System.out.println("SecurityFilter : AFTER chain.doFilter()");
        } else {
            System.out.println("SecurityFilter : access denied -> redirect to login.html");
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
    }

    public void destroy() {
        System.out.println("SecurityFilter : destroy()");
    }
}