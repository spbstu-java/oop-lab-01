public final class HorseRiding implements MovementStrategy {
    @Override
    public String name() {
        return "на лошади";
    }

    @Override
    public int stepLength() {
        return 3;
    }
}
