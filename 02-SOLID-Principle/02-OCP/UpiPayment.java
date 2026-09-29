public class UpiPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {

        System.out.println(
                "Processing UPI payment: ₹" + amount
        );
    }
}