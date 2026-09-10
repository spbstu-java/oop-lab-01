import java.util.Scanner;
void main() {
    Scanner scanner = new Scanner(System.in);
    Hero hero = new Hero(new Walk());
    while (true) {
        System.out.println("\nвыберите способ перемещения:");
        System.out.println("1 — идти пешком");
        System.out.println("2 — бежать");
        System.out.println("3 — ехать на лошади");
        System.out.println("4 — лететь");
        System.out.println("0 — выйти");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                hero.setMovement(new Walk());
                break;
            case "2":
                hero.setMovement(new Run());
                break;
            case "3":
                hero.setMovement(new Ride());
                break;
            case "4":
                hero.setMovement(new Fly());
                break;
            case "0":
                scanner.close();
                return;
            default:
                System.out.println("введите число от 0 до 4");
                continue;
        }
        hero.move();
    }

}
public class Hero
{
    private Movement movement;
    public Hero(Movement movement) {
        this.movement = movement;
    }
    public void setMovement(Movement movement) {
        this.movement = movement;
    }
    public void move() {
        movement.move();
    }
}
public interface Movement {
    public void move();
}
public class Run implements Movement {
    @Override
    public void move() {
        System.out.println("герой бежит");
    }
}
public class Walk implements Movement {
    @Override
    public void move() {
        System.out.println("герой идет пешком");
    }
}
public class Ride implements Movement {
    @Override
    public void move() {
        System.out.println("герой едет верхом");
    }
}
public class Fly implements Movement {
    @Override
    public void move() {
        System.out.println("герой летит");
    }
}