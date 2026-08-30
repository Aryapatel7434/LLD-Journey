import java.math.BigDecimal;

public class PaymentDemo {

    public static void main(String[] args) throws IllegalAccessException {

        User user = new User("U101", "Arya");

        // =========================
        // 1. UPI PAYMENT
        // =========================

        Payment upiPayment =
                new Payment("P101", user, new BigDecimal("5000"));

        PaymentMethod upi = new UpiPayment();

        upi.pay(upiPayment);

        System.out.println("UPI Status: " +
                upiPayment.getStatus());


        // =========================
        // 2. CARD PAYMENT
        // =========================

        Payment cardPayment =
                new Payment("P102", user, new BigDecimal("7000"));

        PaymentMethod card = new CardPayment();

        card.pay(cardPayment);

        System.out.println("Card Status: " +
                cardPayment.getStatus());


        // =========================
        // 3. WALLET PAYMENT
        // =========================

        Payment walletPayment =
                new Payment("P103", user, new BigDecimal("3000"));

        PaymentMethod wallet =
                new WalletPayment(new BigDecimal("10000"));

        wallet.pay(walletPayment);

        System.out.println("Wallet Status: " +
                walletPayment.getStatus());

        System.out.println(
                "Remaining Wallet Balance: " +
                ((WalletPayment) wallet).getWalletBalance()
        );


        // =========================
        // 4. REFUND
        // =========================

        card.refund(cardPayment);

        System.out.println(
                "Card Status After Refund: " +
                cardPayment.getStatus()
        );


        // =========================
        // 5. PAYMENT LIMIT TEST
        // =========================

        try {

            Payment largePayment =
                    new Payment(
                            "P104",
                            user,
                            new BigDecimal("200000")
                    );

            upi.pay(largePayment);

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Payment Rejected: " +
                    e.getMessage()
            );
        }
    }
}