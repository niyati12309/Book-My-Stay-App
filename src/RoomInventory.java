import java.util.HashMap;
import java.util.Map;

/**
 * CLASS - RoomInventory
 * Centralized Room Inventory Management
 * Version 3.1
 */
public class RoomInventory {

    // Stores available room count for each room type
    private Map<String, Integer> roomAvailability;

    // Constructor initializes inventory
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    // Initialize room availability
    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    // Retrieves current availability
    public int getAvailableRooms(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }

    // Updates availability
    public void updateAvailability(String roomType, int count) {
        if (roomAvailability.containsKey(roomType)) {
            roomAvailability.put(roomType, count);
        } else {
            System.out.println("Room type not found!");
        }
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("Hotel Room Inventory Status\n");

        System.out.println("Single Room:");
        System.out.println("Beds: 1");
        System.out.println("Size: 250 sqft");
        System.out.println("Price per night: 1500.0");
        System.out.println("Available Rooms: " + getAvailableRooms("Single"));
        System.out.println();

        System.out.println("Double Room:");
        System.out.println("Beds: 2");
        System.out.println("Size: 400 sqft");
        System.out.println("Price per night: 2500.0");
        System.out.println("Available Rooms: " + getAvailableRooms("Double"));
        System.out.println();

        System.out.println("Suite Room:");
        System.out.println("Beds: 3");
        System.out.println("Size: 750 sqft");
        System.out.println("Price per night: 5000.0");
        System.out.println("Available Rooms: " + getAvailableRooms("Suite"));
    }
}