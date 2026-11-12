
public class HorseStrategy implements MovementStrategy {
    @Override
    public void move(Point from, Point to) {
        System.out.println("Герой скачет на лошади из " + from + " в " + to + ".");
    }
}
