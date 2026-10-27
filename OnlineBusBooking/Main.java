import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingService service = new BookingService();

        int choice;

        System.out.println("====================================");
        System.out.println("   ONLINE BUS TICKET BOOKING SYSTEM");
        System.out.println("====================================");

        do {
            System.out.println("\n1. View All Buses");
            System.out.println("2. Search Buses");
            System.out.println("3. Book Ticket");
            System.out.println("4. View Ticket");
            System.out.println("5. Cancel Ticket");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    service.displayBuses();
                    break;

                case 2:
                    System.out.print("Enter source: ");
                    String source = sc.nextLine();

                    System.out.print("Enter destination: ");
                    String destination = sc.nextLine();

                    service.searchBuses(source, destination);
                    break;

                case 3:
                    service.displayBuses();

                    System.out.print("Enter bus ID: ");
                    int busId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();

                    if (name.trim().isEmpty() || age <= 0
                            || phone.trim().isEmpty()) {
                        System.out.println("Invalid passenger details.");
                        break;
                    }

                    Passenger passenger =
                            new Passenger(name, age, phone);

                    service.bookTicket(busId, passenger);
                    break;

                case 4:
                    System.out.print("Enter ticket ID: ");
                    int viewId = sc.nextInt();
                    sc.nextLine();

                    service.viewTicket(viewId);
                    break;

                case 5:
                    System.out.print("Enter ticket ID to cancel: ");
                    int cancelId = sc.nextInt();
                    sc.nextLine();

                    service.cancelTicket(cancelId);
                    break;

                case 0:
                    System.out.println("Thank you for using our system!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}