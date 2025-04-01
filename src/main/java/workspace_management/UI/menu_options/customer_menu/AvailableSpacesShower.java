package workspace_management.UI.menu_options.customer_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.WorkspaceController;
import workspace_management.model.Workspace;

import java.util.List;

@Component
public class AvailableSpacesShower extends AbstractOption {
    private final WorkspaceController workspaceController;

    public AvailableSpacesShower(ConsoleScanner consoleScanner, WorkspaceController workspaceController) {
        super(consoleScanner);
        this.workspaceController = workspaceController;
    }

    @Override
    public void apply() {
        List<Workspace> workspaces = workspaceController.getAvailableWorkspaces();
        if (workspaces.isEmpty()) {
            System.err.println("No workspaces found");
        } else {
            workspaces.forEach(System.out::println);
        }
    }

    @Override
    public String getMethodName() {
        return "Show available spaces";
    }
}
