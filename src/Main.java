import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hero hero = new Hero(new Point(0, 0), new WalkingStrategy());

        while (true) {
            System.out.println("\nТекущая позиция героя: " + hero.getPosition());
            System.out.println("Выберите способ перемещения:");
            System.out.println("1 - пешком");
            System.out.println("2 - на лошади");
            System.out.println("3 - полёт");
            System.out.println("0 - выход");

            int choice = readInt(scanner);

            if (choice == 0) {
                break;
            }

            MovementStrategy strategy;

            switch (choice) {
                case 1:
                    strategy = new WalkingStrategy();
                    break;
                case 2:
                    strategy = new HorseRidingStrategy();
                    break;
                case 3:
                    strategy = new FlyingStrategy();
                    break;
                default:
                    System.out.println("Неизвестный способ перемещения.");
                    continue;
            }

            hero.setMovementStrategy(strategy);

            System.out.print("Введите координату X: ");
            int x = readInt(scanner);

            System.out.print("Введите координату Y: ");
            int y = readInt(scanner);

            hero.move(new Point(x, y));
        }

        System.out.println("Итоговая позиция героя: " + hero.getPosition());

        scanner.close();
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите целое число.");
            scanner.next();
        }

        return scanner.nextInt();
    }
}
