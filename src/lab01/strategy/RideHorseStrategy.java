package lab01.strategy;

import lab01.Point;

/** Перемещение верхом на лошади. */
public class RideHorseStrategy implements MovementStrategy {

    @Override
    public String getName() {
        return "Верхом на лошади";
    }

    @Override
    public void move(Point from, Point to) {
        System.out.println("Едет на лошади из " + from + " в " + to + ".");
    }
}