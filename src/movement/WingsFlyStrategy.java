package movement;

public class WingsFlyStrategy implements MoveStrategy {

    @Override
    public void move(String from, String to) {
        System.out.printf("Герой расправляет крылья и летит из «%s» в «%s» над препятствиями.%n", from, to);
    }

    @Override
    public String getName() {
        return "полёт на крыльях";
    }
}
