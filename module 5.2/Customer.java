public class Customer extends Thread {
    private final TicketReservationSystem reservationSystem;
    private final int ticketCount;
    private boolean successful;

    public Customer(String name, TicketReservationSystem reservationSystem, int ticketCount) {
        super(name);
        if (reservationSystem == null || ticketCount <= 0) {
            throw new IllegalArgumentException("A reservation system and positive ticket count are required.");
        }
        this.reservationSystem = reservationSystem;
        this.ticketCount = ticketCount;
    }

    @Override
    public void run() {
        successful = reservationSystem.reserveTickets(getName(), ticketCount);
    }

    public boolean wasSuccessful() { return successful; }
    public int getTicketCount() { return ticketCount; }
}
