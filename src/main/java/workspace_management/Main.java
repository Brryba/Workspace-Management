package workspace_management;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import workspace_management.UI.menus.MainMenu;
import workspace_management.config.SpringConfig;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        MainMenu mainMenu = context.getBean(MainMenu.class);
        mainMenu.apply();
    }
}