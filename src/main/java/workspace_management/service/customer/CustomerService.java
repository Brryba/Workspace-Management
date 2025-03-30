package workspace_management.service.customer;

import org.springframework.stereotype.Service;
import workspace_management.repository.CustomerRepository;

@Service
public class CustomerService {
    private String currentCustomerName;

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCurrentCustomerName() {
        return currentCustomerName;
    }

    public void selectCustomer(String name) {
        if (customerRepository.findCustomer(name) == null) {
            customerRepository.insertCustomer(name);
        }
        currentCustomerName = name;
    }
}