/**
 * «Автоматизация бухгалтерии»
 * @autor Илья Смирнов
 * @version v1.1
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationActions applicationActions = new ApplicationActions();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt(); // Получаем значение от пользователя
            switch (userInput) {
                case 1:
                    case1(applicationActions);
                    break;
                case 2:
                    case2(applicationActions);
                    break;
                case 3:
                    case3(applicationActions);
                    break;
                case 4:
                    case4(applicationActions);
                    break;
                case 5:
                    case5(applicationActions);
                    break;
                case 0:
                    System.out.println("Программа завершена");
                    return;
                default:
                    System.out.println("Вы ввели несуществующее значение");
            }
        }
    }
    /**
     * "1 - Считать все месячные отчёты".
     * Происходит считывание трёх файлов из директории resources - "m.202101.csv, m.202102.csv, m.202103.csv"
     */
    public static void case1(ApplicationActions applicationActions) {
        applicationActions.clear();
        applicationActions.readMonthlyReport("resources/m.202101.csv");
        applicationActions.readMonthlyReport("resources/m.202102.csv");
        applicationActions.readMonthlyReport("resources/m.202103.csv");
    }
    /**
     * "2 - Считать все годовые отчёты".
     * Происходит считывание одного файла из директории resources - "y.2021.csv"
     */
    public static void case2(ApplicationActions applicationActions) {
        applicationActions.readYearlyReport("resources/y.2021.csv");
    }
    /**
     * "3 - Сверить отчёты".
     * Проверка на загрузку месячных и годовых отчётов.
     * Сверяет доходы и расходы по каждому месяцу с годовым отчётом.
     */
    public static void case3(ApplicationActions applicationActions) {
        applicationActions.revise();
    }
    /**
     * "4 - Вывести информацию о всех месячных отчётах".
     * Название месяца, Самый прибыльный товар (операция) и его сумма; Самая большая трата (расход) и его сумма.
     */
    public static void case4(ApplicationActions applicationActions) {
        applicationActions.printMonthlyReport();
    }
    /**
     * "5 - Вывести информацию о годовом отчёте".
     * Рассматриваемый год, Прибыль по каждому месяцу, Средний доход и средний расход за все месяцы в году.
     */
    public static void case5(ApplicationActions applicationActions) {
        applicationActions.printYearlyReport();
    }
    /**
     * Вывод главного меню
     */
    private static void printMenu() {
        System.out.println("");
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать все годовые отчёты");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выйти из приложения");
    }
}


