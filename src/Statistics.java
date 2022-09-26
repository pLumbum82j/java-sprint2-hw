
import java.util.ArrayList;
import java.util.HashMap;


public class Statistics {
    int expenseM, maxSum;
    String itemName, monthM;

    // Статистика по месячным отчётам
    public void calcMaxSumIncome(ArrayList<MonthlyReport> monthlyReports) { // доход
        System.out.println("Самая прибыльная операция");
        for (MonthlyReport report : monthlyReports) {
            maxSum = 0;
            itemName = "";
            monthM = "";
            for (Record record : report.records) {
                if (!record.is_expense) { // Вывести только FALSE
                    expenseM = 0;
                    expenseM += record.quantity * record.sum_of_one; // Вычислить доход
                    if (maxSum < expenseM) { // Вычисляем наибольший доход
                        maxSum = expenseM;
                        itemName = record.item_name;
                        monthM = record.monthName;
                    }
                }
            }
            System.out.println("За " + monthM + ": " + itemName + " на сумму " + maxSum);
        }
    }

    public void calcMaxSumExpense(ArrayList<MonthlyReport> monthlyReports) { // расход
        System.out.println("Самый большой расход");
        for (MonthlyReport report : monthlyReports) {
            maxSum = 0;
            itemName = "";
            monthM = "";
            for (Record record : report.records) {
                if (record.is_expense) { // Вывести только TRUE
                    expenseM = 0;
                    expenseM += record.quantity * record.sum_of_one; // Вычислить расход
                    if (maxSum < expenseM) { // Вычисляем наибольший расход
                        maxSum = expenseM;
                        itemName = record.item_name;
                        monthM = record.monthName;
                    }
                }
            }
            System.out.println("За " + monthM + ": " + itemName + " на сумму " + maxSum);
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

    // Сверка
    public void reviseCalc(ArrayList<MonthlyReport> monthlyReports, YearlyReport yearlyReport, Calendar calendar) {
        System.out.println("тут будет сверка!");

        for (MonthlyReport report : monthlyReports) {
            int incomeSumM = 0;
            int expenseSumM = 0;
            monthM = "";
            for (Record record : report.records) {
                expenseM = 0;
                expenseM += record.quantity * record.sum_of_one;
                if (record.is_expense) { // Проходимся по массиву и  находим false/true is_expense в месяцах и записываем
                    expenseSumM = expenseSumM + expenseM;
                } else {
                    incomeSumM = incomeSumM + expenseM;
                }
                monthM = record.monthName;

            }
            if (expenseSumM > 0) {
                if (incomeSumM > 0) { add
                    int expenseSumY = 0;
                    int incomeSumY = 0;
                    boolean isExpense = false;
                    for (Record record : yearlyReport.records) { // пробегаемся по массиву года
                        if (record.month == calendar.calendarRevise(monthM)) {
                            if (record.expense) { // записали за 2 итерации false/true expense
                                expenseSumY = expenseSumY + record.amount;
                            } else {
                                incomeSumY = incomeSumY + record.amount;
                            }
                        }

                    }
                    if (expenseSumY == expenseSumM) { //Сравниваем expense в Годовом и Месячном
                        if (incomeSumY == incomeSumM) { //Сравниваем income в Годовом и Месячном
                            isExpense = true;
                            incomeSumM = 0;
                            expenseSumM = 0;
                        } else {
                            isExpense = false;
                            incomeSumM = 0;
                            expenseSumM = 0;

                        }
                    }
                    if (isExpense == true) {
                        System.out.println("Данные за " + monthM + " совпадают");
                    } else {
                        System.out.println("Данные за " + monthM + " НЕ совпадают");
                    }

                }

            }
        }

    }
}
