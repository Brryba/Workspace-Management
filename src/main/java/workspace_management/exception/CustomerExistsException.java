package workspace_management.exception;

public class CustomerExistsException extends RuntimeException {
    public CustomerExistsException() {
        super("Customer was not added, because it already exists");
    }
}
