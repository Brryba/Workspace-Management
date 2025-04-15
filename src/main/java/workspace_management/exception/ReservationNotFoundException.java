package workspace_management.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException() {
        super("Reservation with provided ID was not found");
    }
}
