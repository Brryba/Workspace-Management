package workspace_management.UI.menu_options.update_menu;

import org.springframework.stereotype.Component;
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
        System.out.println("Enter workspace ID");
        int workspaceID = consoleScanner.readInt();
        System.out.println("Enter new price");
        double newPrice = consoleScanner.readDouble();
        //controller
    }

    @Override
    public String getMethodName() {
        return "";
    }
}
