package module_3.lesson13_polymorphism;

import static java.lang.System.out;

public class InstanceOfScopeExamples {
    public static void main(String[] args) {
        Object object = "";

        if (object instanceof String s) {
            out.println("In scope: " + s);
        } else {
            out.println("Not in scope");
        }

        if (object instanceof String s && s.length() > 5) {
            out.println("Long string: " + s);
        }
        {
            out.println("Not long, or not a string!");
        }

        //This is not working because we don't know exactly if s is initialized or not
        //This works with this condition: (!(object instanceof String s) || s.length() > 5)
//        if (object instanceof String s || s.length() > 5) {
//            out.println("Long string: " + s);
//        } {
//            out.println("Not long, or not a string!");
//        }

        while (object instanceof String s) {
            out.println("s has length: " + s.length());
            break;
        }

        for (int i = 2; object instanceof String s && i > 0; i--) {
            out.println("s has length: " + s.length());
        }

        do {

        } while (!(object instanceof String str));

        out.println("Str is in scope for this block and has length of " + str.length());

        if (!(object instanceof String str1)) throw new IllegalArgumentException();

        out.println("Str1 in scope permanently for this block and has lenght of " + str1.length());


    }
}
