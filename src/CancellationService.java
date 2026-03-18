import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

/**
 * ============================================================
 * CLASS - CancellationService
 * ============================================================
 *
 * Handles booking cancellations and rollback.
 *
 * @version 10.0
 */
public class CancellationService {

    // Stack for rollback tracking (LIFO)
    private Stack<String> releasedRoomIds;

    // Map reservationId -> roomType
    private Map<String, String> reservationRoomTypeMap;

    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    // Register confirmed booking
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    // Cancel booking
    public void cancelBooking(String reservationId, RoomInventory inventory) {

        // Validate existence
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Reservation not found.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        // Restore inventory
        int current = inventory.getAvailableRooms(roomType);
        inventory.updateAvailability(roomType, current + 1);

        // Track rollback (LIFO)
        releasedRoomIds.push(reservationId);

        // Remove from active bookings
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    // Show rollback history
    public void showRollbackHistory() {

        System.out.println("\nRollback History (Most Recent First):");

        while (!releasedRoomIds.isEmpty()) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.pop());
        }
    }
}