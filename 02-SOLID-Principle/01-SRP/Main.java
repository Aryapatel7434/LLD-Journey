import java.math.BigDecimal;
public class Main {
   public static void main(String[]args){
      TransactionValidator validator=new TransactionValidator();
      PaymentProcessor processor=new PaymentProcessor();
      TransactionRepository repository=new TransactionRepository();
      NotificationService NotificationService=new NotificationService();
      AuditService auditService=new AuditService();

      TransactionService transactionService=new TransactionService(validator, processor, repository, NotificationService, auditService);

      Transaction transaction=new Transaction("T101","U101",new BigDecimal("5000"));

      transactionService.processTransaction(transaction);

      System.out.println("Final status:"+transaction.getStatus());


   }
}
