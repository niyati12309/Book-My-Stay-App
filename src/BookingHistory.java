import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * CLASS - BookingHistory
 * ============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Maintains confirmed reservations.
 *
 * @version 8.0
 */
public class BookingHistory {

    // Stores confirmed reservations (ordered)
    private List<Reservation> confirmedReservations;

    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    // Get all reservations
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}