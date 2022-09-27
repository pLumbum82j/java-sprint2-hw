public class Record {

    /// Переменные месячного отчёта
    String monthName, item_name;
    boolean is_expense;
    int quantity, sum_of_one;

    /// Переменные годового отчёта
    int yearName;
    Integer month, amount;
    boolean expense;


    /**
     * Конструктор Record по месячным отчётам.
     * @param monthName Название месяца
     * @param item_name Название товара (операции, позиции)
     * @param is_expense Переменная отвечающая за доход == false / расход == true
     * @param quantity количество товара (операций, позиций)
     * @param sum_of_one стоимость одной единицы товара (операции, позиции)
     */
    public Record(String monthName, String item_name, boolean is_expense, int quantity, int sum_of_one) {
        this.monthName = monthName;
        this.item_name = item_name;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }
    /**
     * Конструктор Record по годовым отчётам.
     * @param yearName Номер года
     * @param month Номер месяца
     * @param amount Общая сумма
     * @param expense Переменная отвечающая за доход == false / расход == true
     */
    public Record(int yearName, int month, int amount, boolean expense) {
        this.yearName = yearName;
        this.month = month;
        this.amount = amount;
        this.expense = expense;
    }

}
