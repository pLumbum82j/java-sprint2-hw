import java.util.ArrayList;

public class YearlyReport {
    ArrayList<Record> records;
    /**
     * Конструктор YearlyReport по месячным отчётам
     * @param NewRecords одна строка из годового отчёта
     */
    YearlyReport(ArrayList<Record> NewRecords) {
        records = NewRecords;
    }

}

