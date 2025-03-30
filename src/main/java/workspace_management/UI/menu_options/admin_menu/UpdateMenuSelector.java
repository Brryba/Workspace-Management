package workspace_management.UI.menu_options.admin_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.context.WorkspaceContext;
import workspace_management.UI.exception.NoWorkspacesFoundException;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.menus.WorkspaceUpdateMenu;
import workspace_management.UI.scanner.ConsoleScanner;

@Component
public class UpdateMenuSelector extends AbstractOption {
    private final WorkspaceUpdateMenu workspaceUpdateMenu;

    public UpdateMenuSelector(ConsoleScanner consoleScanner, WorkspaceUpdateMenu workspaceUpdateMenu) {
        super(consoleScanner);
        this.workspaceUpdateMenu = workspaceUpdateMenu;
    }

    @Override
    public void apply() {
        try {
            int workspaceID = consoleScanner.readWorkspaceID(false);
            WorkspaceContext.setWorkspaceID(workspaceID);
            workspaceUpdateMenu.apply();
        } catch (NoWorkspacesFoundException e) {
            System.err.println("No workspaces found");
        }
    }

    @Override
    public String getMethodName() {
        return "Update Workspace Information";
    }
}
