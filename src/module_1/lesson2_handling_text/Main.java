package module_1.lesson2_handling_text;


public class Main {

    private static void stringIdentity() {
        String s1 = "Hello";
        String s2 = "Hello";

        String s3 = "He";
        String s4 = s3+ "llo";

        System.out.println("s1 == s2?: " + (s1 == s2));
        System.out.println("s1 == s4?: " + (s1 == s4));

        s4 = s4.intern();
        System.out.println("s4.intern() s1 == s4?: " + (s1 == s4));

        System.out.println("---------------------------------------");
    }

    private static void textBlocks() {
        String js = """
                This is a very long line of text, \
                it needs to stay as a single line, \
                but it's really hard to read in the source file!""";

        System.out.println(js);
        System.out.println("---------------------------------------");

    }

    private static void exercise1() {
        int i = 0;
        String s = "Values: ";

        while (i < 5) {
            if (i++ % 2 == 0)
                continue;
           s.concat(", ")
                    .concat(Integer.toString(i));
        }

        System.out.println(s);
        System.out.println("---------------------------------------");

    }

    public static void main(String[] args) {
        stringIdentity();
        textBlocks();
        exercise1();
    }
}
