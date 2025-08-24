package service;

import java.util.Arrays;

/**
 * Класс хранит информацию о количестве шагов пользователя за месяц,
 * а также содержит следующие методы:
 * <ul>
 *     <li>Ввод количества шагов за определённый день;</li>
 *     <li>Получение общего количества шагов за месяц;</li>
 *     <li>Поиск лучшей серии дней, когда цель по шагам выполнена;</li>
 * </ul>
 */
public class MonthData {

    // Массив со статистикой шагов.
    private final int[] days = new int[30];

    /**
     * Установить количество шагов в конкретный день.
     *
     * @param day   порядковый номер дня.
     * @param steps количество шагов.
     */
    public void setSteps(int day, int steps) {
        days[day - 1] = steps;
    }

    /**
     * Получить количество шагов за конкретный день.
     *
     * @param day порядковый номер дня.
     * @return количество шагов за день.
     */
    public int getSteps(int day) {
        return days[day - 1];
    }

    /**
     * Получить общее количество шагов месяц.
     *
     * @return общее количество шагов месяц.
     */
    public int getTotalSteps() {
        return Arrays.stream(days).sum();
    }

    /**
     * Получить максимальное количество шагов месяц.
     *
     * @return максимальное количество шагов месяц.
     */
    public int getMaxSteps() {
        int max = 0;
        for (int steps : days) {
            max = Math.max(steps, max);
        }
        return max;
    }

    /**
     * Получить лучшую серию шагов за месяц.
     *
     * @return количество дней.
     */
    public int getBestStreak(int goal) {
        int maxPeriod = 0;

        int l = 0, r = 0;
        while (r < days.length) {
            if (days[r] >= goal) {
                maxPeriod = Math.max(r - l + 1, maxPeriod);
                r += 1;
            } else {
                r += 1;
                l = r;
            }
        }
        return maxPeriod;
    }
}
