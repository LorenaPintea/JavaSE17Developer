package module_3.lesson14_interfaces;

interface W {
    //   default boolean equals(Object o) {return true};
    // Method above not going to work because we can't have any methods
    // that match the signature from java.lang.Object as default

    default void doStuff() {
        System.out.println("default W.dostuff()");
    }
}

class B extends A {
    public void doStuff() {
        System.out.println("B.doStuff");
//        W.super.doStuff();
    }
}

class A implements W {
    public void doStuff() {
        System.out.println("A.doStuff");
//        W.super.doStuff();
    }
}

public class Main {
    public static void main(String[] args) {
        new A().doStuff();
    }
}
