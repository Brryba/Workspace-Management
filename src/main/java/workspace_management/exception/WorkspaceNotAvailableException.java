package workspace_management.exception;

public class WorkspaceNotAvailableException extends Exception {
    public WorkspaceNotAvailableException() {
        super("Workspace with provided ID is not currently available");
    }
}
