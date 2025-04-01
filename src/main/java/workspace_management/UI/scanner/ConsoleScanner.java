package workspace_management.UI.scanner;


import org.springframework.stereotype.Component;
import workspace_management.UI.exception.NoReservationsFoundException;
import workspace_management.UI.exception.NoWorkspacesFoundException;
import workspace_management.controller.ReservationController;
import workspace_management.controller.WorkspaceController;
import workspace_management.model.Reservation;
import workspace_management.model.Workspace;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleScanner {
    private final WorkspaceController workspaceController;
    private final ReservationController reservationController;
    private final String dateTimeFormat = "dd-MM-yyyy HH:mm:ss";
    private final DateTimeFormatter dateTimeFormatter
            = DateTimeFormatter.ofPattern(dateTimeFormat);
    private final Scanner scanner;

    public ConsoleScanner(WorkspaceController workspaceController, ReservationController reservationController) {
        this.scanner = new Scanner(System.in);
        this.workspaceController = workspaceController;
        this.reservationController = reservationController;
    }

    public int readInt() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException exception) {
                System.err.println("Please type a number. Try again:");
            }
        }
    }

    public int readWorkspaceID(boolean requireAvailable) throws NoWorkspacesFoundException {
        List<Workspace> workspaces = requireAvailable ? workspaceController.getAvailableWorkspaces()
                : workspaceController.getAllWorkspaces();
        if (workspaces.isEmpty()) {
            throw new NoWorkspacesFoundException();
        }

        workspaces.forEach(System.out::println);
        System.out.println("Select workspace ID:");
        do {
            int workspaceID = readInt();
            Workspace workspace = workspaceController.getWorkspace(workspaceID);
            if (workspace != null) {
                return workspaceID;
            } else {
                System.err.println("No such workspace! Try again:");
            }
        } while (true);
    }

    public int readReservationID(String userName) throws NoReservationsFoundException {
        List<Reservation> reservations = reservationController.getReservations(userName);
        if (reservations.isEmpty()) {
            throw new NoReservationsFoundException();
        }

        reservations.forEach(System.out::println);
        System.out.println("Select reservation ID:");
        do {
            int reservationID = readInt();
            boolean contains = reservations.stream()
                    .map(Reservation::getReservationID)
                    .anyMatch(r -> r == reservationID);
            if (contains) {
                return reservationID;
            } else {
                System.err.println("No such reservation! Try again:");
            }
        } while (true);
    }

    public String readString() {
        return scanner.nextLine();
    }

    public boolean readBoolean() {
        String input;
        System.out.println("Enter true or false: ");
        do {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("true")) {
                return true;
            } else if (input.equalsIgnoreCase("false")) {
                return false;
            }
        } while (true);
    }

    public double readDouble() {
        double input;
        while (true) {
            try {
                input = Double.parseDouble(scanner.nextLine());
                return input;
            } catch (NumberFormatException exception) {
                System.err.println("Please type a number. Try again:");
            }
        }
    }

    public LocalDateTime readDateTime() {
        System.out.println("Enter the date as " + dateTimeFormat + ":");
        do {
            String input = scanner.nextLine();
            try {
                return LocalDateTime.parse(input, dateTimeFormatter);
            } catch (DateTimeParseException exception) {
                System.err.println("Please type a valid date. Try again:");
            }
        } while (true);
    }
}
