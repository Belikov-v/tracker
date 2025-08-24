package service;

import java.util.Scanner;

/**
 * Класс реализующий основную функциональность связанную с
 * трекером шагов, реализует интерфейс StepTracker (данные хранятся во внутренней памяти).
 */
public class InMemoryStepTracker implements StepTracker {

    // Отображение: порядковый номер месяца -> данные по месяцу
    private final MonthData[] monthToData;

    private final Scanner scanner;

    // Ежедневная цель количества шагов
    private int goal = 10000;

    public InMemoryStepTracker(Scanner scanner) {
        this.scanner = scanner;
        monthToData = new MonthData[12];
        for (int i = 0; i < 12; i++) {
            monthToData[i] = new InMemoryMonthData();
        }
    }

    /**
     * Установить количество шагов в заданный день.
     */
    @Override
    public void setSteps() {
        int month = getMonth() - 1;
        int day = getDay() - 1;
        int steps = getSteps();
        monthToData[month].setSteps(day, steps);
    }

    /**
     * Установить ежедневную цель по количеству шагов в день.
     */
    @Override
    public void setGoal() {
        goal = getGoal();
    }

    /**
     * Показать статистику пользователя за выбранный месяц.
     */
    @Override
    public void showStats() {
        int monthId = getMonth();
        MonthData month = monthToData[monthId - 1];
        System.out.println("Статистика за " + monthId + " месяц:");
        for (int i = 1; i <= 30; i++) {
            System.out.println(i + " день: " + month.getSteps(i - 1));
        }
        System.out.println("Общее кол-во шагов за месяц - " + month.getTotalSteps());
        System.out.println("Максимальное кол-во шагов за месяц - " + month.getMaxSteps());
        System.out.println("Лучшая серия кол-ва шагов за месяц - " + month.getBestStreak(goal));
    }

    // Запрашивает у пользователя порядковый номер месяца
    private int getMonth() {
        int month;
        while (true) {
            System.out.println("Введите порядковый номер месяца(1-12):");
            month = getPositiveNumberFromUser();
            if (month > 0 && month <= 12) {
                return month;
            }
            System.out.println("Некорректные данные.");
        }
    }

    // Запрашивает у пользователя порядковый номер дня
    private int getDay() {
        int day;
        while (true) {
            System.out.println("Введите порядковый номер дня(1-30):");
            day = getPositiveNumberFromUser();
            if (day > 0 && day <= 30) {
                return day;
            }
            System.out.println("Некорректные данные.");
        }
    }

    // Запрашивает у пользователя количество шагов
    private int getSteps() {
        int steps;
        while (true) {
            System.out.println("Введите количество шагов:");
            steps = getPositiveNumberFromUser();
            if (steps > 0) {
                return steps;
            }
            System.out.println("Некорректные данные.");
        }
    }

    // Запрашивает у пользователя цель по количеству шагов
    private int getGoal() {
        int goal;
        while (true) {
            System.out.println("Введите цель количества шагов за день:");
            goal = getPositiveNumberFromUser();
            if (goal > 0) {
                return goal;
            }
            System.out.println("Некорректные данные.");
        }
    }

    // Запрашивает у пользователя положительное число, если введеные данные некорректны, возвращает -1
    private int getPositiveNumberFromUser() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.next();
            return -1;
        }
    }
}
