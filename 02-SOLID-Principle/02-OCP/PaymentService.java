public class PaymentService {
    public void processPayment(PaymentMethod paymentMethod,double amount){
        paymentMethod.pay(amount);
    }

    public static void main(String[] args) {
        PaymentService service=new PaymentService();

        PaymentMethod paymentMethod=new UpiPayment();

        service.processPayment(paymentMethod,5000);

        PaymentMethod paymentMethod1=new NetBankingPayment();

        service.processPayment(paymentMethod1,5000);
    }
}
