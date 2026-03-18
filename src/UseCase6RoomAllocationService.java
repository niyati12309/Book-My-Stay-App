/**
 * ============================================================
 * MAIN CLASS - UseCase6RoomAllocationService
 * ============================================================
 *
 * Demonstrates room allocation using FIFO requests.
 *
 * @version 6.0
 */
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing\n");

        // Inventory (UC3)
        RoomInventory inventory = new RoomInventory();

        // Queue (UC5)
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add booking requests
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Allocation service (UC6)
        RoomAllocationService allocationService = new RoomAllocationService();

        // Process queue (FIFO)
        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();
            allocationService.allocateRoom(r, inventory);
        }
    }
}