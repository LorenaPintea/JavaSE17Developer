package module_3.lesson13_polymorphism;

public class Main {
    public static void main(String[] args) {
        CharSequence cs = "";
        CharSequence[] csa = {cs};

        String s1 = (String) cs + 3;
        System.out.println(s1);

        String s2 = (String) csa[0] + 3;
        System.out.println(s2);

        int l1 = cs.length();
        System.out.println(l1);
    }
}
