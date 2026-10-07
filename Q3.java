import java.util.Scanner;
class ArrayDivision {
    void divide(int[] array, int index, int divisor) {
        try {
            int result = array[index] / divisor;
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println(
                "Exception: Division by zero not allowed"
            );
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                "Exception: Array index out of bounds"
            );
        }
    }
}
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {10, 20, 30, 40};
        System.out.print("Enter index: ");
        int index = sc.nextInt();
        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();
        ArrayDivision obj = new ArrayDivision();
        obj.divide(array, index, divisor);
        sc.close();
    }
}
