import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {

    private String logPrefix = "[LOG]";

    public void init(FilterConfig filterConfig) throws ServletException {
        String p = filterConfig.getInitParameter("logPrefix");
        if (p != null) {
            logPrefix = p;
        }
        System.out.println(logPrefix + " LoggingFilter : init()");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();

        System.out.println(logPrefix + " BEFORE " + uri);

        chain.doFilter(request, response);

        System.out.println(logPrefix + " AFTER " + uri);
    }

    public void destroy() {
        System.out.println(logPrefix + " LoggingFilter : destroy()");
    }
}