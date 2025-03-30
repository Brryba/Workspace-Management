package workspace_management.UI.menu_options.customer_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.ReservationController;
import workspace_management.model.Reservation;

import java.util.List;

@Component
public class CustomerReservationViewer extends AbstractOption {
    private final ReservationController reservationController;

    public CustomerReservationViewer(ConsoleScanner consoleScanner, ReservationController reservationController) {
        super(consoleScanner);
        this.reservationController = reservationController;
    }

    @Override
    public void apply() {
        List<Reservation> reservations = reservationController.getAllReservations();
        if (reservations.isEmpty()) {
            System.err.println("No reservations found");
        }

        reservations.forEach(System.out::println);
    }

    @Override
    public String getMethodName() {
        return "Show My Reservations";
    }
}
