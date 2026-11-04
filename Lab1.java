public class Lab1 {
  public static void main(String[] args) {
    Hero hero = new Hero(new WalkingStrategy());

    System.out.println("Current location: " + hero.getLocation());

    hero.move(Location.MOUNTAIN);
    hero.move(Location.FOREST);

    hero.setMovementStrategy(new HorseStrategy());
    hero.move(Location.CASTLE);

    hero.setMovementStrategy(new ShipStrategy());
    hero.move(Location.CAMELOT);

    System.out.println("Final location: " + hero.getLocation());
  }
}
