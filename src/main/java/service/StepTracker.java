package service;

public interface StepTracker {
    /**
     * Установить количество шагов в заданный день.
     */
    void setSteps();
    /**
     * Установить ежедневную цель по количеству шагов в день.
     */
    void setGoal();
    /**
     * Показать статистику пользователя за выбранный месяц.
     */
    void showStats();
}
