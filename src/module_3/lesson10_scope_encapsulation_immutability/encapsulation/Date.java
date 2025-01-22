package module_3.lesson10_scope_encapsulation_immutability.encapsulation;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (isValid(day, month)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else throw new IllegalArgumentException("Bad values for a date!");
    }

    public static boolean isValid(int day, int month) {
        boolean isValidDay = (day > 0 && day < 32);
        boolean isValidMonth = (month > 0 && month < 13);

        return isValidDay && isValidMonth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (isValid(day, this.month)) {
            this.day = day;
        } else throw new IllegalArgumentException("Bad day value!");
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (isValid(this.day, month)) {
            this.month = month;
        } else throw new IllegalArgumentException("Bad month value!");
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

class DemoDate {
    public static void main(String[] args) {
        Date d = new Date(1, 1, 1823);
        System.out.println("day is: " + d.getDay());

        d.setDay(10);
        System.out.println("new day is: " + d.getDay());
    }
}
