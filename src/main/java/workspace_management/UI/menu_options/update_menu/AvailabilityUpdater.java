package workspace_management.UI.menu_options.update_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.read.ConsoleScanner;
import workspace_management.controller.WorkspaceController;

@Component
public class AvailabilityUpdater extends AbstractOption {
    private WorkspaceController controller;

    public AvailabilityUpdater(ConsoleScanner consoleScanner, WorkspaceController controller) {
        super(consoleScanner);
        this.controller = controller;
    }

    @Override
    public void apply() {
        System.out.println("Enter desired workspace ID");
        int workspaceID = consoleScanner.readInt();
        System.out.println("Is available");
        //scanner
        //controller
    }

    @Override
    public String getMethodName() {
        return "";
    }
}
