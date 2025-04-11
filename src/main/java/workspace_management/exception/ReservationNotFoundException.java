package workspace_management.exception;

public class ReservationNotFoundException extends Exception {
    public ReservationNotFoundException() {
        super("Reservation with provided ID was not found");
    }
}
