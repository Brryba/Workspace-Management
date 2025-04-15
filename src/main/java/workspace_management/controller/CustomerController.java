package workspace_management.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import workspace_management.dto.customer.CustomerRequestDto;
import workspace_management.dto.customer.CustomerResponseDto;
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
    @ResponseStatus(HttpStatus.OK)
    List<CustomerResponseDto> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public CustomerResponseDto addCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        return customerService.add(customerRequestDto);
    }
}
