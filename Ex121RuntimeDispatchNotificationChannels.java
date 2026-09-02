/*
Runtime Dispatch: Notification Channels   [Build from Scratch | Advanced]
Create abstract/base NotificationSender with send, then EmailSender and SmsSender overrides. Store each in a 
parent reference and call send.
Done when: The method selected depends on the real object, not the reference type.
*/


abstract class NotificationSender {
    abstract void send(String massage);
}

class EmailSender extends NotificationSender {
    public void send(String massage) {
        System.out.println("Email: " + massage);
    }
}

class SmsSender extends NotificationSender {
    public void send(String massage) {
        System.out.println("SMS: " + massage);
    }
}


public class Ex121RuntimeDispatchNotificationChannels {
    public static void main(String[] args) {
        NotificationSender channels;
        channels = new EmailSender();
        channels.send("Order Confirmed.");

        channels = new SmsSender();
        channels.send("Order Confirmed.");
        
    }
}
