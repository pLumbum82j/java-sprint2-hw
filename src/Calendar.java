public class Calendar {
    /**
     * Массив содержащий название месяев в году
     */
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
    /**
     * Поиск названия месяца относительно его значения (номера).
     * @param month номер месяца который передаётся в метод для поиска
     * @return Возвращем название месяца после того, как нашли его по индксу в массиве
     */
    String calendarmonth(int month) {
        String monthNameCalendar = null; ///< Переменная в которую мы запишем значение для возврата
        month = month - 1; ///< Учитываем разность массива с 0, а месяцы в году с 1
        for (int i = 0; i < year.length; i++) {
            if (i == month) {
                monthNameCalendar = year[i];
            }
        }
        return monthNameCalendar;
    }
    /**
     * Поиск номера месяца относительно его названия.
     * @param monthName название месяца который передаётся в метод для поиска
     * @return Возвращем номер месяца после того, как нашли его по значению (названию) в массиве
     */
    int calendarRevise(String monthName){
        int monthNumberCalendar = 0; ///< Переменная в которую мы запишем значение для возврата
        for (int i = 0; i < year.length; i++){
            if (year[i] == monthName){
                monthNumberCalendar = i;
                monthNumberCalendar++; ///< Учитываем разность массива с 0, а месяцы в году с 1
            }
        }
        return monthNumberCalendar;
    }

}
