package service;

import java.util.Scanner;

/**
 * Класс для взаимодействия с пользователем в разделе меню.
 */
public class MenuManager {
    Scanner scanner;

    public MenuManager(Scanner scanner) {
        this.scanner = scanner;
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
    public void HandleMenuSelection() {
        int input;
        do {
            PrintMenu();
            input = GetAnswer();

            switch (input) {
                case 1:
                    System.out.println("Процесс1..");
                    break;
                case 2:
                    System.out.println("Процесс2..");
                    break;
                case 3:
                    System.out.println("Процесс3..");
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
    private void PrintMenu() {
        for (int i = 1; i <= functions.length; i++) {
            System.out.println(i + " " + functions[i - 1]);
        }
        System.out.println("Введите только ЦИФРУ выбранного пункта меню.");
    }

    /**
     * Получаем ввод пункта меню от пользователя (от 1 до кол-ва пунктов меню).
     *
     * @return номер пункта меню.
     */
    private int GetAnswer() {
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
