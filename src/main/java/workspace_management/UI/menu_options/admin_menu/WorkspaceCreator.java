package workspace_management.UI.menu_options.admin_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.WorkspaceController;

@Component
public class WorkspaceCreator extends AbstractOption {
    private final WorkspaceController workspaceController;

    public WorkspaceCreator(ConsoleScanner consoleScanner, WorkspaceController workspaceController) {
        super(consoleScanner);
        this.workspaceController = workspaceController;
    }

    @Override
    public void apply() {
        System.out.println("Enter workspace type");
        String workspaceType = consoleScanner.readString();
        System.out.println("Enter workspace price");
        double workspacePrice = consoleScanner.readDouble();
        System.out.println("Is workspace available?");
        boolean isAvailable = consoleScanner.readBoolean();
        workspaceController.addWorkspace(workspaceType, workspacePrice, isAvailable);
    }

    @Override
    public String getMethodName() {
        return "Add New Workspace";
    }
}
