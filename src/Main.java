import java.io.Console;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public final class Main {
    private static final MovementStrategy WALKING = new Walking();
    private static final MovementStrategy HORSE_RIDING = new HorseRiding();
    private static final MovementStrategy FLYING = new Flying();
    private static final int PROGRESS_WIDTH = 20;

    public static void main(String[] args) {
        Console console = System.console();
        Charset charset = console == null ? StandardCharsets.UTF_8 : console.charset();
        try (Scanner input = new Scanner(System.in, charset)) {
            run(input);
        }
    }

    private static void run(Scanner input) {
        Integer start = readPoint(input, "Введите начальную координату");
        if (start == null) {
            return;
        }

        Hero hero = new Hero(start, WALKING);
        while (true) {
            Integer destination = readPoint(input, "Введите координату цели");
            if (destination == null || !travel(input, hero, destination)) {
                return;
            }
        }
    }

    private static boolean travel(Scanner input, Hero hero, int destination) {
        int start = hero.getPosition();
        System.out.println("1 — шаг пешком | 2 — шаг на лошади | 3 — шаг в полёте");
        System.out.println("Enter — шаг текущим способом | 0 — выход");

        while (true) {
            showProgress(hero, start, destination);
            if (hero.getPosition() == destination) {
                System.out.println("Герой достиг цели.");
                return true;
            }

            System.out.print("Команда > ");
            if (!input.hasNextLine()) {
                return false;
            }

            switch (input.nextLine().strip()) {
                case "" -> {}
                case "1" -> hero.setMovementStrategy(WALKING);
                case "2" -> hero.setMovementStrategy(HORSE_RIDING);
                case "3" -> hero.setMovementStrategy(FLYING);
                case "0" -> {
                    return false;
                }
                default -> {
                    System.out.println("Нажмите Enter или введите 0, 1, 2 или 3.");
                    continue;
                }
            }
            hero.move(destination);
        }
    }

    private static void showProgress(Hero hero, int start, int destination) {
        int position = hero.getPosition();
        long totalDistance = Math.abs((long) destination - start);
        long remaining = Math.abs((long) destination - position);
        int filled = totalDistance == 0
                ? PROGRESS_WIDTH
                : (int) ((totalDistance - remaining) * PROGRESS_WIDTH / totalDistance);
        MovementStrategy strategy = hero.getMovementStrategy();

        System.out.printf("%n[%s%s] %d → %d | Позиция %d | Осталось %d%n",
                "#".repeat(filled), "-".repeat(PROGRESS_WIDTH - filled),
                start, destination, position, remaining);
        System.out.printf("Способ: %s (до %d ед. за шаг)%n", strategy.name(), strategy.stepLength());
    }

    private static Integer readPoint(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt + " (Enter — выход) > ");
            if (!input.hasNextLine()) {
                return null;
            }

            String point = input.nextLine().strip();
            if (point.isEmpty()) {
                return null;
            }

            try {
                return Integer.parseInt(point);
            } catch (NumberFormatException exception) {
                System.out.println("Введите целое число от " + Integer.MIN_VALUE + " до " + Integer.MAX_VALUE + ".");
            }
        }
    }
}
