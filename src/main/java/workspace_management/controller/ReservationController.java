package workspace_management.controller;

import org.springframework.stereotype.Controller;
import workspace_management.model.Reservation;
import workspace_management.service.ReservationService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void createReservation(String customerName, int workspaceID, LocalDateTime startDate, LocalDateTime endDate) {
        reservationService.createNewReservation(customerName, workspaceID,
                startDate, endDate);
    }

    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    public List<Reservation> getReservations(String customerName) {
        return reservationService.getReservations(customerName);
    }

    public void deleteReservation(int reservationID) {
        reservationService.deleteReservation(reservationID);
    }
}
