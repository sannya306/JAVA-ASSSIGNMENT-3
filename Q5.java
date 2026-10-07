import java.util.Scanner;
class UniversityLogin {
    void login(String username) {
        if (username == null) {
            throw new NullPointerException(
                "Username cannot be null"
            );
        }
        System.out.println("Login successful");
    }
}
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String input = sc.nextLine();
        String username;
        if (input.equalsIgnoreCase("null")) {
            username = null;
        } else {
            username = input;
        }
        try {
            UniversityLogin obj = new UniversityLogin();
            obj.login(username);
        }
        catch (NullPointerException e) {
            System.out.println(
                "Exception: " + e.getMessage()
            );
        }
        sc.close();
    }
}
