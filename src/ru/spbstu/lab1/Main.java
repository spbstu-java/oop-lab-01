package ru.spbstu.lab1;

import ru.spbstu.lab1.strategy.CarStrategy;
import ru.spbstu.lab1.strategy.HelicopterStrategy;
import ru.spbstu.lab1.strategy.MoveStrategy;
import ru.spbstu.lab1.strategy.TractorStrategy;
import ru.spbstu.lab1.strategy.WalkStrategy;
import ru.spbstu.lab1.strategy.YachtStrategy;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    private static final MoveStrategy[] STRATEGIES = {
            new CarStrategy(),
            new TractorStrategy(),
            new WalkStrategy(),
            new YachtStrategy(),
            new HelicopterStrategy()
    };

    public static void main(String[] args) {
        Hero hero = new Hero("Ферстаппен", new Point(0, 0), new TractorStrategy());

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println();
                System.out.println("1 - выбрать способ перемещения");
                System.out.println("2 - переместиться в точку");
                System.out.println("3 - где сейчас герой");
                System.out.println("0 - выход");

                int choice = readInt(scanner, "Выберите пункт: ");
                switch (choice) {
                    case 1 -> chooseStrategy(scanner, hero);
                    case 2 -> moveHero(scanner, hero);
                    case 3 -> System.out.println(hero.getName() + " находится в точке " + hero.getPosition()
                            + ", перемещается " + hero.getMoveStrategy().getName());
                    case 0 -> running = false;
                    default -> System.out.println("Нет такого пункта меню");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Ввод завершён");
        }
    }

    private static void chooseStrategy(Scanner scanner, Hero hero) {
        for (int i = 0; i < STRATEGIES.length; i++) {
            System.out.println((i + 1) + " - " + STRATEGIES[i].getName());
        }

        int number = readInt(scanner, "Способ перемещения: ");
        if (number < 1 || number > STRATEGIES.length) {
            System.out.println("Нет такого способа, " + hero.getName() + " по-прежнему перемещается "
                    + hero.getMoveStrategy().getName());
            return;
        }
        hero.setMoveStrategy(STRATEGIES[number - 1]);
        System.out.println("Теперь " + hero.getName() + " перемещается " + hero.getMoveStrategy().getName());
    }

    private static void moveHero(Scanner scanner, Hero hero) {
        int x = readInt(scanner, "x: ");
        int y = readInt(scanner, "y: ");
        System.out.println(hero.move(new Point(x, y)));
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Нужно ввести целое число");
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }
}
