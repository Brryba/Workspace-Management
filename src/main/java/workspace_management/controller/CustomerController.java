package workspace_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import workspace_management.service.CustomerService;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setCustomer(String customerName) {
        customerService.selectCustomer(customerName);
    }
}
