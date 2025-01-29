package module_3.lesson13_polymorphism;

import java.util.ArrayList;

public class PossibleCasts {
    public static void main(String[] args) {
        ArrayList al = null;
        Runnable rn = (Runnable)al;
        Runnable r = null;
        ArrayList al2 = (ArrayList)r;

        //Because String is a final class and the compiler already knows this
        //The casts below are not valid

//        String s1 = null;
//        rn = (Runnable)s1;
//        Runnable r = null;
//        String s2 = (String)r;

    }
}
