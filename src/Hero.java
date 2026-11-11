import java.util.Objects;

public class Hero {
    private MovementStrategy strategy;

    public Hero(MovementStrategy strategy) {
        setMovementStrategy(strategy);
    }

    public void setMovementStrategy(MovementStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }

    public String move() {
        return strategy.move();
    }
}
