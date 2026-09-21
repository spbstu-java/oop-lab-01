import java.util.Scanner;

public class Menu {

    private final Hero[] heroes;
    private final IMovable[] movables;
    public Hero selected;
    public String lastExecutedActionMsg;

    public Menu(Hero[] heroes, IMovable[] movables)
    {
        this.heroes = heroes;
        this.movables = movables;
    }

    public void showBaseMenu()
    {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            clear();

            System.out.println("Текущий герой: " + (selected == null ? "<не выбран>" : selected.GetName()));
            System.out.println("1 - Выбрать героя");
            System.out.println("2 - Выбрать действие");
            System.out.println("3 - Выполнить действие");
            System.out.println("q - Выход");
            System.out.println("-----------------------------");
            System.out.println("Последнее действие: " + (lastExecutedActionMsg == null ? "" : lastExecutedActionMsg));
            System.out.println("-----------------------------");
            System.out.print("Ввод:");

            isRunning = handleInput(sc);
        }
    }

    public boolean handleInput(Scanner sc)
    {
        String input = sc.nextLine().trim().toLowerCase();

        switch (input) {
            case "1" -> selectHeroMenu(sc);
            case "2" -> selectAction(sc);
            case "3" -> executeAction(sc);
            case "q" -> {
                return false;
            }
            default -> {
                System.out.println("Неизвестная команда: " + input);
                pause(sc);
            }
        }

        return  true;
    }


    private void selectHeroMenu(Scanner sc)
    {
        String[] names = new String[heroes.length];
        for (int i = 0; i < heroes.length; i++)
            names[i] = heroes[i].GetName();

        int index = chooseIndex(sc, "Текущий герой: " + (selected == null ? "<не выбран>" : selected.GetName()), names);
        if (index != -1)
            selected = heroes[index];
    }


    void selectAction(Scanner sc)
    {
        if (selected == null)
        {
            System.out.println("Необходимо выбрать героя, перед выбором действия!");
            pause(sc);
            return;
        }

        String[] actions = new String[movables.length];
        for (int i = 0; i < movables.length; i++)
        {
            actions[i] = movables[i].move();
        }

        int index = chooseIndex(sc, "Действие героя: " + selected.move(), actions);
        if (index != -1)
        {
            selected.changeMovable(movables[index]);
        }
    }


    void executeAction(Scanner sc) {

        if (selected == null) {
            System.out.println("Сначала выберите героя!");
            pause(sc);
            return;
        }

        lastExecutedActionMsg = selected.GetName() + " " + selected.move();
    }


    private int chooseIndex(Scanner sc, String header, String[] items) {
        while (true) {
            clear();
            System.out.println(header);
            for (int i = 0; i < items.length; i++) {
                System.out.println(i + " - " + items[i]);
            }
            System.out.println("b - Назад");
            System.out.println("-----------------------------");
            System.out.print("Ввод:");

            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("b")) return -1;

            try {
                int index = Integer.parseInt(input);
                if (index >= 0 && index < items.length) return index;
                System.out.println("Нет пункта с номером " + index);
            } catch (NumberFormatException e) {
                System.out.println("Введите номер или b");
            }
            pause(sc);
        }
    }



    public  static void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pause(Scanner sc) {
        System.out.println("Нажмите Enter, чтобы продолжить...");
        sc.nextLine();
    }
}
