package workspace_management.UI.menu_options.customer_menu;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.read.ConsoleScanner;
import workspace_management.controller.ReservationController;
import workspace_management.controller.WorkspaceController;

@Component
public class ReservationMaker extends AbstractOption {
    private ReservationController reservationController;
    private WorkspaceController workspaceController;

    public ReservationMaker(ConsoleScanner consoleScanner, ReservationController reservationController, WorkspaceController workspaceController) {
        super(consoleScanner);
        this.reservationController = reservationController;
        this.workspaceController = workspaceController;
    }

    @Override
    public void apply() {
        System.out.println("Choose workspace ID:");
        int workspaceID = consoleScanner.readWorkspaceID();
        System.out.println("Choose reservation start date:");

        System.out.println("Choose reservation end date:");
    }

    @Override
    public String getMethodName() {
        return "";
    }
}
