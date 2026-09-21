package movement;

public class WalkStrategy implements MoveStrategy {

    @Override
    public void move(String from, String to) {
        System.out.printf("Герой идёт пешком из «%s» в «%s». Это медленно, зато бесплатно.%n", from, to);
    }

    @Override
    public String getName() {
        return "пешком";
    }
}
