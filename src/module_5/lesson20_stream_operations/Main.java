package module_5.lesson20_stream_operations;

import java.util.Spliterator;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Spliterator.OfInt spliterator = IntStream.range(0, 1000).spliterator();

        spliterator.tryAdvance((int x) -> System.out.println("Spliterator before: " + x));


        var spliterator2 = spliterator.trySplit();
        spliterator.tryAdvance((int x) -> System.out.println("Spliterator: " + x));
        spliterator2.tryAdvance((int x) -> System.out.println("Spliterator2: " + x));

        var spliterator3 = spliterator.trySplit();
        var spliterator4 = spliterator2.trySplit();
        spliterator.tryAdvance((int x) -> System.out.println("Spliterator: " + x));
        spliterator2.tryAdvance((int x) -> System.out.println("Spliterator2: " + x));
        spliterator3.tryAdvance((int x) -> System.out.println("Spliterator3: " + x));
        spliterator4.tryAdvance((int x) -> System.out.println("Spliterator4: " + x));


    }
}
