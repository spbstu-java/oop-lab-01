
public class Hero {
    private Point position;
    private MovementStrategy movementStrategy;

    public Hero(Point startPosition, MovementStrategy movementStrategy) {
        this.position = startPosition;
        this.movementStrategy = movementStrategy;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        if (movementStrategy == null) {
            throw new IllegalArgumentException("Стратегия перемещения не должна быть null.");
        }
        this.movementStrategy = movementStrategy;
    }

    public void move(Point destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Точка назначения не должна быть null.");
        }

        movementStrategy.move(position, destination);
        position = destination;
        System.out.println("Текущая позиция героя: " + position);
    }

    public Point getPosition() {
        return position;
    }
}
