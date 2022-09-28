public class Record {

    String monthName, itemName;
    boolean isExpense;
    int quantity, sumOfOne;


    int yearName;
    Integer month, amount;
    boolean expense;


    /**
     * Конструктор Record по месячным отчётам.
     * @param monthName Название месяца
     * @param itemName Название товара (операции, позиции)
     * @param isExpense Переменная отвечающая за доход == false / расход == true
     * @param quantity количество товара (операций, позиций)
     * @param sumOfOne стоимость одной единицы товара (операции, позиции)
     */
    public Record(String monthName, String itemName, boolean isExpense, int quantity, int sumOfOne) {
        this.monthName = monthName;
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
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
