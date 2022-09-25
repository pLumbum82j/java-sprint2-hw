
import java.util.ArrayList;
import java.util.HashMap;


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
        System.out.println("Самый большой расход");
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
    public void calcMaxSum(YearlyReport yearlyReport, Calendar calendar) {
        HashMap<Integer, Integer> income = new HashMap<>();
        HashMap<Integer, Integer> expense = new HashMap<>();
        int yearName = 0;
        for (Record record : yearlyReport.records) {
            if (record.expense) {
                expense.put(record.month, record.amount);
            } else {
                income.put(record.month, record.amount);
            }
            yearName = record.yearName;
        }

        System.out.println("Информация по отчёту за " + yearName + "г.");
        int month = 0;

        int incomeSum = 0;
        int expenseSum = 0;


        for (int i = 0; i < 12; i++) {
            int profit = 0;
            boolean isIncome = false;
            boolean isExpense = false;
            if (income.get(i) != null) {
                profit += income.get(i);
                incomeSum += income.get(i);
                isIncome = true;
            }
            if (expense.get(i) != null) {
                profit -= expense.get(i);
                expenseSum += expense.get(i);
                isExpense = true;
            }
            if (isIncome || isExpense) {
                month++;
                System.out.println("За " + calendar.calendarmonth(month) + " прибыль составила: " + profit);
            }
        }
        System.out.println("За " + yearName + "г. средний расход за все месяцы  составил: " + (expenseSum / month));
        System.out.println("За " + yearName + "г. средний доход за все месяцы составил: " + (incomeSum / month));
    }
}