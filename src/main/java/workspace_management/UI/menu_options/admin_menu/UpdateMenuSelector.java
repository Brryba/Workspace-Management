package workspace_management.UI.menu_options.admin_menu;

import org.springframework.stereotype.Component;
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
        int workspaceID = consoleScanner.readWorkspaceID();
        workspaceUpdateMenu.setWorkspaceID(workspaceID);
        workspaceUpdateMenu.apply();
    }

    @Override
    public String getMethodName() {
        return "Update Workspace Information";
    }
}
