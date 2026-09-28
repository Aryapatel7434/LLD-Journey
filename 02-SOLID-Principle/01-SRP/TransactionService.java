public class TransactionService {
    private final TransactionValidator validator;
    private final PaymentProcessor paymentProcessor;
    private final TransactionRepository transactionRepository;
    private final NotificationService notificationService;
    private final AuditService auditService;

    public TransactionService(TransactionValidator transactionValidator, PaymentProcessor paymentProcessor, TransactionRepository transactionRepository, NotificationService notificationService, AuditService auditService) {
        this.validator = transactionValidator;
        this.paymentProcessor = paymentProcessor;
        this.transactionRepository = transactionRepository;
        this.notificationService = notificationService;
        this.auditService = auditService;
    }
    public void processTransaction(Transaction transaction){
        validator.validate(transaction);
        paymentProcessor.pocess(transaction);
        transactionRepository.save(transaction);
        notificationService.sendSuccessNotification(transaction);
        auditService.record(transaction);

    }


}
