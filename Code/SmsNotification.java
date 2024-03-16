
// Concrete decorator class adding sms functionality
class SmsNotification implements Notification {
    Class<? extends Product> productClass;
    private int time;
    
    
    public SmsNotification(Class<? extends Product> productClass, int time) {
        this.productClass = productClass;
        this.time = time;
    }

    @Override
    public void sendNotification() {
        sendSmsNotification();
    }

    private void sendSmsNotification() {
        // Implementation for sending SMS notification
        System.out.println("Sending SMS notification...");
        System.out.println("Message - (You just rented " + productClass.getSimpleName() + " for " + time + " days.)");
    }
}
