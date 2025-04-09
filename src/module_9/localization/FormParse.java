package module_9.localization;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class FormParse {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(1996, 1, 23);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println(dateTimeFormatter.format(localDate));

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.println(dateTimeFormatter1.format(localDate));

        String date = "25 September 2018";
        TemporalAccessor tempDate = dateTimeFormatter1.parse(date);
        System.out.println(dateTimeFormatter.format(tempDate));
    }
}
