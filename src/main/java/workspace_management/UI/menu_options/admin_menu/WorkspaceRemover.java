package workspace_management.UI.menu_options.admin_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.exception.NoWorkspacesFoundException;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.WorkspaceController;

@Component
public class WorkspaceRemover extends AbstractOption {
    private final WorkspaceController workspaceController;

    public WorkspaceRemover(ConsoleScanner consoleScanner, WorkspaceController workspaceController) {
        super(consoleScanner);
        this.workspaceController = workspaceController;
    }

    @Override
    public void apply() {
        try {
            int workspaceID = consoleScanner.readWorkspaceID(false);
            workspaceController.deleteWorkspace(workspaceID);
        } catch (NoWorkspacesFoundException e) {
            System.err.println("No workspaces found");
        }
    }

    @Override
    public String getMethodName() {
        return "Remove Workspace";
    }
}
