package workspace_management.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import workspace_management.dto.customer.CustomerRequestDto;
import workspace_management.dto.customer.CustomerResponseDto;
import workspace_management.entity.Customer;
import workspace_management.exception.CustomerExistsException;
import workspace_management.repository.CustomerRepository;
import workspace_management.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    ResponseEntity<List<CustomerResponseDto>> getCustomers() {
        List<CustomerResponseDto> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        customerService.add(customerRequestDto);
        return new ResponseEntity<>(customerRequestDto, HttpStatus.CREATED);
    }

    @ExceptionHandler(CustomerExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String customerExistsException(CustomerExistsException e) {
        return e.getMessage();
    }
}
