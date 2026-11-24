public interface MovementStrategy {
    String name();

    int stepLength();

    default int move(int position, int destination) {
        int step = stepLength();
        long remaining = (long) destination - position;
        return position + Math.clamp(remaining, -step, step);
    }
}
