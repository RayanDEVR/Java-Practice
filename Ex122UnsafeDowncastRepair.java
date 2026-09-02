/*
Unsafe Downcast Repair   [Bug Fixing | Advanced]
A NotificationSender reference may hold EmailSender or SmsSender, but code always casts to EmailSender. 
Make the behavior polymorphic; if subtype-only behavior remains, protect the cast using the type-check 
mechanism taught.
Done when: No ClassCastException occurs for either subtype and common behavior avoids downcasting.
*/

abstract class NotificationSender {
    abstract void send(String massage);
}

class EmailSender extends NotificationSender {
    @Override
    void send(String massage) {
        System.out.println("Email sent: " + massage);
    }

    void attachSignature() {
        System.out.println("Login email address...");
    }
}

class SmsSender extends NotificationSender {
    @Override
    void send(String massage) {
        System.out.println(massage);
    }
}

public class Ex122UnsafeDowncastRepair {
    public static void main(String[] args) {
        NotificationSender[] senders = { new EmailSender(), new SmsSender() };
        System.out.println("--- Fixed: common behavior stays polymorphic, no downcast...");
        for (NotificationSender s : senders) {
            s.send("System maintence tonight.");
        }
        System.out.println();

        System.out.println("--- Subtype-only behavior: cast protected with instanceof check---");
        for (NotificationSender s : senders) {
            if (s instanceof EmailSender) {
                EmailSender email = (EmailSender) s; //safe, chech first
                email.attachSignature();
            }
            else {
                System.out.println("(Skipping email-only behavior for " + s.getClass().getSimpleName() + ")");
            }
        }
    }
}
