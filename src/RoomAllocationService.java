import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ============================================================
 * CLASS - RoomAllocationService
 * ============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Ensures:
 * - Unique room IDs
 * - No double booking
 * - Immediate inventory update
 *
 * @version 6.0
 */
public class RoomAllocationService {

    // Stores all allocated room IDs
    private Set<String> allocatedRoomIds;

    // Maps room type -> assigned room IDs
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Allocates a room for a reservation
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();

        // Check availability
        int available = inventory.getAvailableRooms(roomType);

        if (available <= 0) {
            System.out.println("No rooms available for Guest: "
                    + reservation.getGuestName()
                    + ", Room Type: " + roomType);
            return;
        }

        // Generate unique room ID
        String roomId = generateRoomId(roomType);

        // Store allocated ID
        allocatedRoomIds.add(roomId);

        // Track by room type
        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        // Update inventory (VERY IMPORTANT)
        inventory.updateAvailability(roomType, available - 1);

        // Confirm booking
        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: " + roomId);
    }

    /**
     * Generates unique room ID
     */
    private String generateRoomId(String roomType) {

        int count = 1;
        String roomId;

        // Ensure uniqueness
        do {
            roomId = roomType + "-" + count;
            count++;
        } while (allocatedRoomIds.contains(roomId));

        return roomId;
    }
}