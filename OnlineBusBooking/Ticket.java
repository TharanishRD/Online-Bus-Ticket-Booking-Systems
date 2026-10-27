public class Ticket {
    private int ticketId;
    private Bus bus;
    private Passenger passenger;
    private boolean active;

    public Ticket(int ticketId, Bus bus, Passenger passenger) {
        this.ticketId = ticketId;
        this.bus = bus;
        this.passenger = passenger;
        this.active = true;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Bus getBus() {
        return bus;
    }

    public boolean isActive() {
        return active;
    }

    public void cancel() {
        active = false;
        bus.cancelSeat();
    }

    public void displayTicket() {
        System.out.println("\n========== BUS TICKET ==========");
        System.out.println("Ticket ID  : " + ticketId);
        System.out.println("Passenger  : " + passenger.getName());
        System.out.println("Age        : " + passenger.getAge());
        System.out.println("Phone      : " + passenger.getPhone());
        System.out.println("Bus        : " + bus.getBusName());
        System.out.println("Route      : " + bus.getSource()
                           + " -> " + bus.getDestination());
        System.out.printf("Fare       : Rs.%.2f%n", bus.getFare());
        System.out.println("Status     : " +
                           (active ? "CONFIRMED" : "CANCELLED"));
        System.out.println("================================");
    }
}