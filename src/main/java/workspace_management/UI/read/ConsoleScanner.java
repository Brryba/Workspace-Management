package workspace_management.UI.read;


import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleScanner {
    private Scanner scanner;
    public ConsoleScanner() {
        this.scanner = new Scanner(System.in);
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
        System.out.println("Select workspace ID:");
        do {
            int workspaceID = readInt();
           // if (workspaceRepository.containsWorkspace(workspaceID)) {
             //   return workspaceID;
           // } else {
             //   System.err.println("No such workspace! Try again:");
            //}
        } while (true);
    }

    public String readString() {
        return scanner.nextLine();
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
}
