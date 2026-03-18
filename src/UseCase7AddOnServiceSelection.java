/**
 * ============================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ============================================================
 *
 * Demonstrates add-on services for a reservation.
 *
 * @version 7.0
 */
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection\n");

        // Example reservation ID (from UC6)
        String reservationId = "Single-1";

        AddOnServiceManager manager = new AddOnServiceManager();

        // Add services
        manager.addService(reservationId, new AddOnService("Breakfast", 500));
        manager.addService(reservationId, new AddOnService("Spa", 1000));

        // Calculate total cost
        double totalCost = manager.calculateTotalServiceCost(reservationId);

        // Output
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}