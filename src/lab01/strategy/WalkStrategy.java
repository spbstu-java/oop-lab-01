package lab01.strategy;

import lab01.Point;

/** Перемещение пешком. */
public class WalkStrategy implements MovementStrategy {

    @Override
    public String getName() {
        return "Пешком";
    }

    @Override
    public void move(Point from, Point to) {
        System.out.println("Идёт пешком из " + from + " в " + to + ".");
    }
}