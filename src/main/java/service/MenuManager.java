package service;

import java.util.Scanner;

/**
 * Класс для взаимодействия с пользователем в разделе меню.
 */
public class MenuManager {
    Scanner scanner;
    StepTracker stepTracker;

    public MenuManager(Scanner scanner, StepTracker stepTracker) {
        this.scanner = scanner;
        this.stepTracker = stepTracker;
    }

    // Пункты меню.
    private final String[] functions = {
            "Ввести количество шаго за день.",
            "Изменить цель по количеству шагов за день.",
            "Показать статистику за месяц.",
            "Выход."
    };

    /**
     * Метод, отоброжающий меню, запрашивающий ввод
     * пользователя и впоследвие вызывающий необходимый сервис.
     */
    public void handleMenuSelection() {
        int input;
        do {
            printMenu();
            input = getAnswer();

            switch (input) {
                case 1:
                    stepTracker.setSteps();
                    break;
                case 2:
                    stepTracker.setGoal();
                    break;
                case 3:
                    stepTracker.showStats();
                    break;
                case 4:
                    System.out.println("Выход...");
                    break;
                default:
                    System.out.println("Неверная команда.");
            }
        } while (input != functions.length);
    }

    // Отображает пункты меню.
    private void printMenu() {
        for (int i = 1; i <= functions.length; i++) {
            System.out.println(i + " " + functions[i - 1]);
        }
        System.out.println("Введите только ЦИФРУ выбранного пункта меню.");
    }

    // Получаем пункт меню от пользователя.
    private int getAnswer() {
        int input;
        try {
            input = scanner.nextInt();
            if (input > 0 && input <= functions.length) {
                return input;
            } else {
                return 0;
            }
        } catch (Exception e) {
            scanner.next();
            return 0;
        }
    }
}
