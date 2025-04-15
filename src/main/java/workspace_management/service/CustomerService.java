package workspace_management.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import workspace_management.dto.customer.CustomerRequestDto;
import workspace_management.dto.customer.CustomerMapper;
import workspace_management.dto.customer.CustomerResponseDto;
import workspace_management.entity.Customer;
import workspace_management.exception.CustomerExistsException;
import workspace_management.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class CustomerService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper mapper;
    @Autowired
    private PasswordEncoder encoder;

    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public void add(CustomerRequestDto customerRequestDto) {
        if (customerRepository.existsById(customerRequestDto.getName())) {
            throw new CustomerExistsException();
        }
        Customer customer = new Customer();
        customer.setName(customerRequestDto.getName());
        customer.setPassword(encoder.encode(customerRequestDto.getPassword()));
        customer.setRole(Customer.Roles.ROLE_USER);
        customerRepository.save(customer);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Customer customer = customerRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return new User(customer.getUsername(),
                customer.getPassword(),
                customer.getAuthorities());
    }
}