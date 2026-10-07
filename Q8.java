class PrinterJob implements Runnable {
    private int jobNumber;
    private String student;
    PrinterJob(int jobNumber, String student) {
        this.jobNumber = jobNumber;
        this.student = student;
    }
    public void run() {
        System.out.println(
            "Printing job " + jobNumber +
            " by " + student
        );
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
public class Q8 {
    public static void main(String[] args)
            throws InterruptedException {
        Thread t1 =
            new Thread(new PrinterJob(1, "Student A"));
        Thread t2 =
            new Thread(new PrinterJob(2, "Student B"));
        Thread t3 =
            new Thread(new PrinterJob(3, "Student C"));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
