import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationActions applicationActions = new ApplicationActions();

        while (true) {
            printMenu(); // Выводим меню
            int userInput = scanner.nextInt(); // Получаем значение от пользователя
            switch (userInput) {
                case 1:
                    case1(applicationActions);
                    break;
                case 2:
                    case2(applicationActions);
                    break;
                case 3:
//                    case3(applicationActions);
//                    break;
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

    public static void case1(ApplicationActions applicationActions) {
        applicationActions.readMonthlyReport("resources/m.202101.csv");
        applicationActions.readMonthlyReport("resources/m.202102.csv");
        applicationActions.readMonthlyReport("resources/m.202103.csv");
    }

    public static void case2(ApplicationActions applicationActions) {
        applicationActions.readYearlyReport("resources/y.2021.csv");
    }

    public static void case4(ApplicationActions applicationActions) {
        applicationActions.printMonthlyReport();
    }

    public static void case5(ApplicationActions applicationActions) {
        applicationActions.printYearlyReport();
    }

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


