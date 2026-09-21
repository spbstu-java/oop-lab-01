import java.util.Scanner;

public class Main {
    public static void main() {

        Hero hero = new Hero();
        Scanner scanner = new Scanner(System.in);
        boolean work = true;
        String from, to;

        System.out.println("Выберите и введите способ передвижения героя:" +
                "1 - идёт пешком; 2 - едет на лошади; 3 - летит на драконе;" +
                "4 - плывёт на лодке; 5 - плывёт на плоте; 6 - выход.");

        while(work) {
            switch(scanner.nextLine()) {
                case "1":
                    hero.setMoveStrategy(new ConcreteStrategyWalk());
                    from = "леса";
                    to = "домой";
                    break;
                case "2":
                    hero.setMoveStrategy(new ConcreteStrategyHorse());
                    from = "замка";
                    to = "поле";
                    break;
                case "3":
                    hero.setMoveStrategy(new ConcreteStrategyFly());
                    from = "башни";
                    to = "город";
                    break;
                case "4":
                    hero.setMoveStrategy(new ConcreteStrategyBoatRiver());
                    from = "долины островов";
                    to = "большой мир";
                    break;
                case "5":
                    hero.setMoveStrategy(new ConcreteStrategyRaftLake());
                    from = "острова";
                    to = "причалу";
                    break;
                case "6":
                    work = false;
                    System.out.println("Герой добрался до места назначения!");
                    continue;
                default:
                    System.out.println("Такой вариант отсутствует! Попробуйте снова:)");
                    continue;
            }
            hero.moveStr(from, to);
        }
    }
}
