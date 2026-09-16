package lab01.strategy;

import lab01.Point;

/** Перемещение по воздуху. */
public class FlyStrategy implements MovementStrategy {

    @Override
    public String getName() {
        return "Полёт";
    }

    @Override
    public void move(Point from, Point to) {
        System.out.println("Летит из " + from + " в " + to + ".");
    }
}