package workspace_management.service;

import org.springframework.stereotype.Service;
import workspace_management.dto.customer.CustomerDto;
import workspace_management.dto.customer.CustomerMapper;
import workspace_management.entity.Customer;
import workspace_management.exception.CustomerExistsException;
import workspace_management.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.mapper = customerMapper;
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public void add(CustomerDto customerDto) throws CustomerExistsException {
        if (customerRepository.existsById(customerDto.getName())) {
            throw new CustomerExistsException();
        }
        Customer customer = mapper.fromDto(customerDto);
        customerRepository.save(customer);
    }
}