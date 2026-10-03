import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        boolean isContinue = true;
        while (isContinue) {
            showMenu();
            String option = sc.nextLine();
            switch (option) {
                case "end":
                    isContinue = false;
                    break;
                case "1":
                    System.out.println("Введите сумму дохода:");
                    String moneyStrEarnings =  sc.nextLine(); // Не используйте тут nextInt (!)
                    int moneyEarnings = Integer.parseInt(moneyStrEarnings);
                    earnings += moneyEarnings;
                    break;
                case "2":
                    System.out.println("Введите сумму расхода");
                    String moneyStrSpendings =  sc.nextLine(); // Не используйте тут nextInt (!)
                    int money = Integer.parseInt(moneyStrSpendings);
                    spendings += money;
                    break;
                case "3":
                    shooseTaxSistem(earnings, spendings);
                    break;
                default:
                    System.out.println("такой команды нет");
            }
        }
    }
    private static void shooseTaxSistem(int earnings, int spendings) {
        int tax6 = calculateSimpleTax(earnings);
        int tax15 = calculateComplex(earnings, spendings);
        if (tax6 == tax15) {
            System.out.println("Выбирите любую систему налогооблажения");
            System.out.printf("Ваш налог составит: " + tax6 + " рублей");
        } else {
            
            int minTax = Math.min(tax15, tax6);
            int maxTax = Math.max(tax15, tax6);
            String taxSystem = (tax6 < tax15) ? "УСН доходы" : "УСН доходы-расходы";
            System.out.println("Мы советуем Вам" + taxSystem);
            System.out.printf("Ваш налог составит: %d рублей\n", minTax);
            System.out.printf("Ваш налог по другой системе налогооблажения составит:%d рублей\n", maxTax);
            System.out.printf("Экономия составит: %d рублей\n", maxTax - minTax);
            // System.out.println("Ваш налог по другой системе налогооблажения составит:%d рублей\\n\", maxTax");
        }
    }
    private static int calculateSimpleTax(int earnings) {
        return (earnings * 6 / 100);
    }
    private static int calculateComplex(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        return (tax > 0) ? tax : 0;
    }
    private static void showMenu() {
        System.out.println(
                "Выберите операция и вставьте ее номер\n " +
                        "1.Добавить доход\n" +
                        "2.Добавить расход\n" +
                        "3.Вставить систему налооблажения\n" +
                        "end.Закончить");
    }
}