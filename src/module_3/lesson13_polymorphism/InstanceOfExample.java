package module_3.lesson13_polymorphism;

public class InstanceOfExample {
    public static void oldExample() {
        Object thing = "Hello";

        if (thing instanceof String stringThing) {

            if (stringThing.length() > 4) {
                System.out.println("This is a long string!!");
            }
        }
    }

    public static void newExample() {
        Object thing = "Hello";

        if (thing instanceof String stringThing) {
            //String stringThing = (String)thing;

            if (stringThing.length() > 4) {
                System.out.println("This is a long string!!");
            }
        }
    }

    public static void newExample1() {
        Object thing = "Hello";

        if (thing instanceof String stringThing && stringThing.length() > 4) {
            System.out.println("This is a long string!!");
        }
    }

    public static void main(String[] args) {
        oldExample();
        newExample();
        newExample1();
    }
}
