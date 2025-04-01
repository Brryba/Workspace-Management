package workspace_management.UI.exception;

public class NoWorkspacesFoundException extends Exception {
    public NoWorkspacesFoundException() {
        super("No workspaces were found so scanner cannot select any workspace");
    }
}
