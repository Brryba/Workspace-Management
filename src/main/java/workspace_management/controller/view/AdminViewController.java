package workspace_management.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import workspace_management.service.ReservationService;
import workspace_management.service.WorkspaceService;

@Controller
@RequestMapping("/admin")
public class AdminViewController {
    private final WorkspaceService workspaceService;
    private final ReservationService reservationService;

    public AdminViewController(WorkspaceService workspaceService, ReservationService reservationService) {
        this.workspaceService = workspaceService;
        this.reservationService = reservationService;
    }

    @GetMapping
    public String admin(Model model) {
        model.addAttribute("workspaces", workspaceService.getAllWorkspaces());
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "admin-page";
    }
}
