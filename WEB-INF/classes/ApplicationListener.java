import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {
    
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ApplicationListener : Application démarrée.");
        sce.getServletContext().setAttribute("appName", "ING1 Web Application");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ApplicationListener : Application arrêtée.");
    }
}