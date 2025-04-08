package workspace_management.exception;

public class CustomerExistsException extends Exception {
    public CustomerExistsException() {
        super("Customer was not added, because it already exists");
    }
}
