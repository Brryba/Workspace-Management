package workspace_management.exception;

import org.springframework.security.access.AccessDeniedException;

public class WrongCustomerException extends AccessDeniedException {
    public WrongCustomerException() {
        super("Access denied");
    }
}
