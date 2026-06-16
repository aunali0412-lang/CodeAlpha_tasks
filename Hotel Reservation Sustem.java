import java.util.*;

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Integer, String> rooms = new HashMap<>();
        Map<Integer, String> bookings = new HashMap<>();

        rooms.put(101, "Standard");
        rooms.put(102, "Deluxe");
        rooms.put(103, "Suite");

        while (true) {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reservations");
            System.out.println("5. Exit");

            System.out.print("Choose Option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Rooms:");
                    for (Integer room : rooms.keySet()) {
                        if (!bookings.containsKey(room)) {
                            System.out.println(
                                room + " - " + rooms.get(room)
                            );
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();
                    sc.nextLine();

                    if (!bookings.containsKey(roomNo)) {

                        System.out.print("Enter Customer Name: ");
                        String customer = sc.nextLine();

                        bookings.put(roomNo, customer);

                        System.out.println("Booking Successful");
                    } else {
                        System.out.println("Room Already Booked");
                    }
                    break;

                case 3:
                    System.out.print("Enter Room Number: ");
                    int cancelRoom = sc.nextInt();

                    if (bookings.containsKey(cancelRoom)) {
                        bookings.remove(cancelRoom);
                        System.out.println("Reservation Cancelled");
                    } else {
                        System.out.println("Booking Not Found");
                    }
                    break;

                case 4:
                    System.out.println("\nReservations:");

                    if (bookings.isEmpty()) {
                        System.out.println("No Reservations");
                    } else {
                        for (Integer room : bookings.keySet()) {
                            System.out.println(
                                "Room " + room +
                                " -> " + bookings.get(room)
                            );
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank You");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}