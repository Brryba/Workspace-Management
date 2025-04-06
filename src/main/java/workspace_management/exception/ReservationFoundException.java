package workspace_management.exception;

public class ReservationFoundException extends Exception {
    public ReservationFoundException() {
        super("Reservation with provided ID was not found");
    }
}
