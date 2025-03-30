package workspace_management.UI.menu_options.customer_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.scanner.ConsoleScanner;
import workspace_management.controller.ReservationController;
import workspace_management.controller.WorkspaceController;

import java.time.LocalDateTime;

@Component
public class ReservationMaker extends AbstractOption {
    private final ReservationController reservationController;
    private final WorkspaceController workspaceController;

    public ReservationMaker(ConsoleScanner consoleScanner, ReservationController reservationController, WorkspaceController workspaceController) {
        super(consoleScanner);
        this.reservationController = reservationController;
        this.workspaceController = workspaceController;
    }

    @Override
    public void apply() {
        System.out.println("Choose workspace ID:");
        int workspaceID = consoleScanner.readWorkspaceID();
        System.out.println("Choose reservation start:");
        LocalDateTime startTime = consoleScanner.readDateTime();
        System.out.println("Choose reservation end:");
        LocalDateTime endTime = consoleScanner.readDateTime();
        //controller
    }

    @Override
    public String getMethodName() {
        return "";
    }
}
