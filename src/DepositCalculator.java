import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round (pay, 2);
        //Открывающая круглая скобка у метода идет вплотную к его названию.
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale)/ scale;
        //Пробелами отделяются все бинарные операторы: + - / * % =
    }

    void calculateOutDepositAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        double outputDepositAmount = 0;
        if (action == 1) {
            outputDepositAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outputDepositAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outputDepositAmount);
        /*Длина строки в коде должна быть не более 120 символов. В 36ой строке 122 символа.
        * В notion, на эту тему, предлагаю оставлять только 100 символов в строке без переноса
        * https://www.notion.so/praktikum/CodeStyle-b23a25556911464a9908d6d5b7714a36*/
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateOutDepositAmount();
    }

    /*
    Отлично выполнено задание Code style. Учтены все правила по оформлению кода, цель задания выполнена.
    */
}