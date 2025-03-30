package workspace_management.UI.menu_options.customer_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.read.ConsoleScanner;
import workspace_management.controller.WorkspaceController;

@Component
public class AvailableSpacesShower extends AbstractOption {
    private WorkspaceController workspaceController;

    public AvailableSpacesShower(ConsoleScanner consoleScanner, WorkspaceController workspaceController) {
        super(consoleScanner);
        this.workspaceController = workspaceController;
    }

    @Override
    public void apply() {
        //workspaceController.getAll
    }

    @Override
    public String getMethodName() {
        return "Show available spaces";
    }
}
