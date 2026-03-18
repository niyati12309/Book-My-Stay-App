/**
 * ============================================================
 * MAIN CLASS - UseCase2RoomInitialization
 * ============================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * @version 2.1
 */
public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display Single Room
        System.out.println("Single Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleAvailable + "\n");

        // Display Double Room
        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable + "\n");

        // Display Suite Room
        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}