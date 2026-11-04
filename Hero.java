public class Hero {
  private Location location;
  private MovementStrategy movementStrategy;

  public Hero(MovementStrategy movementStrategy) {
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
    movementStrategy.move(location, destination);
    location = destination;
  }
}
