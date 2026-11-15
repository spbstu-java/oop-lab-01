public interface MovementStrategy {
  boolean move(Location from, Location to, LocationGraph graph);
}

class WalkingStrategy implements MovementStrategy {
  @Override
  public boolean move(Location from, Location to, LocationGraph graph) {
    if (graph.getConnectionType(from, to) != ConnectionType.ROAD) {
      System.out.println("Cannot walk from " + from + " to " + to);
      System.out.println("Choose another strategy.");
      return false;
    }
    System.out.println("Walking from " + from + " to " + to);
    return true;
  }
}

class HorseStrategy implements MovementStrategy {
  @Override
  public boolean move(Location from, Location to, LocationGraph graph) {
    if (graph.getConnectionType(from, to) != ConnectionType.ROAD) {
      System.out.println("Cannot ride from " + from + " to " + to);
      System.out.println("Choose another strategy.");
      return false;
    }
    System.out.println("Riding a horse from " + from + " to " + to);
    return true;
  }
}

class ShipStrategy implements MovementStrategy {
  @Override
  public boolean move(Location from, Location to, LocationGraph graph) {
    if (graph.getConnectionType(from, to) != ConnectionType.WATER) {
      System.out.println("Cannot sail from " + from + " to " + to);
      System.out.println("Choose another strategy.");
      return false;
    }
    System.out.println("Sailing by ship from " + from + " to " + to);
    return true;
  }
}
