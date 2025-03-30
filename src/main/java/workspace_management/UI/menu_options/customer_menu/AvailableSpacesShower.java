package workspace_management.UI.menu_options.customer_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.read.ConsoleScanner;

@Component
public class AvailableSpacesShower extends AbstractOption {
    //WorkspaceService
    public AvailableSpacesShower(ConsoleScanner consoleScanner) {
        super(consoleScanner);
    }

    @Override
    public void apply() {

    }

    @Override
    public String getMethodName() {
        return "Show available spaces";
    }
}
