import service.MenuManager;

import java.util.Scanner;

/**
 * Класс с точкой входа.
 */
public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuManager menuManager = new MenuManager(scanner);
        menuManager.handleMenuSelection();
    }
}
