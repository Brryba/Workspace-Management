package workspace_management.exception;

public class WorkspaceNotFoundException extends Exception {
    public WorkspaceNotFoundException() {
        super("Workspace with provided ID was not found");
    }
}
