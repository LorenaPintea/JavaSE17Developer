package module_1.lesson1_operations_and_core_data_types;

import java.util.ArrayList;
import java.util.List;

class Thing {
    private int data;

    public Thing(int data) {
        this.data = data;
    }
}

public class Main {

    private static void reminderOperator() {
        System.out.println("7 % 3: " + 7 % 3);
        System.out.println("-7 % 3: " + (-7) % 3);
        System.out.println("7 % -3: " + 7 % (-3));
        System.out.println("-7 % -3: " + (-7) % (-3));
        System.out.println("--------------------------------------------");
    }

    private static void postPreIncrement() {
        int i = 0;

        System.out.println("i++: " + (i++));
        System.out.println("i: " + (i));
        System.out.println("++i: " + (++i));
        System.out.println("--------------------------------------------");
    }

    private static void equalOperator() {
        String s1 = "Hello";
        String s2 = s1;
        String s3 = new String("Hello World");

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);

        s2 = s2.concat(" World");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s2.equals(s3));
        System.out.println("--------------------------------------------");
    }

    private static void thingComparison() {
        Thing data1 = new Thing(100);
        Thing data2 = new Thing(100);

        System.out.println(data1);
        System.out.println(data2);

        System.out.println(data1 == data2);
        System.out.println("--------------------------------------------");

        List<Thing> thingList1 = new ArrayList<>();
        thingList1.add(new Thing(203));

        List<Thing> thingList2 = new ArrayList<>();
        thingList2.add(new Thing(2304));

        System.out.println(thingList1);
        System.out.println(thingList2);

        thingList2 = thingList1;
        System.out.println(thingList1);
        System.out.println(thingList2);
        System.out.println("--------------------------------------------");
    }

    public static void main(String[] args) {
        reminderOperator();
        postPreIncrement();
        equalOperator();
        thingComparison();

    }
}
