package Game;
import java.util.Scanner;



public class Game {
    public static void main(String[] args) {
        Hero hero = new Hero();
        Movement[] movement = {new Walking(), new Riding(), new Flying()};

        for (int i = 0; i < movement.length; i++){
            hero.setMovement(movement[i]);
            hero.move();
        }
    }
}