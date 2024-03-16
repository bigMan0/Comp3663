
// Concrete decorator class adding email functionality
class EmailNotification implements Notification {
    Class<? extends Product> productClass;
    private int time;
    
    public EmailNotification(Class<? extends Product> productClass, int time) {
        this.productClass = productClass;
        this.time = time;
    }

    @Override
    public void sendNotification() {
        sendEmailNotification();
    }

    private void sendEmailNotification() {
        System.out.println("Sending notification via email...");
        System.out.println("Message - (You just rented " + productClass.getSimpleName() + " for " + time + " days. )");
    }
}