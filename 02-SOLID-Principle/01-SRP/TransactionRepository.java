public class TransactionRepository {
    public void save(Transaction transaction){
        System.out.println("Transaction saved:"+transaction.getTransactionId());
    }
}
