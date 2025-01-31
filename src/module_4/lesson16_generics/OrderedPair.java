package module_4.lesson16_generics;

public class OrderedPair<E extends Comparable<E>> {
    private E left, right;

    public OrderedPair(E left, E right) {
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        OrderedPair<String> ops = new OrderedPair<>("Lorena", "Alina");
        OrderedPair<StringBuilder> opsb = new OrderedPair<>(new StringBuilder("Lorena"), new StringBuilder("Alina"));

        // This is not going to work, doesn't extend the Comparable interface
        //OrderedPair<TemporalAdjuster> opta;
    }

    public void order() {
        if (left.compareTo(right) > 0) {
            E temp = left;
            left = right;
            right = temp;
        }
    }
}
