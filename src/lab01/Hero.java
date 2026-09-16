package lab01;

import lab01.strategy.MovementStrategy;

/**
 * Герой игры. Умеет перемещаться между двумя точками,
 * при этом способ перемещения (стратегия) может быть выбран и
 * изменён в ходе выполнения программы.
 */
public class Hero {

    private final String name;
    private MovementStrategy strategy;

    public Hero(String name, MovementStrategy strategy) {
        this.name = name;
        setStrategy(strategy);
    }

    /** Позволяет выбрать или сменить способ перемещения в любой момент. */
    public void setStrategy(MovementStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Стратегия перемещения не может быть null.");
        }
        this.strategy = strategy;
    }

    public MovementStrategy getStrategy() {
        return strategy;
    }

    /** Перемещает героя между двумя точками выбранным способом. */
    public void move(Point from, Point to) {
        System.out.print(name + " ");
        strategy.move(from, to);
    }
}