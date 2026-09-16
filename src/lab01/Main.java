package lab01;

import lab01.strategy.FlyStrategy;
import lab01.strategy.MovementStrategy;
import lab01.strategy.RideHorseStrategy;
import lab01.strategy.WalkStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Интерактивная демонстрация паттерна "Стратегия".
 * Пользователь сам выбирает и меняет способ перемещения героя во время работы программы.
 */
public class Main {

    public static void main(String[] args) {
        List<MovementStrategy> strategies = new ArrayList<>();
        strategies.add(new WalkStrategy());
        strategies.add(new RideHorseStrategy());
        strategies.add(new FlyStrategy());

        Hero hero = new Hero("Роман", strategies.get(0));

        Point[] route = {
                new Point(0, 0),   // деревня
                new Point(5, 3),   // город
                new Point(12, 8),  // замок
                new Point(20, 25)  // гора
        };

        try (Scanner scanner = new Scanner(System.in, "UTF-8")) {
            int step = 0;
            while (step < route.length - 1) {
                Point from = route[step];
                Point to = route[step + 1];

                System.out.println("Сейчас герой в точке " + from + ", следующий пункт: " + to + ".");
                System.out.println("Текущая стратегия: " + hero.getStrategy().getName());
                System.out.println("Выберите способ перемещения:");
                for (int i = 0; i < strategies.size(); i++) {
                    System.out.println("  " + (i + 1) + ". " + strategies.get(i).getName());
                }
                System.out.println("  0. Выход");
                System.out.print("Ваш выбор: ");

                int choice = readChoice(scanner, strategies.size());
                if (choice == 0) {
                    System.out.println("Программа завершена.");
                    return;
                }
                
                hero.setStrategy(strategies.get(choice - 1));
                hero.move(from, to);
                System.out.println();
                step++;
            }
        }

        System.out.println("Путь пройден. Текущая стратегия героя: " + hero.getStrategy().getName());
    }

    /**
     * Читает выбор пользователя, гарантируя корректный ввод.
     * Буквы и числа вне диапазона отбрасываются, запрос повторяется, исключений не возникает.
     *
     * @param scanner сканер, из которого читается ввод
     * @param max     максимальное допустимое значение
     * @return корректное число от 0 до max включительно
     */
    private static int readChoice(Scanner scanner, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // сбрасываем буфер после числа
                if (value >= 0 && value <= max) {
                    return value;
                }
            } else {
                scanner.nextLine(); // отбрасываем нечисловой ввод (например, букву)
            }
            System.out.println("Некорректный ввод. Введите целое число от 0 до " + max + ".");
            System.out.print("Ваш выбор: ");
        }
    }
}