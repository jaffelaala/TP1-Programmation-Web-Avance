import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("RequestListener : Requête initialisée.");
    }
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("RequestListener : Requête détruite.");
    }
}