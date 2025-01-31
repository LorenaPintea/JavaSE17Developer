package module_4.lesson16_generics;

import java.time.LocalDate;

public class Pair<E> {
    private final E left;
    private E right;

    public Pair(E left, E right) {
        this.left = left;
        this.right = right;
    }

    public E getLeft() {
        return left;
    }

    public void setRight(E right) {
        this.right = right;
    }
}

class UsePair {
    public static void main(String[] args) {
        Pair<String> ps = new Pair<>("Something", "else");
        String left = ps.getLeft();
        ps.setRight("wrong");

        Pair<LocalDate> pls = new Pair<>(LocalDate.now(), LocalDate.now());
    }
}