package workspace_management.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("User not found");
    }
}
