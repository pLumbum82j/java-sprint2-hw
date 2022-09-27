
import java.util.ArrayList;
import java.util.HashMap;

public class Statistics {
    int expenseM, maxSum;
    String itemName, monthM;

    /**
     * Метод поиска наибольшего дохода по определенной позиции за месяц
     * @param monthlyReports месячный отчёт
     */
    public void calcMaxSumIncome(ArrayList<MonthlyReport> monthlyReports) {
        System.out.println("Самая прибыльная операция");
        for (MonthlyReport report : monthlyReports) {
            maxSum = 0;
            itemName = "";
            monthM = "";
            for (Record record : report.records) {
                if (!record.is_expense) { ///< Вывести только FALSE
                    expenseM = 0;
                    expenseM += record.quantity * record.sum_of_one; ///< Вычислить доход
                    if (maxSum < expenseM) { ///< Вычисляем наибольший доход
                        maxSum = expenseM;
                        itemName = record.item_name;
                        monthM = record.monthName;
                    }
                }
            }
            System.out.println("За " + monthM + ": " + itemName + " на сумму " + maxSum);
        }
    }
    /**
     * Метод поиска наибольшего расхода по определенной позиции за месяц
     * @param monthlyReports месячный отчёт
     */
    public void calcMaxSumExpense(ArrayList<MonthlyReport> monthlyReports) {
        System.out.println("Самый большой расход");
        for (MonthlyReport report : monthlyReports) {
            maxSum = 0;
            itemName = "";
            monthM = "";
            for (Record record : report.records) {
                if (record.is_expense) { /// < Вывести только TRUE
                    expenseM = 0;
                    expenseM += record.quantity * record.sum_of_one; ///< Вычислить расход
                    if (maxSum < expenseM) { ///< Вычисляем наибольший расход
                        maxSum = expenseM;
                        itemName = record.item_name;
                        monthM = record.monthName;
                    }
                }
            }
            System.out.println("За " + monthM + ": " + itemName + " на сумму " + maxSum);
        }
    }

    /**
     * Метод статистики годового отчёта.
     * @param yearlyReport годовой отчёт
     * @param calendar необходим для поиск названия месяца по номеру
     */
    public void calcMaxSum(YearlyReport yearlyReport, Calendar calendar) {
        HashMap<Integer, Integer> expense = new HashMap<>(); ///< хеш-список доходов
        HashMap<Integer, Integer> income = new HashMap<>();  ///< хеш-список расходов
        int yearName = 0;
        for (Record record : yearlyReport.records) {  ///< пробежались отчёту и получили расходы и доходы за каждый месяц
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

        for (int i = 0; i < 12; i++) {  ///< Пробежались по каждому месяцу в году
            int profit = 0; ///< Переменная отвечающая за месячную прибыль
            boolean isIncome = false;
            boolean isExpense = false;
            if (income.get(i) != null) {
                profit += income.get(i);
                incomeSum += income.get(i);
                isIncome = true; ///< Маркер записи, если true - успешно записан
            }
            if (expense.get(i) != null) {
                profit -= expense.get(i);
                expenseSum += expense.get(i);
                isExpense = true; ///< Маркер записи, если true - успешно записан
            }
            if (isIncome || isExpense) {
                month++;
                System.out.println("За " + calendar.calendarmonth(month) + " прибыль составила: " + profit);
            }
        }
        System.out.println("За " + yearName + "г. средний расход за все месяцы  составил: " + (expenseSum / month));
        System.out.println("За " + yearName + "г. средний доход за все месяцы составил: " + (incomeSum / month));
    }

    /**
     * Метод Сверки отчётов. Сделан максимально колхозным способом!
     * @param monthlyReports Месячные отчёты (список)
     * @param yearlyReport Годовой отчёт
     * @param calendar Календарь для вычисления месяца по номеру
     */
    public void reviseCalc(ArrayList<MonthlyReport> monthlyReports, YearlyReport yearlyReport, Calendar calendar) {
        System.out.println("Результаты сверки отчётов:");

        for (MonthlyReport report : monthlyReports) {
            int expenseSumM = 0; ///<  expense меячного отчёта - true
            int incomeSumM = 0; ///<  income меячного отчёта - false
            monthM = "";
            for (Record record : report.records) {
                expenseM = 0;
                expenseM += record.quantity * record.sum_of_one;
                if (record.is_expense) { ///< Проходимся по массиву и  находим true/false в is_expense месяца и записываем
                    expenseSumM = expenseSumM + expenseM;
                } else {
                    incomeSumM = incomeSumM + expenseM;
                }
                monthM = record.monthName; ///< Не забываем передать имя месяца

            }
            if (expenseSumM > 0) {
                if (incomeSumM > 0) {
                    int expenseSumY = 0; ///<  expense годового отчёта - true
                    int incomeSumY = 0; ///<  income годового отчёта - false
                    boolean isExpense = false;
                    for (Record record : yearlyReport.records) { ///< Пробегаемся по массиву года
                        if (record.month == calendar.calendarRevise(monthM)) { ///< По определенному месяцу
                            if (record.expense) {
                                expenseSumY = expenseSumY + record.amount;
                            } else {
                                incomeSumY = incomeSumY + record.amount;
                            }
                        }
                    }
                    if (expenseSumY == expenseSumM) { ///< Сравниваем expense в Годовом и Месячном
                        if (incomeSumY == incomeSumM) {  ///< Сравниваем income в Годовом и Месячном
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
