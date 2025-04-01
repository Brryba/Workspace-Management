package workspace_management.UI.menu_options.customer_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.context.CustomerContext;
import workspace_management.UI.exception.NoWorkspacesFoundException;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.ReservationController;

import java.time.LocalDateTime;

@Component
public class ReservationMaker extends AbstractOption {
    private final ReservationController reservationController;

    public ReservationMaker(ConsoleScanner consoleScanner, ReservationController reservationController) {
        super(consoleScanner);
        this.reservationController = reservationController;
    }

    @Override
    public void apply() {
        int workspaceID;
        try {
            workspaceID = consoleScanner.readWorkspaceID(true);
        } catch (NoWorkspacesFoundException e) {
            System.err.println("No workspaces found");
            return;
        }
        System.out.println("Enter reservation start:");
        LocalDateTime startTime = consoleScanner.readDateTime();
        System.out.println("Enter reservation end:");
        LocalDateTime endTime = consoleScanner.readDateTime();
        reservationController.createReservation(CustomerContext.getCustomerName(), workspaceID, startTime, endTime);
    }

    @Override
    public String getMethodName() {
        return "Make A Reservation";
    }
}
