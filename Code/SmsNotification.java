
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

        //hours
        if (time < 24){
            System.out.println("Message - (You just rented " + productClass.getSimpleName() + " for " + time + " hours.)");
        }

        //days
        else if(time >= 24 && time < 168) {
            int days;
            days = time / 24;
            System.out.println("Message - (You just rented " + productClass.getSimpleName() + " for " + days + " days.)");
        }

        //week
        else{
            int days;
            days = time / 24; 
            System.out.println("Message - (You just rented " + productClass.getSimpleName() + " for " + days + " days.)");
        }
    }
}
