import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Bus> buses = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();
    private int nextTicketId = 1001;

    public BookingService() {
        buses.add(new Bus(1, "Express Travels",
                "Chennai", "Coimbatore", 3, 650));
        buses.add(new Bus(2, "Green Line",
                "Chennai", "Madurai", 3, 550));
        buses.add(new Bus(3, "Royal Travels",
                "Coimbatore", "Chennai", 3, 600));
        buses.add(new Bus(4, "Tamil Express",
                "Madurai", "Chennai", 3, 500));
    }

    public void displayBuses() {
        System.out.println("\n================ AVAILABLE BUSES ================");
        System.out.printf("%-6s %-20s %-15s %-15s %-10s %s%n",
                "ID", "Bus Name", "Source", "Destination",
                "Seats", "Fare");
        System.out.println("--------------------------------------------------");

        for (Bus bus : buses) {
            bus.displayBus();
        }
    }

    public void searchBuses(String source, String destination) {
        boolean found = false;

        for (Bus bus : buses) {
            if (bus.getSource().equalsIgnoreCase(source.trim())
                    && bus.getDestination()
                          .equalsIgnoreCase(destination.trim())) {
                if (!found) {
                    System.out.println("\nMatching buses:");
                    found = true;
                }
                bus.displayBus();
            }
        }

        if (!found) {
            System.out.println("No buses found for this route.");
        }
    }

    public void bookTicket(int busId, Passenger passenger) {
        Bus selectedBus = findBus(busId);

        if (selectedBus == null) {
            System.out.println("Invalid bus ID.");
            return;
        }

        if (!selectedBus.bookSeat()) {
            System.out.println("Sorry, no seats available.");
            return;
        }

        Ticket ticket = new Ticket(nextTicketId++, selectedBus, passenger);
        tickets.add(ticket);

        System.out.println("\nTicket booked successfully!");
        ticket.displayTicket();
    }

    public void viewTicket(int ticketId) {
        Ticket ticket = findTicket(ticketId);

        if (ticket == null) {
            System.out.println("Ticket not found.");
        } else {
            ticket.displayTicket();
        }
    }

    public void cancelTicket(int ticketId) {
        Ticket ticket = findTicket(ticketId);

        if (ticket == null) {
            System.out.println("Ticket not found.");
        } else if (!ticket.isActive()) {
            System.out.println("This ticket is already cancelled.");
        } else {
            ticket.cancel();
            System.out.println("Ticket cancelled successfully.");
        }
    }

    private Bus findBus(int busId) {
        for (Bus bus : buses) {
            if (bus.getBusId() == busId) {
                return bus;
            }
        }
        return null;
    }

    private Ticket findTicket(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }
        return null;
    }
}