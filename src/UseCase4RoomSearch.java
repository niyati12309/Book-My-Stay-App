public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Inventory (UC3)
        RoomInventory inventory = new RoomInventory();

        // Existing room classes (UC2)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Search service (UC4)
        RoomSearchService searchService = new RoomSearchService();

        // Perform search
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}
