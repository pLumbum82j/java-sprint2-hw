import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ApplicationActions {
    Statistics statistics = new Statistics();
    Calendar calendar = new Calendar();
    ArrayList<MonthlyReport> monthlyReports;
    YearlyReport yearlyReport;

    ApplicationActions() {
        monthlyReports = new ArrayList<>();
    }

    void readMonthlyReport(String filename) {
        String content = readFileContentsOrNull(filename);
        String[] lines = content.split("\r?\n");
        String[] filenames = filename.split("\\.");

        int month = Integer.parseInt(filenames[1].substring(5));
        String monthName = calendar.calendarmonth(month);

        ArrayList<Record> records = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            Record record = makeRecordFromLineM(monthName, lines[i]);
            records.add(record);
        }


        MonthlyReport monthlyReport = new MonthlyReport(records);
        monthlyReports.add(monthlyReport);

        System.out.println("Месячный отчёт за " + calendar.calendarmonth(month) + " успешно загружен");
    }

    void readYearlyReport(String filename) {
        String content = readFileContentsOrNull(filename);
        String[] lines = content.split("\r?\n");
        String[] filenames = filename.split("\\.");
        int yearName = Integer.parseInt(filenames[1]);

        ArrayList<Record> records = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            Record record = makeRecordFromLineY(yearName, lines[i]);
            records.add(record);
        }
        yearlyReport = new YearlyReport(records);
        System.out.println("Годовой отчёт за " + filenames[1] + "г. успешно загружен");
    }


    void printMonthlyReport() {
        if (monthlyReports.size() == 0) {
            System.out.println("Ни один месячный отчёт не был загружен");
            return;
        }
        statistics.calcMaxSumIncome(monthlyReports);
        statistics.calcMaxSumExpense(monthlyReports);
    }

    void printYearlyReport() {
        if (yearlyReport == null) {
            System.out.println("Ни один годовой отчёт не был загружен");
            return;
        }
        statistics.calcMaxSum(yearlyReport, calendar);
    }

    Record makeRecordFromLineM(String monthName, String line) {
        String[] tokens = line.split(",");
        return new Record(
                monthName,
                tokens[0],
                Boolean.parseBoolean(tokens[1]),
                Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[3])
        );
    }

    Record makeRecordFromLineY(int yearName, String line) {
        String[] tokens = line.split(",");
        return new Record(
                yearName,
                Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]),
                Boolean.parseBoolean(tokens[2])
        );
    }

    String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

}
