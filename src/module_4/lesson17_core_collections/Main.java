package module_4.lesson17_core_collections;

import java.time.LocalDate;

public class Main {
    static void addToArray(Object[] objects) {
        objects[objects.length - 1] = LocalDate.now();
    }

    public static void main(String[] args) {
        String[] strings = new String[4];
        // Error because it's a string array not LocalDate
        addToArray(strings);
    }
}
