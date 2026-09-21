package movement;

public class PigRideStrategy implements MoveStrategy {

    @Override
    public void move(String from, String to) {
        System.out.printf("Герой едет на свинье из «%s» в «%s». Свинья хрюкает, но довозит.%n", from, to);
    }

    @Override
    public String getName() {
        return "на свинье";
    }
}
