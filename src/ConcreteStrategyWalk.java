class ConcreteStrategyWalk implements MoveStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("Герой идёт пешком из " + from + " в " + to);
    }
}

