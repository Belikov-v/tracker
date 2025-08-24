import service.InMemoryStepTracker;
import service.MenuManager;
import service.StepTracker;

import java.util.Scanner;

/**
 * Класс с точкой входа.
 */
public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new InMemoryStepTracker(scanner);
        MenuManager menuManager = new MenuManager(scanner, stepTracker);
        menuManager.handleMenuSelection();
    }
}
