package workspace_management.UI.menu_options.main_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;

@Component
public class MainMenuSelector extends AbstractOption {
    public MainMenuSelector(ConsoleScanner consoleScanner) {
        super(consoleScanner);
    }

    @Override
    public void apply() {
        //Empty, because just let's the cycle end
    }

    @Override
    public String getMethodName() {
        return "Main Menu";
    }
}
