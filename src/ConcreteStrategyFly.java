public class ConcreteStrategyFly implements MoveStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("Герой летит на драконе из " + from + " в " + to);
    }
}
