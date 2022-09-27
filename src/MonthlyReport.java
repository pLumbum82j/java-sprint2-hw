import java.util.ArrayList;

public class MonthlyReport {
    ArrayList<Record> records;
    /**
    * Конструктор MonthlyReport по месячным отчётам
     * @param NewRecords одна строка из месячного отчёта
     */
    MonthlyReport(ArrayList<Record> NewRecords) {
        records = NewRecords;
    }
}
