package workspace_management.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import workspace_management.dto.ReservationDto;
import workspace_management.dto.customer.CustomerDto;
import workspace_management.service.CustomerService;
import workspace_management.service.ReservationService;
import workspace_management.service.WorkspaceService;

@Controller
@RequestMapping("/customer")
public class CustomerViewController {
    private final ReservationService reservationService;
    private final WorkspaceService workspaceService;
    private final CustomerService customerService;

    public CustomerViewController(ReservationService reservationService, WorkspaceService workspaceService, CustomerService customerService) {
        this.reservationService = reservationService;
        this.workspaceService = workspaceService;
        this.customerService = customerService;
    }

    @GetMapping
    public String customerPage(@ModelAttribute CustomerDto customer,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }

        customerService.selectCustomer(customer.getName());
        model.addAttribute("workspaces", workspaceService.getAvailableWorkspaces());
        model.addAttribute("name", customer.getName());
        model.addAttribute("reservations", reservationService.getReservations(customer.getName()));
        ReservationDto newReservation = new ReservationDto();
        newReservation.setCustomerName(customer.getName());
        model.addAttribute("newReservation", newReservation);
        return "customer";
    }
}
