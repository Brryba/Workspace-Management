package workspace_management.UI.menus;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.customer_menu.AvailableSpacesShower;
import workspace_management.UI.menu_options.customer_menu.CustomerReservationViewer;
import workspace_management.UI.menu_options.customer_menu.ReservationCanceller;
import workspace_management.UI.menu_options.customer_menu.ReservationMaker;
import workspace_management.UI.menu_options.main_menu.MainMenuSelector;
import workspace_management.UI.read.ConsoleScanner;

@Component
public class CustomerMenu extends AbstractMenu {
    private AvailableSpacesShower availableSpacesShower;
    private CustomerReservationViewer customerReservationViewer;
    private ReservationCanceller reservationCanceller;
    private ReservationMaker reservationMaker;
    private MainMenuSelector mainMenuSelector;

    public CustomerMenu(ConsoleScanner consoleScanner, AvailableSpacesShower availableSpacesShower, CustomerReservationViewer customerReservationViewer, ReservationCanceller reservationCanceller, ReservationMaker reservationMaker, MainMenuSelector mainMenuSelector) {
        super(consoleScanner);
        this.availableSpacesShower = availableSpacesShower;
        this.customerReservationViewer = customerReservationViewer;
        this.reservationCanceller = reservationCanceller;
        this.reservationMaker = reservationMaker;
        this.mainMenuSelector = mainMenuSelector;
    }

    @Override
    protected void setMethods() {
        this.addMethod(1, availableSpacesShower);
        this.addMethod(2, customerReservationViewer);
        this.addMethod(3, reservationMaker);
        this.addMethod(4, reservationCanceller);
        this.addMethod(QUIT_MENU_METHOD, mainMenuSelector);
    }
}