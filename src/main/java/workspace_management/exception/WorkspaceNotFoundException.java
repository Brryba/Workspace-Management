package workspace_management.exception;

public class WorkspaceNotFoundException extends RuntimeException {
    public WorkspaceNotFoundException() {
        super("Workspace with provided ID was not found");
    }
}
