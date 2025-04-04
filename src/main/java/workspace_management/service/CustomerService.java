package workspace_management.service;

import org.springframework.stereotype.Service;
import workspace_management.UI.context.CustomerContext;
import workspace_management.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void selectCustomer(String name) {
        if (customerRepository.findCustomer(name) == null) {
            customerRepository.insertCustomer(name);
        }
        CustomerContext.setCustomerName(name);
    }
}