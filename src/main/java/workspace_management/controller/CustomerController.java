package workspace_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import workspace_management.UI.menus.CustomerMenu;
import workspace_management.service.CustomerService;

@Controller
public class CustomerController {
    private CustomerService customerService;
    private CustomerMenu customerMenu;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMenu customerMenu) {
        this.customerService = customerService;
        this.customerMenu = customerMenu;
    }

    public void setCustomer(String customerName) {
        customerService.selectCustomer(customerName);
        customerMenu.apply();
    }
}
