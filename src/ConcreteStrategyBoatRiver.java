public class ConcreteStrategyBoatRiver implements MoveStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("Герой плывёт по реке на лодке из " + from + " в " + to);
    }
}
