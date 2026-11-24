import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ActiveSessionListener implements HttpSessionListener {
    private static final AtomicInteger activeSessions = new AtomicInteger(0);

    public void sessionCreated(HttpSessionEvent se) {
        int current = activeSessions.incrementAndGet();
        ServletContext context = se.getSession().getServletContext();
        context.setAttribute("activeSessions", current);
        System.out.println("ActiveSessionListener : Session créée. Total : " + current);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        int current = activeSessions.decrementAndGet();
        ServletContext context = se.getSession().getServletContext();
        context.setAttribute("activeSessions", current);
        System.out.println("ActiveSessionListener : Session détruite. Total : " + current);
    }
}