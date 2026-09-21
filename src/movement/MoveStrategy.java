package movement;

public interface MoveStrategy {

    void move(String from, String to);

    String getName();
}
