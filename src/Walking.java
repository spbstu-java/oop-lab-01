public final class Walking implements MovementStrategy {
    @Override
    public String name() {
        return "пешком";
    }

    @Override
    public int stepLength() {
        return 1;
    }
}
