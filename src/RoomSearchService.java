/**
 * UC4: Room Search & Availability Check
 */
public class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        System.out.println("Room Search\n");

        // Single Room
        if (inventory.getAvailableRooms("Single") > 0) {
            System.out.println("Single Room:");
            singleRoom.displayRoomDetails();
            System.out.println("Available: " + inventory.getAvailableRooms("Single"));
            System.out.println();
        }

        // Double Room
        if (inventory.getAvailableRooms("Double") > 0) {
            System.out.println("Double Room:");
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + inventory.getAvailableRooms("Double"));
            System.out.println();
        }

        // Suite Room
        if (inventory.getAvailableRooms("Suite") > 0) {
            System.out.println("Suite Room:");
            suiteRoom.displayRoomDetails();
            System.out.println("Available: " + inventory.getAvailableRooms("Suite"));
        }
    }
}