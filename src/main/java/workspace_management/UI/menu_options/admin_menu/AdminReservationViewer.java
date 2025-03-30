package workspace_management.UI.menu_options.admin_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.ReservationController;
import workspace_management.model.Reservation;

import java.util.List;

@Component
public class AdminReservationViewer extends AbstractOption {
    private final ReservationController reservationController;

    public AdminReservationViewer(ConsoleScanner consoleScanner, ReservationController reservationController) {
        super(consoleScanner);
        this.reservationController = reservationController;
    }

    @Override
    public void apply() {
        List<Reservation> reservations = reservationController.getAllReservations();
        if (reservations.isEmpty()) {
            System.err.println("There are no reservations");
            return;
        }
        reservations.forEach(reservation ->
                System.out.println(reservation.toStringAdmin()));
    }

    @Override
    public String getMethodName() {
        return "Show All Reservations";
    }
}
