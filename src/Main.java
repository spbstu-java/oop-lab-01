
public class Main {
    public static void main(String[] args) {
        var hero1 = new Hero("Герой 1");
        var hero2 = new Hero("Герой 2", new RunMove());

        hero1.move();
        hero2.move();

        hero1.changeMovable(new FlyMove());
        hero2.changeMovable(new WalkMove());

        hero1.move();
        hero2.move();
    }
}