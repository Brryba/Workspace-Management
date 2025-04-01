package workspace_management.UI.menu_options.update_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;

@Component
public class UpdateMenuCloser extends AbstractOption {
    public UpdateMenuCloser(ConsoleScanner consoleScanner) {
        super(consoleScanner);
    }

    @Override
    public void apply() {
        //just letting menu cycle end
    }

    @Override
    public String getMethodName() {
        return "Back To Admin Menu";
    }
}
