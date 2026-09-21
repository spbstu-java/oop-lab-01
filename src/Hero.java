class Hero {

    private MoveStrategy moveStrategy;

    public Hero() {
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void moveStr(String from, String to) {
        moveStrategy.move(from, to);
    }
}
