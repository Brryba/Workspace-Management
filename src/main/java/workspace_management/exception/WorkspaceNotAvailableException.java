package workspace_management.exception;

public class WorkspaceNotAvailableException extends RuntimeException {
    public WorkspaceNotAvailableException() {
        super("Workspace with provided ID is not currently available");
    }
}
