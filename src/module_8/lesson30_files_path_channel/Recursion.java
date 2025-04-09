package module_8.lesson30_files_path_channel;

import java.nio.file.Files;
import java.nio.file.Path;

public class Recursion {
    public static void main(String[] args) throws Throwable {
        System.out.println("------------------------");

        Files.walk(Path.of("src/"), 1)
                .forEach(p -> System.out.println(p));

        System.out.println("------------------------");

        Files.find(Path.of("."), 2,
                /*(p, a) -> true)*/ (p, a) -> a.isDirectory())
                .forEach(System.out::println);
    }
}
