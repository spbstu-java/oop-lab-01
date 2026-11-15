import java.util.Scanner;

public class Lab1 {
  public static void main(String[] args) {
    LocationGraph graph = createGraph();
    Hero hero = new Hero(new WalkingStrategy(), graph);
    Location destination = Location.CAMELOT;

    System.out.println("Default strategy: walking");
    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        destination = handleInput(scanner, hero, graph, destination);
        if (destination == null) {
          return;
        }
      }
    }
  }

  private static LocationGraph createGraph() {
    LocationGraph graph = new LocationGraph();
    graph.connect(Location.VILLAGE, Location.MOUNTAIN, ConnectionType.ROAD);
    graph.connect(Location.MOUNTAIN, Location.FOREST, ConnectionType.ROAD);
    graph.connect(Location.FOREST, Location.CASTLE, ConnectionType.ROAD);
    graph.connect(Location.CASTLE, Location.CAMELOT, ConnectionType.WATER);
    return graph;
  }

  private static Location handleInput(
      Scanner scanner,
      Hero hero,
      LocationGraph graph,
      Location destination) {
    System.out.println("\nCurrent location: " + hero.getLocation());
    System.out.println("1 - Walk");
    System.out.println("2 - Ride a horse");
    System.out.println("3 - Sail by ship");
    System.out.println(destination == Location.VILLAGE ? "g - Return to village" : "g - Begin adventure");
    System.out.println("q - Exit");
    System.out.print("Choose: ");
    if (!scanner.hasNextLine()) {
      return null;
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
        destination = travel(hero, graph, destination);
        break;
      case "q":
        return null;
      default:
        System.out.println("Wrong input 😑");
    }
    return destination;
  }

  private static Location travel(Hero hero, LocationGraph graph, Location destination) {
    while (hero.getLocation() != destination) {
      Location before = hero.getLocation();
      Location next = graph.getNextStep(before, destination);

      if (next != null) {
        hero.move(next);
      } else {
        break;
      }

      if (hero.getLocation() == before) {
        break;
      }
    }

    if (hero.getLocation() == destination) {
      return switchDestination(destination);
    }

    return destination;
  }

  private static Location switchDestination(Location destination) {
    return destination == Location.CAMELOT ? Location.VILLAGE : Location.CAMELOT;
  }
}
