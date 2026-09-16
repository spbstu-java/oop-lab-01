package Game;

interface Movement {
    abstract void execute();
}

class Walking implements Movement {
    public void execute() {
        System.out.println("Walking...");
    }
}

class Riding implements Movement {
    public void execute() {
        System.out.println("Riding...");
    }
}

class Flying implements Movement {
    public void execute() {
        System.out.println("Flying...");
    }
}