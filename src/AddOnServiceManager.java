import java.util.*;

/**
 * ============================================================
 * CLASS - AddOnServiceManager
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Manages services mapped to reservation IDs.
 *
 * @version 7.0
 */
public class AddOnServiceManager {

    // Map: Reservation ID -> List of services
    private Map<String, List<AddOnService>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    // Add service to reservation
    public void addService(String reservationId, AddOnService service) {

        servicesByReservation
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    // Calculate total service cost
    public double calculateTotalServiceCost(String reservationId) {

        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services == null) {
            return 0;
        }

        double total = 0;

        for (AddOnService service : services) {
            total += service.getCost();
        }

        return total;
    }
}