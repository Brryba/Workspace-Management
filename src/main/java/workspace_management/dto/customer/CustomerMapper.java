package workspace_management.dto.customer;

import org.springframework.stereotype.Component;
import workspace_management.entity.Customer;

@Component
public class CustomerMapper {
    public CustomerDto toDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        return customerDto;
    }

    public Customer fromDto(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        return customer;
    }
}
