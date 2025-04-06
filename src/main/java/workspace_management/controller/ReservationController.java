package workspace_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import workspace_management.controller.view.CustomerViewController;
import workspace_management.dto.ReservationDto;
import workspace_management.dto.customer.CustomerDto;
import workspace_management.model.Reservation;
import workspace_management.repository.ReservationRepository;
import workspace_management.service.ReservationService;

import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final CustomerViewController customerController;
    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationService reservationService, CustomerViewController customerController, ReservationRepository reservationRepository) {
        this.reservationService = reservationService;
        this.customerController = customerController;
        this.reservationRepository = reservationRepository;
    }

    @PostMapping("/new")
    public String createReservation(@ModelAttribute ReservationDto reservation, Model model, BindingResult bindingResult) {
        reservationService.createNewReservation(reservation);
        return "redirect:/customer?name=" + reservation.getCustomerName();
    }

    @PostMapping("/delete")
    public String deleteReservation(@RequestParam(name = "id") Integer id, Model model) {
        String customerName = reservationRepository
                .getReservation(id).orElse(null).getCustomerName();
        reservationService.deleteReservation(id);
        return "redirect:/customer?name=" + customerName;
    }
}
