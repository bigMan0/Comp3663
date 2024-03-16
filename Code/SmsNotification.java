
// SmsNotificationDecorator.java
class SmsNotification extends NotificationDecorator {
    Class<? extends Product> productClass;
    private int time;
    
    
    public SmsNotification(Notification decoratedNotification, Class<? extends Product> productClass, int time) {
        super(decoratedNotification);
        this.productClass = productClass;
        this.time = time;
    }

    @Override
    public void sendNotification() {
        super.sendNotification();
        sendSmsNotification();
    }

    private void sendSmsNotification() {
        // Implementation for sending SMS notification
        System.out.println("Sending SMS notification...");
        System.out.println("Message - (You just rented " + productClass.getSimpleName() + " for " + time + " days.)");
    }
}
