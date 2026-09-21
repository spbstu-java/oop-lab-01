import movement.HorseRideStrategy;
import movement.MoveStrategy;
import movement.PigRideStrategy;
import movement.WalkStrategy;
import movement.WingsFlyStrategy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleInput input = new ConsoleInput(scanner);
            Hero hero = new Hero("Безымянный");
            runMenu(hero, input);
        }
    }

    private static void runMenu(Hero hero, ConsoleInput input) {
        System.out.println("Лабораторная 1: перемещение героя (паттерн Strategy)");
        boolean running = true;
        while (running) {
            printStatus(hero);
            printMenu();
            int choice = input.readInt("Выберите пункт меню: ", 0, 3);
            switch (choice) {
                case 1:
                    hero.setName(input.readNonEmpty("Имя героя: "));
                    System.out.println("Имя обновлено.");
                    break;
                case 2:
                    chooseStrategy(hero, input);
                    break;
                case 3:
                    moveHero(hero, input);
                    break;
                case 0:
                    running = false;
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Неизвестный пункт меню.");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Задать имя героя");
        System.out.println("2. Выбрать способ перемещения");
        System.out.println("3. Переместиться между точками");
        System.out.println("0. Выход");
    }

    private static void printStatus(Hero hero) {
        System.out.println();
        String strategyName = hero.getMoveStrategy() == null
                ? "не выбран"
                : hero.getMoveStrategy().getName();
        System.out.printf("Герой: %s | Способ: %s%n", hero.getName(), strategyName);
    }

    private static void chooseStrategy(Hero hero, ConsoleInput input) {
        System.out.println();
        System.out.println("Способы перемещения:");
        System.out.println("1. Пешком");
        System.out.println("2. На лошади");
        System.out.println("3. На свинье");
        System.out.println("4. Полёт на крыльях");
        int choice = input.readInt("Выберите способ: ", 1, 4);
        MoveStrategy strategy;
        switch (choice) {
            case 1:
                strategy = new WalkStrategy();
                break;
            case 2:
                strategy = new HorseRideStrategy();
                break;
            case 3:
                strategy = new PigRideStrategy();
                break;
            case 4:
                strategy = new WingsFlyStrategy();
                break;
            default:
                System.out.println("Такого способа нет.");
                return;
        }
        hero.setMoveStrategy(strategy);
        System.out.println("Выбран способ: " + strategy.getName() + ".");
    }

    private static void moveHero(Hero hero, ConsoleInput input) {
        if (hero.getMoveStrategy() == null) {
            System.out.println("Сначала выберите способ перемещения (пункт 2).");
            return;
        }
        String from = input.readNonEmpty("Откуда: ");
        String to = input.readNonEmpty("Куда: ");
        hero.move(from, to);
    }
}
