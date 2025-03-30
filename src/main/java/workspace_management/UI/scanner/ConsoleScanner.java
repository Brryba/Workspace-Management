package workspace_management.UI.scanner;


import org.springframework.stereotype.Component;
import workspace_management.controller.ReservationController;
import workspace_management.controller.WorkspaceController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@Component
public class ConsoleScanner {
    private final WorkspaceController workspaceController;
    private final ReservationController reservationController;
    private static final DateTimeFormatter dateTimeFormat
            = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
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

    public int readWorkspaceID() {
        workspaceController.getAllWorkspaces()
                .ifPresentOrElse(workspaces -> workspaces.forEach(System.out::println),
                        () -> System.out.println("Workspace not found"));

        System.out.println("Select workspace ID:");
        do {
            int workspaceID = readInt();
            if (workspaceController.containsWorkspace(workspaceID)) {
                return workspaceID;
            } else {
                System.err.println("No such workspace! Try again:");
            }
        } while (true);
    }

    public int readReservationID() {
        System.out.println("Select reservation ID:");
        do {
            int reservationID = readInt();

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
                return LocalDateTime.parse(input, dateTimeFormat);
            } catch (DateTimeParseException exception) {
                System.err.println("Please type a valid date. Try again:");
            }
        } while (true);
    }
}
