package workspace_management.UI.context;

public class CustomerContext {
    private static String customerName;

    public static String getCustomerName() {
        return customerName;
    }

    public static void setCustomerName(String newUserName) {
        customerName = newUserName;
    }
}
