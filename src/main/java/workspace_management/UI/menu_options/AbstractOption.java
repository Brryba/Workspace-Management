package workspace_management.UI.menu_options;

import org.springframework.stereotype.Component;
import workspace_management.UI.read.ConsoleScanner;

@Component
public abstract class AbstractOption {
    protected ConsoleScanner consoleScanner;

    public AbstractOption(ConsoleScanner consoleScanner) {
        this.consoleScanner = consoleScanner;
    }

    public abstract void apply();
    public abstract String getMethodName();
}
