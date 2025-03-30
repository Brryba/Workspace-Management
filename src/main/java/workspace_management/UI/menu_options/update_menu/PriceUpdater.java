package workspace_management.UI.menu_options.update_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.read.ConsoleScanner;

@Component
public class PriceUpdater extends AbstractOption {
    public PriceUpdater(ConsoleScanner consoleScanner) {
        super(consoleScanner);
    }

    @Override
    public void apply() {

    }

    @Override
    public String getMethodName() {
        return "";
    }
}
