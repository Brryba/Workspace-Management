package workspace_management.UI.menu_options.main_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.read.ConsoleScanner;
import workspace_management.service.customer.CustomerService;

@Component
public class CustomerMenuSelector extends AbstractOption {
    private CustomerService customerService;

    public CustomerMenuSelector(CustomerService customerService, ConsoleScanner consoleScanner) {
        super(consoleScanner);
        this.customerService = customerService;
    }

    @Override
    public void apply() {
        System.out.println("Enter your customer name: ");
        String customerName = consoleScanner.readString();
        customerService.selectCustomer(customerName);
    }

    @Override
    public String getMethodName() {
        return "Select Customer";
    }
}
