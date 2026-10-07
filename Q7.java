import java.util.Scanner;
class TicketBooking {
    private int availableSeats;
    TicketBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    synchronized void bookSeat(String user, int seats) {
        if (seats <= availableSeats) {
            availableSeats = availableSeats - seats;
            System.out.println(
                user + " booked " + seats +
                " seat(s) successfully"
            );
        } else {
            System.out.println(
                user + " booking failed. Not enough seats"
            );
        }
    }
}
class User1 extends Thread {
    TicketBooking booking;
    User1(TicketBooking booking) {
        this.booking = booking;
    }
    public void run() {
        booking.bookSeat("User1", 1);
    }
}
class User2 extends Thread {
    TicketBooking booking;
    User2(TicketBooking booking) {
        this.booking = booking;
    }
    public void run() {
        booking.bookSeat("User2", 2);
    }
}
public class Q7 {
    public static void main(String[] args)
            throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Available Seats: ");
        int seats = sc.nextInt();
        TicketBooking booking =
            new TicketBooking(seats);
        User1 user1 = new User1(booking);
        User2 user2 = new User2(booking);
        user1.start();
        user1.join();
        user2.start();
        user2.join();
        sc.close();
    }
}
