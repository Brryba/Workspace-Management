package workspace_management.UI.menu_options.update_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.context.WorkspaceContext;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.WorkspaceController;

@Component
public class AvailabilityUpdater extends AbstractOption {
    private final WorkspaceController controller;

    public AvailabilityUpdater(ConsoleScanner consoleScanner, WorkspaceController controller) {
        super(consoleScanner);
        this.controller = controller;
    }

    @Override
    public void apply() {
        System.out.println("Is available");
        boolean isAvailable = consoleScanner.readBoolean();
        controller.updateWorkspace(WorkspaceContext.getWorkspaceID(), isAvailable);
    }

    @Override
    public String getMethodName() {
        return "Update Availability";
    }
}
