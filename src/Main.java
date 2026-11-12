import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hero hero = new Hero(new Point(0, 0), new WalkStrategy());

        System.out.println("Лабораторная работа № 1. Паттерн «Стратегия»");
        System.out.println("Герой создан. Начальная позиция: " + hero.getPosition());

        boolean running = true;

        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 — идти пешком");
            System.out.println("2 — ехать на лошади");
            System.out.println("3 — лететь");
            System.out.println("4 — переместить героя");
            System.out.println("0 — завершить программу");
            System.out.print("Ваш выбор: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите номер пункта меню.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hero.setMovementStrategy(new WalkStrategy());
                    System.out.println("Выбрана стратегия: пешком.");
                    break;
                case 2:
                    hero.setMovementStrategy(new HorseStrategy());
                    System.out.println("Выбрана стратегия: на лошади.");
                    break;
                case 3:
                    hero.setMovementStrategy(new FlyStrategy());
                    System.out.println("Выбрана стратегия: полет.");
                    break;
                case 4:
                    System.out.print("Введите координату X точки назначения: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Ошибка: координата должна быть целым числом.");
                        scanner.nextLine();
                        break;
                    }
                    int x = scanner.nextInt();

                    System.out.print("Введите координату Y точки назначения: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Ошибка: координата должна быть целым числом.");
                        scanner.nextLine();
                        break;
                    }
                    int y = scanner.nextInt();

                    hero.move(new Point(x, y));
                    break;
                case 0:
                    running = false;
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Такого пункта нет. Выберите 0, 1, 2, 3 или 4.");
            }
        }

        scanner.close();
    }
}
