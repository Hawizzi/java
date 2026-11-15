public class TicketReservationSystem {
    private final int capacity;
    private int availableSeats;

    public TicketReservationSystem(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative.");
        }
        this.capacity = capacity;
        availableSeats = capacity;
    }

    public synchronized boolean reserveTickets(String customer, int ticketCount) {
        if (customer == null || customer.trim().isEmpty() || ticketCount <= 0) {
            throw new IllegalArgumentException("A customer name and positive ticket count are required.");
        }
        if (ticketCount > availableSeats) {
            System.out.println(customer + " couldn't reserve " + ticketCount + " tickets.");
            return false;
        }
        availableSeats -= ticketCount;
        System.out.println(customer + " reserved " + ticketCount + " tickets.");
        return true;
    }

    public synchronized int getAvailableSeats() { return availableSeats; }
    public synchronized int getReservedSeats() { return capacity - availableSeats; }
    public int getCapacity() { return capacity; }
}
