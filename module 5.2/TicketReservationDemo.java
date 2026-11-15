public class TicketReservationDemo {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem(10);
        int[] requests = {2, 1, 3, 1, 2, 2, 1, 1, 3, 3, 2, 4, 1, 4, 3};
        Customer[] customers = new Customer[requests.length];
        for (int i = 0; i < requests.length; i++) {
            customers[i] = new Customer("Customer " + (i + 1), system, requests[i]);
        }
        for (Customer customer : customers) {
            customer.start();
        }
        try {
            int successfulTickets = 0;
            for (Customer customer : customers) {
                customer.join();
                if (customer.wasSuccessful()) {
                    successfulTickets += customer.getTicketCount();
                }
            }
            System.out.println("Theater capacity: " + system.getCapacity());
            System.out.println("Reserved seats: " + system.getReservedSeats());
            System.out.println("Available seats: " + system.getAvailableSeats());
            boolean correct = successfulTickets == system.getReservedSeats()
                    && successfulTickets <= system.getCapacity() && system.getAvailableSeats() >= 0;
            System.out.println("No overbooking and reservation totals match: " + correct);
            if (!correct) { throw new IllegalStateException("Reservation totals are incorrect."); }
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println("Waiting for customers was interrupted.");
        }
    }
}
