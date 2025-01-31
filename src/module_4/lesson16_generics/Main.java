package module_4.lesson16_generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Fred");
        //names.add(LocalDate.of(2025,1,31));
        String n1 = names.get(0);
        //String n2 = (String)names.get(1);
    }
}
