import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("SessionAttributeListener : Attribut AJOUTÉ -> " + se.getName() + " = " + se.getValue());
    }
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("SessionAttributeListener : Attribut REMPLACÉ -> " + se.getName() + " = " + se.getValue());
    }
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("SessionAttributeListener : Attribut SUPPRIMÉ -> " + se.getName());
    }
}