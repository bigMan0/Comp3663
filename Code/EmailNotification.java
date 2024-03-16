
// Concrete decorator class adding email functionality
class EmailNotification extends NotificationDecorator {
    Class<? extends Product> productClass;
    private int time;
    
    public EmailNotification(Notification decoratedNotification, Class<? extends Product> productClass, int time) {
        super(decoratedNotification);
        this.productClass = productClass;
        this.time = time;
    }

    @Override
    public void sendNotification() {
        super.sendNotification();
        sendEmailNotification();
    }

    private void sendEmailNotification() {
        System.out.println("Sending notification via email...");
        System.out.println("Message - (You just rented " + productClass.getSimpleName() + " for " + time + " days. )");
    }
}