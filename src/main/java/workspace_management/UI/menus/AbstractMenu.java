package workspace_management.UI.menus;

import org.springframework.stereotype.Component;
import workspace_management.UI.menu_options.AbstractOption;
import workspace_management.UI.read.ConsoleScanner;

import java.util.LinkedHashMap;

@Component
public abstract class AbstractMenu
        implements MethodsMenu {
    private ConsoleScanner consoleScanner;

    public AbstractMenu(ConsoleScanner consoleScanner) {
        this.consoleScanner = consoleScanner;
    }

    public static final int QUIT_MENU_METHOD = 0;
    protected final LinkedHashMap<Integer, AbstractOption> map = new LinkedHashMap<>();
    protected abstract void setMethods();

    public void apply() {
        this.setMethods();
        this.showMenu();
    }

    private void printAllMethods() {
        for (int key : map.keySet()) {
            System.out.println(key + " - " + map.get(key).getMethodName());
        }
    }

    private int selectMethod() {
        System.out.println("Enter your option here:");
        int methodID;
        do {
            methodID = consoleScanner.readInt();
            if (!this.map.containsKey(methodID)) {
                System.err.println("No such option. Try again:");
            }
        } while (!this.map.containsKey(methodID));
        return methodID;
    }

    public void addMethod(int methodID, AbstractOption method) {
        this.map.put(methodID, method);
    }

    @Override
    public void showMenu() {
        int methodID;
        do {
            printAllMethods();
            methodID = selectMethod();
            map.get(methodID).apply();
        } while (methodID != QUIT_MENU_METHOD);
    }
}