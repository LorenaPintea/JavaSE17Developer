package module_1.lesson3_datetime_API;

import java.time.*;

public class Main {
    private static void timeExample1() {
        Instant timeNow = Instant.now();

        System.out.println(timeNow);

        ZonedDateTime zoneTime = ZonedDateTime.ofInstant(timeNow, ZoneId.of("Europe/Lisbon"));
        System.out.println(zoneTime);

        Duration duration = Duration.ofMinutes(160);
        System.out.println(duration);

        Period period = Period.of(1, 14, 540);
        System.out.println(period);
        System.out.println(period.normalized());

        System.out.println("------------------------------------");
    }

    private static void timeExample2() {
        LocalDate localDate = LocalDate.of(2089, 4, 19);
        System.out.println(localDate);
        System.out.println(localDate.getDayOfWeek());

        LocalDate localDate2 = localDate.plusDays(10);
        System.out.println(localDate2.withMonth(7));

        var localDate3 = LocalDate.parse("2019-02-12");
        System.out.println(localDate3);

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate4 = LocalDate.from(localDateTime);
        System.out.println(localDateTime);
        System.out.println(localDate4);

        System.out.println("------------------------------------");
    }

    private static void timeExample3() {
        LocalDate localDate = LocalDate.now();
        //LocalTime localTime = LocalTime.from(localDate); BREAKING!!

        System.out.println(localDate);
        //System.out.println(localTime);

        var localDateTime = localDate.atTime(13, 15);
        System.out.println(localDateTime);
        System.out.println(localDateTime.getClass().getName());

        var localDate2 = LocalDate.of(2050, 1, 15);
        var adjustedDate = localDate2.adjustInto(localDateTime);
        System.out.println(adjustedDate);
        System.out.println(adjustedDate.getClass().getName());

        Period fifteen = Period.ofDays(15);
        LocalDate february14 = LocalDate.of(2024, 7, 19);
        System.out.println(february14);
        System.out.println(february14.plus(fifteen));

        System.out.println("------------------------------------");
    }

    private static void timeExample4() {
        //ZoneId.getAvailableZoneIds().forEach(System.out::println);

        var zoneID = ZoneId.of("Europe/Lisbon");
        System.out.println(zoneID);

        //ZoneId.of("Europe/Lisbon").getRules().getTransitions().forEach(System.out::println);

        System.out.println(zoneID.getRules().previousTransition(Instant.now()));
        System.out.println(zoneID.getRules().nextTransition(Instant.now()));

        var shiftTime = ZonedDateTime.parse("2025-03-28T00:00:00Z[Europe/Lisbon]");

        System.out.println(shiftTime);
        System.out.println(shiftTime.plusHours(12));
        System.out.println(shiftTime.plusHours(24));
        System.out.println(shiftTime.plusHours(48));
        System.out.println(shiftTime.plusHours(72));


        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        //timeExample1();
        //timeExample2();
        //timeExample3();
        timeExample4();
    }
}
