
// SmsNotificationDecorator.java
public class SmsNotificationDecorator extends NotificationDecorator {
    public SmsNotificationDecorator(Notification decoratedNotification) {
        super(decoratedNotification);
    }

    @Override
    public void sendNotification() {
        super.sendNotification();
        sendSmsNotification();
    }

    private void sendSmsNotification() {
        // Implementation for sending SMS notification
        System.out.println("Sending SMS notification...");
    }
}
