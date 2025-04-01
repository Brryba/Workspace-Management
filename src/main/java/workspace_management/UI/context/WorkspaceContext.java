package workspace_management.UI.context;

public class WorkspaceContext {
    private WorkspaceContext() {}

    private static int workspaceID;

    public static int getWorkspaceID() {
        return workspaceID;
    }

    public static void setWorkspaceID(int newWorkspaceID) {
        workspaceID = newWorkspaceID;
    }
}
