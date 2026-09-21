public class ConcreteStrategyHorse implements MoveStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("Герой едет на лошади из " + from + " в " + to);
    }
}
