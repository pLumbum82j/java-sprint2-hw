public class Calendar {
    String[] year = new String[12];

    {
        year[0] = "Январь";
        year[1] = "Февраль";
        year[2] = "Март";
        year[3] = "Апрель";
        year[4] = "Май";
        year[5] = "Июнь";
        year[6] = "Июль";
        year[7] = "Август";
        year[8] = "Сентябрь";
        year[9] = "Октябрь";
        year[10] = "Ноябрь";
        year[11] = "Декабрь";

    }

    String calendarmonth(int month) {
        String mesac = null;
        month = month - 1;
        for (int i = 0; i < year.length; i++) {
            if (i == month) {
                mesac = year[i];
            }
        }
        return mesac;
    }
}