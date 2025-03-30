package workspace_management.UI.menus;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.main_menu.AdminMenuSelector;
import workspace_management.UI.menu_options.update_menu.AvailabilityUpdater;
import workspace_management.UI.menu_options.update_menu.PriceUpdater;
import workspace_management.UI.menu_options.update_menu.TypeUpdater;
import workspace_management.UI.menu_options.update_menu.UpdateMenuCloser;
import workspace_management.UI.scanner.ConsoleScanner;

@Component
public class WorkspaceUpdateMenu extends AbstractMenu {
    private int workspaceID;
    private final UpdateMenuCloser updateMenuCloser;
    private final TypeUpdater typeUpdater;
    private final PriceUpdater priceUpdater;
    private final AvailabilityUpdater availabilityUpdater;

    public WorkspaceUpdateMenu(ConsoleScanner consoleScanner, UpdateMenuCloser updateMenuCloser, TypeUpdater typeUpdater, PriceUpdater priceUpdater, AvailabilityUpdater availabilityUpdater) {
        super(consoleScanner);
        this.updateMenuCloser = updateMenuCloser;
        this.typeUpdater = typeUpdater;
        this.priceUpdater = priceUpdater;
        this.availabilityUpdater = availabilityUpdater;
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
        this.addMethod(AbstractMenu.QUIT_MENU_METHOD, updateMenuCloser);
    }
}
