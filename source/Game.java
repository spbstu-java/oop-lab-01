package Game;
import java.util.Scanner;

public class Game {

    private static void movementTypeSelector(Scanner in, Hero hero){
        System.out.println("\nSelect movement type:");
        System.out.println("1 - Walking");
        System.out.println("2 - Riding");
        System.out.println("3 - Flying");
        if (in.hasNextInt())
        {
            int movement_type = in.nextInt();
            switch (movement_type){
                case 1:
                    hero.setMovement(new Walking());
                    break;
                case 2:
                    hero.setMovement(new Riding());
                    break;
                case 3:
                    hero.setMovement(new Flying());
                    break;
                default:
                    movementTypeSelector(in, hero);
            }
        }
        else{
            System.out.println("Ошибка! Введите число.");
            in.nextLine();
            movementTypeSelector(in, hero);
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
            if (in.hasNextInt())
            {
                int action_type = in.nextInt();
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
            else{
                System.out.println("Ошибка! Введите число.");
                in.nextLine();
            }
        }
    }
}