public class Record {

    // Переменные месячного отчёта
    String monthName, item_name;
    boolean is_expense;
    int quantity, sum_of_one;

    // Переменные годового отчёта
    int yearName;
    Integer month, amount;
    boolean expense;

    public Record(String monthName, String item_name, boolean is_expense, int quantity, int sum_of_one) {
        this.monthName = monthName;
        this.item_name = item_name;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }

    public Record(int yearName, int month, int amount, boolean expense) {
        this.yearName = yearName;
        this.month = month;
        this.amount = amount;
        this.expense = expense;
    }

}
