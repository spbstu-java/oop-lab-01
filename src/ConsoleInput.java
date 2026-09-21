import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            if (line == null) {
                System.out.println("Ввод недоступен.");
                continue;
            }
            line = line.trim();
            if (line.isEmpty()) {
                System.out.printf("Введите целое число от %d до %d.%n", min, max);
                continue;
            }
            try {
                int value = Integer.parseInt(line);
                if (value < min || value > max) {
                    System.out.printf("Число должно быть от %d до %d.%n", min, max);
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Нужно целое число, а не «" + line + "».");
            }
        }
    }

    public String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            if (line == null) {
                System.out.println("Ввод недоступен.");
                continue;
            }
            line = line.trim();
            if (line.isEmpty()) {
                System.out.println("Строка не может быть пустой.");
                continue;
            }
            return line;
        }
    }
}
