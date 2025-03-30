package workspace_management.UI.menu_options.update_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.WorkspaceController;

@Component
public class TypeUpdater extends AbstractOption {
    private final WorkspaceController workspaceController;

    public TypeUpdater(ConsoleScanner consoleScanner, WorkspaceController workspaceController) {
        super(consoleScanner);
        this.workspaceController = workspaceController;
    }

    @Override
    public void apply() {
        System.out.println("Enter desired workspace ID");
        int workspaceID = consoleScanner.readInt();
        System.out.println("Enter new type");
        String newType = consoleScanner.readString();
        //controller
    }

    @Override
    public String getMethodName() {
        return "Update Type";
    }
}
