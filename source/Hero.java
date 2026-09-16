package Game;

class Hero {
    private Movement movement;

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public void move() {
        this.movement.execute();
    }
}