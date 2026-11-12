
public class WalkStrategy implements MovementStrategy {
    @Override
    public void move(Point from, Point to) {
        System.out.println("Герой идет пешком из " + from + " в " + to + ".");
    }
}
