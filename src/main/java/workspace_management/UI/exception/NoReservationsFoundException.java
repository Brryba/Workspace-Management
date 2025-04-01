package workspace_management.UI.exception;

public class NoReservationsFoundException extends RuntimeException {
    public NoReservationsFoundException() {
        super("No reservations were found so scanner cannot select any reservations");
    }
}
