/**
 * ============================================================
 * MAIN CLASS - UseCase12DataPersistenceRecovery
 * ============================================================
 *
 * Demonstrates persistence and recovery.
 *
 * @version 12.0
 */
public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        String filePath = "inventory.txt";

        // Load saved state
        persistenceService.loadInventory(inventory, filePath);

        // Display current inventory
        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getAvailableRooms("Single"));
        System.out.println("Double: " + inventory.getAvailableRooms("Double"));
        System.out.println("Suite: " + inventory.getAvailableRooms("Suite"));

        // Save state
        persistenceService.saveInventory(inventory, filePath);
    }
}