package workspace_management.UI.menu_options.main_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menus.AdminMenu;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;

@Component
public class AdminMenuSelector extends AbstractOption {
    private final AdminMenu adminMenu;

    public AdminMenuSelector(ConsoleScanner consoleScanner, AdminMenu adminMenu) {
        super(consoleScanner);
        this.adminMenu = adminMenu;
    }

    @Override
    public void apply() {
        adminMenu.apply();
    }

    @Override
    public String getMethodName() {
        return "Select Admin";
    }
}
