import java.util.Scanner;

public class Main {
    static Calc calc = new Calc();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение через пробел. Строки вводятся в двойных кавычках :");

        try {
            StringBuilder[] sb = split(scanner.nextLine());
            String result = resultat(sb, calc);
            if (result.length() < 40) {
                System.out.println("Результат: " + result);
            } else {
                System.out.println("Результат: " + result.substring(0, 41) + "...\"");
            }
        } catch (Exception e) {
            throw new Exception("Вы ввели неверное значение!");
        }
    }

    public static String resultat(StringBuilder[] sb, Calc calculator) {
        return switch (sb[2].toString()) {
            case "+" -> calculator.sum(sb[0], sb[1]);
            case "-" -> calculator.sub(sb[0], sb[1]);
            case "*" -> calculator.mul(sb[0], Integer.parseInt(sb[1].toString()));
            case "/" -> calculator.div(sb[0], Integer.parseInt(sb[1].toString()));
            default -> null;
        };
    }

    public static StringBuilder[] split(String splinted) {
        String[] sb = new String[2];
        StringBuilder[] newSB = new StringBuilder [3];
        String operator = "";
        if (splinted.contains("+")) {
            sb = splinted.split(" [+] ");
            operator = "+";
        } else if (splinted.contains("-")) {
            sb = splinted.split(" [-] ");
            operator = "-";
        } else if (splinted.contains("*")) {
            sb = splinted.split(" [*] ");
            operator = "*";
        } else if (splinted.contains("/")) {
            sb = splinted.split(" [/] ");
            operator = "/";
        }
        newSB[0] = new StringBuilder(sb[0]);
        newSB[1] = new StringBuilder(sb[1]);
        newSB[2] = new StringBuilder(operator);
        return newSB;
    }
}