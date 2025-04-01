package workspace_management.UI.menu_options.update_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.context.WorkspaceContext;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.WorkspaceController;

@Component
public class PriceUpdater extends AbstractOption {
    private final WorkspaceController workspaceController;

    public PriceUpdater(ConsoleScanner consoleScanner, WorkspaceController workspaceController) {
        super(consoleScanner);
        this.workspaceController = workspaceController;
    }

    @Override
    public void apply() {
        System.out.println("Enter new price");
        double newPrice = consoleScanner.readDouble();
        workspaceController.updateWorkspace(WorkspaceContext.getWorkspaceID(), newPrice);
    }

    @Override
    public String getMethodName() {
        return "Update Price";
    }
}
