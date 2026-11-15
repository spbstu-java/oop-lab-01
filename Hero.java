public class Hero {
  private final LocationGraph graph;
  private Location location;
  private MovementStrategy movementStrategy;

  public Hero(MovementStrategy movementStrategy, LocationGraph graph) {
    this.graph = graph;
    this.location = Location.VILLAGE;
    this.movementStrategy = movementStrategy;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public void setMovementStrategy(MovementStrategy movementStrategy) {
    this.movementStrategy = movementStrategy;
  }

  public void move(Location destination) {
    if (movementStrategy.move(location, destination, graph)) {
      location = destination;
    }
  }
}
