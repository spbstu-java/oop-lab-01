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
    // Создаём героя с начальной позицией и стратегией ходьбы.
    Hero hero = new Hero(
            "Артур",
            new Point(0, 0),
            new WalkingStrategy()
    );

    System.out.println("=== Начальное состояние ===");
    hero.printStatus();

    // Демонстрация ходьбы.
    System.out.println("\n=== Перемещение пешком ===");
    hero.move(new Point(3, 4));

    // Меняем стратегию у того же героя.
    System.out.println("\n=== Перемещение на лошади ===");
    hero.setMovementStrategy(new HorseRidingStrategy());
    hero.move(new Point(10, 8));

    // Ещё раз меняем стратегию.
    System.out.println("\n=== Полёт ===");
    hero.setMovementStrategy(new FlyingStrategy());
    hero.move(new Point(20, 15));

    // Показываем, что можно вернуться к предыдущему способу.
    System.out.println("\n=== Снова пешком ===");
    hero.setMovementStrategy(new WalkingStrategy());
    hero.move(new Point(21, 15));

    System.out.println("\n=== Итоговое состояние ===");
    hero.printStatus();
  }
}