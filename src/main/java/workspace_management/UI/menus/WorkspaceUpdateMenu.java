package workspace_management.UI.menus;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.main_menu.AdminMenuSelector;
import workspace_management.UI.menu_options.update_menu.AvailabilityUpdater;
import workspace_management.UI.menu_options.update_menu.PriceUpdater;
import workspace_management.UI.menu_options.update_menu.TypeUpdater;
import workspace_management.UI.read.ConsoleScanner;

@Component
public class WorkspaceUpdateMenu extends AbstractMenu {
    private int workspaceID;
    private AdminMenuSelector adminMenuSelector;
    private TypeUpdater typeUpdater;
    private PriceUpdater priceUpdater;
    private AvailabilityUpdater availabilityUpdater;
    public WorkspaceUpdateMenu(ConsoleScanner consoleScanner) {
        super(consoleScanner);
    }

    public int getWorkspaceID() {
        return workspaceID;
    }

    public void setWorkspaceID(int workspaceID) {
        this.workspaceID = workspaceID;
    }

    @Override
    protected void setMethods() {
        // DO USE ID with this menu selector;
        this.addMethod(1, typeUpdater);
        this.addMethod(2, priceUpdater);
        this.addMethod(3, availabilityUpdater);
        this.addMethod(AbstractMenu.QUIT_MENU_METHOD, adminMenuSelector);
    }
}
