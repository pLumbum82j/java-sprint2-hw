import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ApplicationActions {

    MonthlyReport monthlyReport;

    void readMonthlyReport(String filename) {
        String content = readFileContentsOrNull(filename);
        String[] lines = content.split("\r?\n");

        ArrayList<Record> records = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            Record record = makeRecordFromLine(lines[i]);
            records.add(record);
        }
        monthlyReport = new MonthlyReport(records);
    }



    Record makeRecordFromLine(String line) {
        String[] tokens = line.split(",");
        return new Record(
                tokens[0],
                Boolean.parseBoolean(tokens[1]),
                Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[3])
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
