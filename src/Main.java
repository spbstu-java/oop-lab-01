import java.util.Objects;
import java.util.Scanner;

// Точка на игровой карте.
class Point {
  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof Point)) {
      return false;
    }

    Point other = (Point) object;
    return x == other.x && y == other.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}

// Общий интерфейс всех способов перемещения.
interface MovementStrategy {
  void move(String heroName, Point from, Point to);

  String getName();
}

// Конкретная стратегия: ходьба.
class WalkingStrategy implements MovementStrategy {
  @Override
  public void move(String heroName, Point from, Point to) {
    System.out.printf(
            "%s идёт пешком из %s в %s.%n",
            heroName, from, to
    );
  }

  @Override
  public String getName() {
    return "Пешком";
  }
}

// Конкретная стратегия: езда на лошади.
class HorseRidingStrategy implements MovementStrategy {
  @Override
  public void move(String heroName, Point from, Point to) {
    System.out.printf(
            "%s едет на лошади из %s в %s.%n",
            heroName, from, to
    );
  }

  @Override
  public String getName() {
    return "На лошади";
  }
}

// Конкретная стратегия: полёт.
class FlyingStrategy implements MovementStrategy {
  @Override
  public void move(String heroName, Point from, Point to) {
    System.out.printf(
            "%s летит из %s в %s.%n",
            heroName, from, to
    );
  }

  @Override
  public String getName() {
    return "Полёт";
  }
}

// Контекст: герой использует стратегию через общий интерфейс.
class Hero {
  private final String name;
  private Point position;
  private MovementStrategy movementStrategy;

  public Hero(
          String name,
          Point position,
          MovementStrategy movementStrategy
  ) {
    this.name = Objects.requireNonNull(name);
    this.position = Objects.requireNonNull(position);
    setMovementStrategy(movementStrategy);
  }

  // Смена поведения во время выполнения программы.
  public void setMovementStrategy(MovementStrategy movementStrategy) {
    this.movementStrategy = Objects.requireNonNull(
            movementStrategy,
            "Стратегия перемещения не может быть null"
    );
  }

  public void move(Point destination) {
    Objects.requireNonNull(destination);

    if (position.equals(destination)) {
      System.out.println("Герой уже находится в этой точке.");
      return;
    }

    // Герой не знает, какой именно способ перемещения выбран.
    movementStrategy.move(name, position, destination);
    position = destination;
  }

  public void printStatus() {
    System.out.println("Герой: " + name);
    System.out.println("Позиция: " + position);
    System.out.println(
            "Способ перемещения: " + movementStrategy.getName()
    );
  }
}

public class Main {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      Hero hero = new Hero(
              "Артур",
              new Point(0, 0),
              new WalkingStrategy()
      );

      boolean running = true;

      while (running) {
        System.out.println("\n=== Управление героем ===");
        hero.printStatus();

        System.out.println("\n1. Выбрать ходьбу");
        System.out.println("2. Выбрать езду на лошади");
        System.out.println("3. Выбрать полёт");
        System.out.println("4. Переместиться");
        System.out.println("0. Выход");

        int choice = readInt(scanner, "Ваш выбор: ");

        switch (choice) {
          case 1:
            hero.setMovementStrategy(new WalkingStrategy());
            System.out.println("Выбран способ: пешком.");
            break;

          case 2:
            hero.setMovementStrategy(new HorseRidingStrategy());
            System.out.println("Выбран способ: на лошади.");
            break;

          case 3:
            hero.setMovementStrategy(new FlyingStrategy());
            System.out.println("Выбран способ: полёт.");
            break;

          case 4:
            int x = readInt(scanner, "Координата X: ");
            int y = readInt(scanner, "Координата Y: ");
            hero.move(new Point(x, y));
            break;

          case 0:
            running = false;
            System.out.println("Программа завершена.");
            break;

          default:
            System.out.println("Неизвестный пункт меню.");
        }
      }
    }
  }

  private static int readInt(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);

      if (!scanner.hasNextLine()) {
        System.out.println("\nВвод завершён.");
        System.exit(0);
      }

      String input = scanner.nextLine().trim();

      try {
        return Integer.parseInt(input);
      } catch (NumberFormatException exception) {
        System.out.println("Ошибка: введите целое число.");
      }
    }
  }
}