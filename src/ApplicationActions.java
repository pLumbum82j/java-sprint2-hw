import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ApplicationActions {
    Statistics statistics = new Statistics();
    Calendar calendar = new Calendar();
    ArrayList<MonthlyReport> monthlyReports;
    YearlyReport yearlyReport;
    /**
     * Конструктор пустого списка monthlyReports (месячного отчёта)
     */
    ApplicationActions() {
        monthlyReports = new ArrayList<>();
    }

    /**
     * Метод проверки и обнуления списков перед записью
     */
        public void clear() {
        if (monthlyReports.size() > 0){
            monthlyReports.clear();
        }
    }

    /**
     * Метод считывания месячных отчётов и запись их в память
     * @param filename имя файла месячного отчёта
     */
    void readMonthlyReport(String filename) {
        String content = readFileContentsOrNull(filename);
        String[] lines = content.split("\r?\n");  ///< Разбиваем строки по переносу строки и записываем в массив lines
        String[] filenames = filename.split("\\."); ///< Разбиваем имя файла и записываем в массив filenames

        int month = Integer.parseInt(filenames[1].substring(5)); ///< Отрезаем от имени файла значение и записываем в переменную month
        String monthName = calendar.calendarmonth(month); ///< Поиск имени месяца по его номеру, запись его в переменную monthName

        ArrayList<Record> records = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            Record record = makeRecordFromLineM(monthName, lines[i]);
            records.add(record);
        }


        MonthlyReport monthlyReport = new MonthlyReport(records);
        monthlyReports.add(monthlyReport);

        System.out.println("Месячный отчёт за " + calendar.calendarmonth(month) + " успешно загружен");
    }
    /**
     * Метод считывания годового отчёта и запись его в память
     * @param filename имя файла годового отчёта
     */
    void readYearlyReport(String filename) {
        String content = readFileContentsOrNull(filename);
        String[] lines = content.split("\r?\n"); ///< Разбиваем строки по переносу строки и записываем в массив lines
        String[] filenames = filename.split("\\."); ///< Разбиваем имя файла и записываем в массив filenames

        int year = Integer.parseInt(filenames[1]);  ///< Отрезаем от имени файла значение и записываем в переменную year
        ArrayList<Record> records = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            Record record = makeRecordFromLineY(year, lines[i]);
            records.add(record);
        }
        yearlyReport = new YearlyReport(records);
        System.out.println("Годовой отчёт за " + filenames[1] + "г. успешно загружен");
    }
    /**
     * Метод предварительно проверяет были ли считаны (записаны / загружены) месячные и годовой отчёты.
     * Вызывает метод "Сверки отчётов - reviseCalc();"
     */
    void revise(){
        if (monthlyReports.size() == 0) {
            System.out.println("Ни один месячный отчёт не был загружен");
            return;
        } else if (yearlyReport == null) {
            System.out.println("Ни один годовой отчёт не был загружен");
            return;
        }
       statistics.reviseCalc(monthlyReports, yearlyReport, calendar);
    }
    /**
     * Метод предварительно проверяет были ли считаны (записаны / загружены) месячные отчёты.
     * Вызывает методы поиска "Дохода calcMaxSumIncome();" и "Расхода calcMaxSumExpense();"
     */
    void printMonthlyReport() {
        if (monthlyReports.size() == 0) {
            System.out.println("Ни один месячный отчёт не был загружен");
            return;
        }
        statistics.calcMaxSumIncome(monthlyReports);
        statistics.calcMaxSumExpense(monthlyReports);
    }
    /**
     * Метод предварительно проверяет был ли считаны (записан / загружен) годовой отчёты.
     * Вызывает метот "Статистики годового отчётам calcMaxSum();"
     */
    void printYearlyReport() {
        if (yearlyReport == null) {
            System.out.println("Ни один годовой отчёт не был загружен");
            return;
        }
        statistics.calcMaxSum(yearlyReport, calendar);
    }
    /**
     * Метод отвечает за считывание строки, разбивание её по запятой и заипсь в Record Месячного отчёта
     * @param monthName Имя месяца
     * @param line строку из файлма месячного отчёта
     * @return объект Record с набором переменных
     */
    Record makeRecordFromLineM(String monthName, String line) {
        String[] tokens = line.split(","); ///< Разбиваем строку по знаку "," и записали в массив
        return new Record(
                monthName,
                tokens[0],
                Boolean.parseBoolean(tokens[1]),
                Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[3])
        );
    }
    /**
     * Метод отвечает за считывание строки, разбивание её по запятой и заипсь в Record Годового отчёта
     * @param yearName Номер года
     * @param line строку из файлма годового отчёта
     * @return объект Record с набором переменных
     */
    Record makeRecordFromLineY(int yearName, String line) {
        String[] tokens = line.split(","); ///< Разбиваем строку по знаку "," и записали в массив
        return new Record(
                yearName,
                Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]),
                Boolean.parseBoolean(tokens[2])
        );
    }
    /**
     * Метод отвечает за считывание файлов отчётов
     * @param path Имя файла для считывания
     * @return Одной строкой весь файл
     */
    String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

}
