package workspace_management.UI.menu_options.main_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.read.ConsoleScanner;

@Component
public class AppQuitter extends AbstractOption {
    public AppQuitter(ConsoleScanner consoleScanner) {
        super(consoleScanner);
    }

    @Override
    public void apply() {
        System.out.println("Bye!");
    }

    @Override
    public String getMethodName() {
        return "Quit";
    }
}
