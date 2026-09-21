package com.example.lab1;

import com.example.lab1.model.Hero;
import com.example.lab1.model.Point;
import com.example.lab1.strategy.FlyMovementStrategy;
import com.example.lab1.strategy.HorseMovementStrategy;
import com.example.lab1.strategy.WalkMovementStrategy;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Hero hero = new Hero("Игрок", new Point(0, 0));
        hero.setStrategy(new WalkMovementStrategy());

        boolean running = true;
        while (running)
        {
            printMenu();
            int choice = readInt(scanner, "Выберите действие: ");

            switch (choice)
            {
                case 1:
                    hero.setStrategy(new WalkMovementStrategy());
                    System.out.println("Способ перемещения: ходьба");
                    break;
                case 2:
                    hero.setStrategy(new HorseMovementStrategy());
                    System.out.println("Способ перемещения: езда на лошади");
                    break;
                case 3:
                    hero.setStrategy(new FlyMovementStrategy());
                    System.out.println("Способ перемещения: полет");
                    break;
                case 4:
                    moveHero(scanner, hero);
                    break;
                case 5:
                    System.out.println(hero);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("ошибка");
            }
        }

        scanner.close();
    }

    private static void moveHero(Scanner scanner, Hero hero)
    {
        int x = readInt(scanner, "Введите x: ");
        int y = readInt(scanner, "Введите y: ");
        hero.move(new Point(x, y));
    }

    private static void printMenu()
    {
        System.out.println();
        System.out.println("1. Ходьба");
        System.out.println("2. Езда на лошади");
        System.out.println("3. Полет");
        System.out.println("4. Переместить героя");
        System.out.println("5. Показать позицию");
        System.out.println("6. Выход");
    }

    private static int readInt(Scanner scanner, String prompt)
    {
        System.out.print(prompt);
        while (!scanner.hasNextInt())
        {
            System.out.println("введите число");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }
}
