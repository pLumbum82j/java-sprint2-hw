import java.lang.reflect.Array;
import java.util.ArrayList;

public class Statistics {
    int expense, maxSum;
    String itemName, month;

    // Статистика по месячным отчётам
    public void calcMaxSumIncome(ArrayList<MonthlyReport> monthlyReports) { // доход
        System.out.println("Самая прибыльная операция");
        for (MonthlyReport report : monthlyReports) {
            maxSum = 0;
            itemName = "";
            month = "";
            for (Record record : report.records) {
                if (!record.is_expense) { // Вывести только FALSE
                    expense = 0;
                    expense += record.quantity * record.sum_of_one; // Вычислить доход
                    if (maxSum < expense) { // Вычисляем наибольший доход
                        maxSum = expense;
                        itemName = record.item_name;
                        month = record.monthName;
                    }
                }
            }
            System.out.println("За " + month + ": " + itemName + " на сумму " + maxSum);
        }
    }
    public void calcMaxSumExpense(ArrayList<MonthlyReport> monthlyReports) { // расход
        System.out.println("Самая большой расход");
        for (MonthlyReport report : monthlyReports) {
            maxSum = 0;
            itemName = "";
            month = "";
            for (Record record : report.records) {
                if (record.is_expense) { // Вывести только TRUE
                    expense = 0;
                    expense += record.quantity * record.sum_of_one; // Вычислить расход
                    if (maxSum < expense) { // Вычисляем наибольший расход
                        maxSum = expense;
                        itemName = record.item_name;
                        month = record.monthName;
                    }
                }
            }
            System.out.println("За " + month + ": " + itemName + " на сумму " + maxSum);
        }
    }

    // Статистика по годовым отчётам
        public void calcMaxSum(ArrayList<YearlyReport> yearlyReport) {

    }
}