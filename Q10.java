class BankTransaction extends Thread {
    private String type;
    private double amount;
    BankTransaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    public void run() {
        System.out.println(
            type + " transaction processed: ₹" +
            amount
        );
    }
}
public class Q10 {
    public static void main(String[] args)
            throws InterruptedException {
        BankTransaction low =
            new BankTransaction(
                "Low-value", 5000
            );
        BankTransaction high =
            new BankTransaction(
                "High-value", 50000
            );
        low.setPriority(Thread.MIN_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);
        high.start();
        high.join();
        low.start();
        low.join();
        System.out.println(
            "High-value transaction processed first"
        );
        System.out.println(
            "Low-value transaction processed later"
        );
    }
}
