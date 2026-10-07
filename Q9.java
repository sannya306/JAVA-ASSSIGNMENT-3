import java.util.Random;
import java.util.Scanner;
class SquareCalculator extends Thread {
    private int number;
    SquareCalculator(int number) {
        this.number = number;
    }
    public void run() {
        System.out.println(
            "Square: " + (number * number)
        );
    }
}
class CubeCalculator extends Thread {
    private int number;
    CubeCalculator(int number) {
        this.number = number;
    }
    public void run() {
        System.out.println(
            "Cube: " + (number * number * number)
        );
    }
}
class RandomNumberGenerator extends Thread {
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int number =
                random.nextInt(10) + 1;
            System.out.println(
                "Generated: " + number
            );
            Thread calculation;
            if (number % 2 == 0) {
                calculation =
                    new SquareCalculator(number);
            } else {
                calculation =
                    new CubeCalculator(number);
            }
            calculation.start();

            try {
                calculation.join();
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
public class Q9 {
    public static void main(String[] args)
            throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Start Simulation");
        System.out.println("2. Exit");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        if (choice == 1) {
            RandomNumberGenerator generator =
                new RandomNumberGenerator();
            generator.start();
            generator.join();
        } else {
            System.out.println("Simulation exited");
        }
        sc.close();
    }
}
