package workspace_management.UI.menu_options.customer_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.WorkspaceController;

@Component
public class AvailableSpacesShower extends AbstractOption {
    private final WorkspaceController workspaceController;

    public AvailableSpacesShower(ConsoleScanner consoleScanner, WorkspaceController workspaceController) {
        super(consoleScanner);
        this.workspaceController = workspaceController;
    }

    @Override
    public void apply() {
        workspaceController.getAvailableWorkspaces().ifPresentOrElse((workspaces -> {
            workspaces.forEach(System.out::println);
        }), () -> System.err.println("No available workspaces found"));
    }

    @Override
    public String getMethodName() {
        return "Show available spaces";
    }
}
