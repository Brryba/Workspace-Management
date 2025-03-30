package workspace_management.UI.menu_options.admin_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.read.ConsoleScanner;

@Component
public class AdminReservationViewer extends AbstractOption {
    public AdminReservationViewer(ConsoleScanner consoleScanner) {
        super(consoleScanner);
    }

    @Override
    public void apply() {

    }

    @Override
    public String getMethodName() {
        return "Show All Reservations";
    }
}
