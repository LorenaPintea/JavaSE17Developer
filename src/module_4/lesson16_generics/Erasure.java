package module_4.lesson16_generics;

import java.util.ArrayList;
import java.util.List;

public class Erasure {
    public static void doStuff1(List<String> ls) {
    }

    public static <E> void doStuff2(List<E> ls) {
    }

    public static void main(String[] args) {
        doStuff2(new ArrayList<>(List.of("Fred")));
    }
}
