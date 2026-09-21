public class ConcreteStrategyRaftLake implements MoveStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("Герой плывёт на плоту с " + from + " к " + to);
    }
}
