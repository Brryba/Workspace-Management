package workspace_management.UI.menu_options.main_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.context.CustomerContext;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.menus.CustomerMenu;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.service.CustomerService;

@Component
public class CustomerMenuSelector extends AbstractOption {
    private final CustomerMenu customerMenu;

    public CustomerMenuSelector(ConsoleScanner consoleScanner, CustomerMenu customerMenu) {
        super(consoleScanner);
        this.customerMenu = customerMenu;
    }

    @Override
    public void apply() {
        System.out.println("Enter your customer name: ");
        String customerName = consoleScanner.readString();
        CustomerContext.setCustomerName(customerName);
        customerMenu.apply();
    }

    @Override
    public String getMethodName() {
        return "Select Customer";
    }
}
