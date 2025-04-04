package workspace_management.UI.menu_options;

import org.springframework.stereotype.Component;
import workspace_management.UI.scanner.ConsoleScanner;

@Component
public abstract class AbstractOption {
    protected final ConsoleScanner consoleScanner;

    public AbstractOption(ConsoleScanner consoleScanner) {
        this.consoleScanner = consoleScanner;
    }

    public abstract void apply();
    public abstract String getMethodName();
}
