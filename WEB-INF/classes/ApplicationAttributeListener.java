import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ApplicationAttributeListener implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("AppAttributeListener : AJOUTÉ -> " + scae.getName());
    }
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("AppAttributeListener : REMPLACÉ -> " + scae.getName());
    }
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("AppAttributeListener : SUPPRIMÉ -> " + scae.getName());
    }
}