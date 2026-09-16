import java.util.Scanner;

public class lab1 {

    static final class Point {
        final double x, y;

        Point(double x, double y) {
            this.x = x; this.y = y;
        }

        double distanceTo(Point other) {
            return Math.hypot(other.x - x, other.y - y);
        }

        @Override public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    interface MovementStrategy {
        String title();
        double speed();

        default double estimateTimeSeconds(Point from, Point to) {
            return from.distanceTo(to) / speed();
        }

        default void move(Point from, Point to) {
            double distance = from.distanceTo(to);
            double timeSec = estimateTimeSeconds(from, to);
            System.out.printf("%s: %s -> %s | dist %.2f | time ~%.1f с%n",
                    title(), from, to, distance, timeSec);
        }
    }

    enum ModeStrategy implements MovementStrategy {
        WALK ("wolking", 1.4),
        HORSE ("on horse", 1.4),
        FLY ("flying", 1.4);

        final String label;
        final double speed;

        ModeStrategy(String title, double speed) {
            this.label = title;
            this.speed = speed;
        }

        @Override public String title() { return label; }
        @Override public double speed() { return speed; }
    }

    static final class Hero {
        private MovementStrategy strategy;
        private Point position;

        public Hero(Point start, MovementStrategy strategy) {
            this.position = start;
            this.strategy = strategy;
        }

        public void setStrategy(MovementStrategy strategy) {
            this.strategy = strategy;
            System.out.println("Now for the strategy: " + strategy.title());
        }

        public void move(Point to) {
            strategy.move(position, to);
            position = to;
        }

        public Point getPosition() { return position; }
        public String getStrategyName() { return strategy.title(); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hero hero = new Hero(new Point(0, 0), ModeStrategy.WALK);

        System.out.println("Lab1");
        System.out.println("Commands: 1 — on foot, 2 — horse, 3 — fly, q — exit.");
        System.out.println("After selecting a strategy, enter the target coordinates: x y (e.g., 10 5).");

        while (true) {
            System.out.printf("%nHero point: %s | Strategy: %s%n",
                    hero.getPosition(), hero.getStrategyName());

            System.out.print("Strategy [1/2/3 or Enter — no change, q — quit]: ");
            String s = sc.nextLine().trim();

            switch(s) {
                case ("") -> { break; }
                case ("q") -> { return; }
                case ("1") -> hero.setStrategy(ModeStrategy.WALK);
                case ("2") -> hero.setStrategy(ModeStrategy.HORSE);
                case ("3") -> hero.setStrategy(ModeStrategy.FLY);
                default -> System.out.println("Unknown command — leaving the strategy unchanged.");
            }

            System.out.print("Where to go? Enter x y (Enter to exit): ");
            String line = sc.nextLine().trim();
            if (line.isEmpty())
                break;

            String[] parts = line.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Two numbers are needed: x and y. Try again.");
                continue;
            }

            try {
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                hero.move(new Point(x, y));
            } catch (NumberFormatException e) {
                System.out.println("Invalid coordinate format. Try again.");
            }
        }

        System.out.println("Finish!");
    }
}