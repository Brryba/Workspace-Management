package workspace_management.UI.menu_options.admin_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.service.ReservationService;

@Component
public class AdminReservationViewer extends AbstractOption {
    private final ReservationService reservationService;

    public AdminReservationViewer(ConsoleScanner consoleScanner, ReservationService reservationService) {
        super(consoleScanner);
        this.reservationService = reservationService;
    }

    @Override
    public void apply() {
        //reservationsService.show();
    }

    @Override
    public String getMethodName() {
        return "Show All Reservations";
    }
}
