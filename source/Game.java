package Game;
import java.util.Scanner;

public class Game {

    private static void movementTypeSelector(Scanner in, Hero hero){
        System.out.println("\nSelect movement type:");
        System.out.println("1 - Walking");
        System.out.println("2 - Riding");
        System.out.println("3 - Flying");
        int movement_type = Integer.parseInt(in.nextLine());
        switch (movement_type){
            case 1:
                hero.setMovement(new Walking());
                break;
            case 2:
                hero.setMovement(new Riding());
                break;
            case 3:
                hero.setMovement(new Flying());
        }
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        Scanner in = new Scanner(System.in);
        movementTypeSelector(in, hero);
        boolean flag = true;
        while(flag){
            System.out.println("\nSelect action:");
            System.out.println("1 - Set movement type");
            System.out.println("2 - Move hero");
            System.out.println("3 - Exit");
            int action_type = Integer.parseInt(in.nextLine());
            switch (action_type){
                case 1:
                    movementTypeSelector(in, hero);
                    break;
                case 2:
                    hero.move();
                    break;
                case 3:
                    flag = false;
            }
        }
    }
}