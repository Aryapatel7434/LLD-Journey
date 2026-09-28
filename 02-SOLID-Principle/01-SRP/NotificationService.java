public class NotificationService {
    public void sendSuccessNotification(Transaction transaction){
        System.out.println("Notification sent for transaction:"+transaction.getTransactionId());
    }
}
