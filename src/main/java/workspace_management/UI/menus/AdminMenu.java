package workspace_management.UI.menus;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.admin_menu.AdminReservationViewer;
import workspace_management.UI.menu_options.admin_menu.UpdateMenuSelector;
import workspace_management.UI.menu_options.admin_menu.WorkspaceCreator;
import workspace_management.UI.menu_options.admin_menu.WorkspaceRemover;
import workspace_management.UI.menu_options.main_menu.MainMenuSelector;
import workspace_management.UI.read.ConsoleScanner;

@Component
public class AdminMenu extends AbstractMenu {
    private final AdminReservationViewer adminReservationViewer;
    private final UpdateMenuSelector updateMenuSelector;
    private final WorkspaceCreator workspaceCreator;
    private final WorkspaceRemover workspaceRemover;
    private final MainMenuSelector mainMenuSelector;

    public AdminMenu(ConsoleScanner consoleScanner, AdminReservationViewer adminReservationViewer, UpdateMenuSelector updateMenuSelector, WorkspaceCreator workspaceCreator, WorkspaceRemover workspaceRemover, MainMenuSelector mainMenuSelector) {
        super(consoleScanner);
        this.adminReservationViewer = adminReservationViewer;
        this.updateMenuSelector = updateMenuSelector;
        this.workspaceCreator = workspaceCreator;
        this.workspaceRemover = workspaceRemover;
        this.mainMenuSelector = mainMenuSelector;
    }

    @Override
    protected void setMethods() {
        this.addMethod(1, adminReservationViewer);
        this.addMethod(2, workspaceCreator);
        this.addMethod(3, updateMenuSelector);
        this.addMethod(4, workspaceRemover);
        this.addMethod(AbstractMenu.QUIT_MENU_METHOD, mainMenuSelector);
    }
}