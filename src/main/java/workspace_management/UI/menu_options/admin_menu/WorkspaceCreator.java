package workspace_management.UI.menu_options.admin_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.read.ConsoleScanner;
import workspace_management.controller.WorkspaceController;
import workspace_management.model.Workspace;

@Component
public class WorkspaceCreator extends AbstractOption {
    private WorkspaceController workspaceController;

    public WorkspaceCreator(ConsoleScanner consoleScanner) {
        super(consoleScanner);
    }

    @Override
    public void apply() {
        System.out.println("Enter workspace type");
        String workspaceType = consoleScanner.readString();
        System.out.println("Enter workspace price");
        String workspacePrice = consoleScanner.readString();
        System.out.println("Is workspace available");
        //scanner.readAvailable
        //controller
    }

    @Override
    public String getMethodName() {
        return "Add New Workspace";
    }
}
