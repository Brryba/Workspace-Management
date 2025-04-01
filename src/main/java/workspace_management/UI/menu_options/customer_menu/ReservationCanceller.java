package workspace_management.UI.menu_options.customer_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.context.CustomerContext;
import workspace_management.UI.exception.NoReservationsFoundException;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.ReservationController;

@Component
public class ReservationCanceller extends AbstractOption {
    private final ReservationController reservationController;

    public ReservationCanceller(ConsoleScanner consoleScanner, ReservationController reservationController) {
        super(consoleScanner);
        this.reservationController = reservationController;
    }

    @Override
    public void apply() {
        System.out.println("Enter reservation ID to cancel");
        int reservationID;
        try {
            reservationID = consoleScanner.readReservationID(CustomerContext.getCustomerName());
        } catch (NoReservationsFoundException e) {
            System.err.println("There are no reservations found");
            return;
        }
        reservationController.deleteReservation(reservationID);
    }

    @Override
    public String getMethodName() {
        return "Cancel a Reservation";
    }
}
