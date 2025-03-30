package workspace_management.UI.menu_options.admin_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.read.ConsoleScanner;
import workspace_management.controller.WorkspaceController;

@Component
public class WorkspaceRemover extends AbstractOption {
    private WorkspaceController workspaceController;

    public WorkspaceRemover(ConsoleScanner consoleScanner, WorkspaceController workspaceController) {
        super(consoleScanner);
        this.workspaceController = workspaceController;
    }

    @Override
    public void apply() {
        System.out.println("Enter workspace ID to remove");
        int workspaceID = consoleScanner.readWorkspaceID();
        //controller
    }

    @Override
    public String getMethodName() {
        return "Remove Workspace";
    }
}
