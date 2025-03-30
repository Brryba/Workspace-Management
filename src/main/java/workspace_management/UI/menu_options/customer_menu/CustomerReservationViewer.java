package workspace_management.UI.menu_options.customer_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.ReservationController;

@Component
public class CustomerReservationViewer extends AbstractOption {
    private final ReservationController reservationController;

    public CustomerReservationViewer(ConsoleScanner consoleScanner, ReservationController reservationController) {
        super(consoleScanner);
        this.reservationController = reservationController;
    }

    @Override
    public void apply() {
        //controller
    }

    @Override
    public String getMethodName() {
        return "";
    }
}
