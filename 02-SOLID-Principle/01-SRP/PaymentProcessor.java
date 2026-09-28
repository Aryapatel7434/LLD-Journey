public class PaymentProcessor {
    public void pocess(Transaction transaction){
        System.out.println("Processing payment for transaction:"+transaction.getTransactionId());
        transaction.markSuccess();
    }
}
