
public class Main {
    public static void main(String[] args) {

        var menu = new Menu(
                new Hero[] {
                        new Hero("Герой 1"),
                        new Hero("Герой 2", new RunMove())
                },
                new IMovable[] {
                        new WalkMove(),
                        new RunMove(),
                        new FlyMove()
                }
        );


        menu.showBaseMenu();
    }
}