package workspace_management.exception;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException() {
        super("User not found");
    }
}
