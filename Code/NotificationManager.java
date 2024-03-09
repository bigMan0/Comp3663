// NotificationManager.java

// Singleton for notification management
class NotificationManager {
    private static NotificationManager instance;

    private NotificationManager() {
        // Constructor logic if needed
    }

    public static synchronized NotificationManager getInstance() {
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }

    public void sendNotification(NotificationDecorator notificationDecorator) {
        notificationDecorator.sendNotification();
    }
}

