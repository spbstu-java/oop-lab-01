public class Hero {
    private final String name;
    private IMovable moveStrategy;

    public Hero(String name)
    {
        this(name, new WalkMove());
    }

    public Hero(String name, IMovable moveStrategy)
    {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void changeMovable(IMovable moveStrategy)
    {
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        System.out.println(name + " - " + moveStrategy.move());
    }
}
