import java.util.Scanner;

public class Lab1 {
  private static final Location[] PATH = {
      Location.VILLAGE, Location.MOUNTAIN, Location.FOREST, Location.CASTLE, Location.CAMELOT
  };

  public static void main(String[] args) {
    Hero hero = new Hero(new WalkingStrategy());
    boolean atEnd = false;

    System.out.println("Default strategy: walking");
    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        System.out.println("\nCurrent location: " + hero.getLocation());
        System.out.println("1 - Walk");
        System.out.println("2 - Ride a horse");
        System.out.println("3 - Sail by ship");
        System.out.println(atEnd ? "g - Return to village" : "g - Begin adventure");
        System.out.println("q - Exit");
        System.out.print("Choose: ");
        if (!scanner.hasNextLine()) {
          return;
        }

        String choice = scanner.nextLine().trim();
        System.out.print("\033[H\033[2J");
        System.out.flush();

        switch (choice) {
          case "1":
            hero.setMovementStrategy(new WalkingStrategy());
            System.out.println("Strategy: walking");
            break;
          case "2":
            hero.setMovementStrategy(new HorseStrategy());
            System.out.println("Strategy: horse");
            break;
          case "3":
            hero.setMovementStrategy(new ShipStrategy());
            System.out.println("Strategy: ship");
            break;
          case "g":
            int step = atEnd ? -1 : 1;
            for (int i = atEnd ? PATH.length - 2 : 1; i >= 0 && i < PATH.length; i += step) {
              hero.move(PATH[i]);
            }
            atEnd = !atEnd;
            break;
          case "q":
            return;
          default:
            System.out.println("Wrong input 😑");
        }
      }
    }
  }
}
