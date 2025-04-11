package workspace_management.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workspace_management.dto.customer.CustomerDto;
import workspace_management.exception.CustomerExistsException;
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
    ResponseEntity<List<CustomerDto>> getCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody @Valid CustomerDto customerDto) {
        try {
            customerService.add(customerDto);
            return new ResponseEntity<>(customerDto, HttpStatus.CREATED);
        } catch (CustomerExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
