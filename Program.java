import strategies.*;

void main() {
    Scanner scanner = new Scanner(System.in);

    IO.print("Введите имя героя: ");
    String name = scanner.nextLine().trim();

    if (name.isEmpty()) {
        name = "Hero";
    }

    Hero hero = new Hero(name, new FootMoving());

    IO.println("""
            Выберите способ перемещения между точками для героя:
            1 - идти пешком
            2 - ехать на лошади
            3 - ехать на мотоцикле
            4 - ехать на автомобиле
            5 - уснуть
            """);

    boolean isRunning = true;

    while (isRunning) {
        IO.print("\nВаш выбор: ");
        String input = scanner.nextLine().trim();

        if (input.equals("5")) {
            isRunning = false;
            continue;
        }

        IMovable strategy = createStrategy(input);

        if (strategy == null) {
            IO.println("Мимо! Попробуйте еще раз");
            continue;
        }

        hero.setMovable(strategy);
        IO.println("Герой " + hero.getName() + " " + hero.move());
    }
    scanner.close();
}

private static IMovable createStrategy(String input) {
    return switch (input) {
        case "1" -> new FootMoving();
        case "2" -> new HorseMoving();
        case "3" -> new BikeMoving();
        case "4" -> new CarMoving();
        default -> null;
    };
}