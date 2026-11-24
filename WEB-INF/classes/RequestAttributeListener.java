import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("ReqAttributeListener : AJOUTÉ -> " + srae.getName());
    }
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("ReqAttributeListener : REMPLACÉ -> " + srae.getName());
    }
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("ReqAttributeListener : SUPPRIMÉ -> " + srae.getName());
    }
}