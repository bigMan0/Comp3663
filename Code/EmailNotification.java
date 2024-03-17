
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