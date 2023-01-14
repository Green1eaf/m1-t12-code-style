import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, int period) {
        return makeRound(amount * Math.pow((1 + 0.06 / 12), 12 * period));
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        return makeRound(amount + amount * 0.06 * depositPeriod);
    }

    double makeRound(double value) {
        double scale = Math.pow(10, 2);

        return Math.round(value * scale) / scale;
    }

    void run() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double depositResult = 0;

        if (action == 1) {
            depositResult = calculateSimplePercent(amount, period);
        } else if (action == 2) {
            depositResult = calculateComplexPercent(amount, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositResult);
    }

    public static void main(String[] args) {
        new DepositCalculator().run();
    }
}
