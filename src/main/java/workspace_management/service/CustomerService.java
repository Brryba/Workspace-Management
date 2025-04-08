package workspace_management.service;

import org.springframework.stereotype.Service;
import workspace_management.dto.CustomerDto;
import workspace_management.entity.Customer;
import workspace_management.exception.CustomerExistsException;
import workspace_management.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(this::toDto).collect(Collectors.toList());
    }

    public void add(CustomerDto customerDto) throws CustomerExistsException {
        if (customerRepository.existsById(customerDto.getName())) {
            throw new CustomerExistsException();
        }
        Customer customer = this.fromDto(customerDto);
        customerRepository.save(customer);
    }

    private CustomerDto toDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        return customerDto;
    }

    private Customer fromDto(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        return customer;
    }
}