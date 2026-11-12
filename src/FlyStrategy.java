
public class FlyStrategy implements MovementStrategy {
    @Override
    public void move(Point from, Point to) {
        System.out.println("Герой летит из " + from + " в " + to + ".");
    }
}
