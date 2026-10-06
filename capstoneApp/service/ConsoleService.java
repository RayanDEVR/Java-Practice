package capstoneApp.service;

public class ConsoleService implements NotificationService {
    @Override 
    public void send(String message) {
        System.out.println("[Notification] " + message);
    }
}
