package workspace_management.entity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomerFactory {
    private final PasswordEncoder encoder;

    CustomerFactory(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public Customer createUser(String customerName, String password) {
        Customer customer = new Customer();
        customer.setName(customerName);
        customer.setPassword(encoder.encode(password));
        customer.setRole(Customer.Roles.ROLE_USER);
        return customer;
    }
}
