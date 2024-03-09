// NotificationDecorator.java

// Notification decorator interface
interface NotificationDecorator {
    void sendNotification();
}

// Concrete notification decorators
class EmailNotificationDecorator implements NotificationDecorator {
    private final NotificationDecorator notificationDecorator;

    public EmailNotificationDecorator(NotificationDecorator notificationDecorator) {
        this.notificationDecorator = notificationDecorator;
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending email notification...");
        if (notificationDecorator != null) {
            notificationDecorator.sendNotification();
        }
    }
}

class SMSNotificationDecorator implements NotificationDecorator {
    private final NotificationDecorator notificationDecorator;

    public SMSNotificationDecorator(NotificationDecorator notificationDecorator) {
        this.notificationDecorator = notificationDecorator;
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending SMS notification...");
        if (notificationDecorator != null) {
            notificationDecorator.sendNotification();
        }
    }
}
