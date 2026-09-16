package lab01.strategy;

import lab01.Point;

/**
 * Стратегия перемещения героя.
 * Каждая реализация определяет свой способ попасть из точки from в точку to.
 */
public interface MovementStrategy {

    /**
     * Человекочитаемое название способа перемещения.
     *
     * @return имя стратегии
     */
    String getName();

    /**
     * Перемещает героя между двумя точками.
     *
     * @param from точка отправления
     * @param to   точка назначения
     */
    void move(Point from, Point to);
}