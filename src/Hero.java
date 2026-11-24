import java.util.Objects;

public final class Hero {
    private int position;
    private MovementStrategy movementStrategy;

    public Hero(int position, MovementStrategy movementStrategy) {
        this.position = position;
        setMovementStrategy(movementStrategy);
    }

    public int getPosition() {
        return position;
    }

    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = Objects.requireNonNull(movementStrategy, "Нужна стратегия перемещения");
    }

    public void move(int destination) {
        position = movementStrategy.move(position, destination);
    }
}
