public final class Flying implements MovementStrategy {
    @Override
    public String name() {
        return "полёт";
    }

    @Override
    public int stepLength() {
        return 5;
    }
}
