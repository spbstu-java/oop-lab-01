package movement;

public class HorseRideStrategy implements MoveStrategy {

    @Override
    public void move(String from, String to) {
        System.out.printf("Герой скачет на лошади из «%s» в «%s». Путь пройден быстро.%n", from, to);
    }

    @Override
    public String getName() {
        return "на лошади";
    }
}
