import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, MovementStrategy> strategies = Map.of(
                "1", new Walking(),
                "2", new HorseRiding(),
                "3", new Flying()
        );
        Hero hero = new Hero(strategies.get("1"));

        System.out.println("1. Пешком");
        System.out.println("2. На лошади");
        System.out.println("3. Полёт");
        System.out.println("0. Выход");

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                if (!input.hasNextLine()) {
                    break;
                }

                String choice = input.nextLine().strip();
                if (choice.equals("0")) {
                    break;
                }

                MovementStrategy strategy = strategies.get(choice);
                if (strategy == null) {
                    System.out.println("Выбери число от 0 до 3.");
                    continue;
                }

                hero.setMovementStrategy(strategy);
                System.out.println(hero.move());
            }
        }
    }
}
