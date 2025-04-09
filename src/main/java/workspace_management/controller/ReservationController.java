/*package workspace_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import workspace_management.dto.customer.CustomerDto;
import workspace_management.dto.ReservationDto;
import workspace_management.model.Reservation;
import workspace_management.repository.ReservationRepository;
import workspace_management.repository.WorkspaceRepository;
import workspace_management.service.ReservationService;
import workspace_management.service.WorkspaceService;

import java.util.Optional;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;
    private final WorkspaceService workspaceService;
    private final WorkspaceRepository workspaceRepository;

    public ReservationController(ReservationService reservationService, ReservationRepository reservationRepository, WorkspaceService workspaceService, WorkspaceRepository workspaceRepository) {
        this.reservationService = reservationService;
        this.reservationRepository = reservationRepository;
        this.workspaceService = workspaceService;
        this.workspaceRepository = workspaceRepository;
    }

    @PostMapping("/new")
    public String createReservation(@ModelAttribute ReservationDto reservation, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/customer?name=" + reservation.getCustomerName();
        }

        if (workspaceRepository.containsWorkspace(reservation.getWorkspaceID())) {
            reservationService.createNewReservation(reservation);
        } else {
            redirectAttributes.addFlashAttribute("error", "Workspace not exists");
        }
        return "redirect:/customer?name=" + reservation.getCustomerName();
    }

    @PostMapping("/delete")
    public String deleteReservation(@RequestParam(name = "id") Integer id, Model model) {
        Optional<Reservation> reservation = reservationRepository
                .getReservation(id);
        if (reservation.isPresent()) {
            reservationService.deleteReservation(reservation.get().getReservationID());
            return "redirect:/customer?name=" + reservation.get().getCustomerName();
        } else {
            model.addAttribute("customer", new CustomerDto());
            return "index";
        }
    }
}
*/