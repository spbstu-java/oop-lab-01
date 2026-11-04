public interface MovementStrategy {
  void move(Location from, Location to);
}

class WalkingStrategy implements MovementStrategy {
  @Override
  public void move(Location from, Location to) {
    System.out.println("Walking from " + from + " to " + to);
  }
}

class HorseStrategy implements MovementStrategy {
  @Override
  public void move(Location from, Location to) {
    System.out.println("Riding a horse from " + from + " to " + to);
  }
}

class ShipStrategy implements MovementStrategy {
  @Override
  public void move(Location from, Location to) {
    System.out.println("Sailing by ship from " + from + " to " + to);
  }
}
