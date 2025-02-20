package module_5.lesson21_reduction_operations_parallelism;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List.of("Fred", "Jim", "Sheila", "Bill", "Joe", "Sally", "John", "Tommy")
                .stream()
                .collect(Collectors.groupingBy(s -> s.length()))
                .forEach((k, v) -> System.out.printf("%d character words are %s\n", k, v));


        List.of("Fred", "Jim", "Sheila", "Bill", "Joe", "Sally", "John", "Tommy")
                .stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 4))
                .entrySet().forEach(System.out::println);
    }
}
