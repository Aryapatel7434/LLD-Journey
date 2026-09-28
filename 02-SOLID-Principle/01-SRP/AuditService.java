public class AuditService {
    public void record(Transaction transaction){
        System.out.println("Audit recorded for transaction:"+transaction.getTransactionId());
    }
}
