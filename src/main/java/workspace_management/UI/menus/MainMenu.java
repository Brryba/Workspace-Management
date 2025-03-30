package workspace_management.UI.menus;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.main_menu.AdminMenuSelector;
import workspace_management.UI.menu_options.main_menu.AppQuitter;
import workspace_management.UI.menu_options.main_menu.CustomerMenuSelector;
import workspace_management.UI.read.ConsoleScanner;

@Component
public class MainMenu extends AbstractMenu {
    private CustomerMenuSelector customerMenuSelector;
    private AdminMenuSelector adminMenuSelector;
    private AppQuitter appQuitter;

    public MainMenu(ConsoleScanner consoleScanner, AppQuitter appQuitter, AdminMenuSelector adminMenuSelector, CustomerMenuSelector customerMenuSelector) {
        super(consoleScanner);
        this.appQuitter = appQuitter;
        this.adminMenuSelector = adminMenuSelector;
        this.customerMenuSelector = customerMenuSelector;
    }

    @Override
    protected void setMethods() {
        this.addMethod(1, adminMenuSelector);
        this.addMethod(2, customerMenuSelector);
        this.addMethod(AbstractMenu.QUIT_MENU_METHOD, appQuitter);
    }
}

