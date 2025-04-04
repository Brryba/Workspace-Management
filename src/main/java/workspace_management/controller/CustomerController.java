package workspace_management.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import workspace_management.dto.customer.CustomerInputDto;
import workspace_management.service.CustomerService;
import workspace_management.service.WorkspaceService;

@Controller
@RequestMapping("/customer")

public class CustomerController {
    private final CustomerService customerService;
    private final WorkspaceService workspaceService;
    private final ReservationController reservationController;

    @Autowired
    public CustomerController(CustomerService customerService, WorkspaceService workspaceService, ReservationController reservationController) {
        this.customerService = customerService;
        this.workspaceService = workspaceService;
        this.reservationController = reservationController;
    }

    @PostMapping
    public String setCustomer(@ModelAttribute("customer")
                                  @Valid CustomerInputDto customer,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }

        customerService.selectCustomer(customer.getName());
        model.addAttribute("workspaces", workspaceService.getAvailableWorkspaces());
        return "customer";
    }
}
