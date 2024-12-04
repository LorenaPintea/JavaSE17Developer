package module_2.lesson4_fundamentals_flow_control;

import java.util.List;

public class Main {

    private static void whileLoop() {
        int x = 0;

        while (x < 3) {
            System.out.println("x is " + x);
            x++;
        }

        System.out.println("--------------------------------------------");
    }

    private static void doWhileLoop() {
        int x = 0;

        do {
            System.out.println("x is " + x);
            x++;
        } while (x < 3);

        System.out.println("--------------------------------------------");
    }

    private static void cSyleForLoop() {
        for (int x = 0; x < 3; x++) {
            System.out.println("x is " + x);
        }

        System.out.println("--------------------------------------------");
    }

    private static void cSyleForLoop1() {
        for (int x = 0, y = 2, z[] = {1, 2, 3}; x < 3; x++, y--, System.out.println()) {
            System.out.printf("x: %1$d, y: %2$d, z[%2$d]: %3$d", x, y, z[y]);
        }

        System.out.println("--------------------------------------------");
    }

    private static void enhancedForLoop() {
        List<String> nameList = List.of("Fred", "Jim", "Sheila");
        for (String name : nameList) {
            System.out.println(name);
        }

        System.out.println("--------------------------------------------");
    }

    private static void labeledLoops() {
        outer: for (int i = 0; i < 4; i++) {
            inner: for (int j = 0; j < 4; j++) {
                if (i == j) continue outer; // or break, break inner -> to have the same output
                System.out.print(i + ", " + j + " - ");
            }
        }

        System.out.println("\n--------------------------------------------");
    }

    private static void switchExample1() {
        int x = 99;

        switch (x) {
            case 99:
                System.out.println("ninety-nine");
            case 100:
                System.out.println("one hundred");
            default:
                System.out.println("other");
        }

        System.out.println("--------------------------------------------");
    }

    private static void switchExample2() {
        int x = 97;

        switch (x) {
            case 97, 98, 99 -> {
                System.out.println("x is currently: " + x);
                x += 100;
            }
            case 100 ->
                System.out.println("one hundred");
            default ->
                System.out.println("other");
        }

        System.out.println("x is: " + x);
        System.out.println("--------------------------------------------");
    }

    private static void switchExample3() {
        int x = 0;

        var result = switch (x) {
            case 0 -> {
                System.out.println("Calculating for 0");
                yield  "Zero";
            }
            default -> throw new IllegalArgumentException("Illegal value!");
        };

        System.out.println(result);
        System.out.println("--------------------------------------------");

    }

    public static void main(String[] args) {
        whileLoop();
        doWhileLoop();
        cSyleForLoop();
        cSyleForLoop1();
        enhancedForLoop();
        labeledLoops();
        switchExample1();
        switchExample2();
        switchExample3();
    }
}
