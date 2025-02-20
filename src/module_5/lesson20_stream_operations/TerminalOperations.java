package module_5.lesson20_stream_operations;

import java.util.stream.IntStream;

public class TerminalOperations {
    public static void main(String[] args) {
        var count = IntStream.range(1, 10)
                .peek(x -> System.out.println("Procesing: " + x))
//                .forEach(System.out::println)
//                .allMatch(x -> x < 4)
                .count();

        System.out.println(count);
    }
}
