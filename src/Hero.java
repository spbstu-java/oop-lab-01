import movement.MoveStrategy;

public class Hero {

    private String name;
    private MoveStrategy moveStrategy;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move(String from, String to) {
        if (moveStrategy == null) {
            System.out.println("Сначала выберите способ перемещения.");
            return;
        }
        System.out.printf("%s (%s): ", name, moveStrategy.getName());
        moveStrategy.move(from, to);
    }
}
