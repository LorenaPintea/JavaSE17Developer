package module_8.lesson30_files_path_channel;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;

public class UsePath {
    public static void main(String[] args) throws Throwable {
        Path abFile = Path.of("paths", "a", "b", "file-a-b.txt");
        Path cPath = Path.of("paths", "c");

        System.out.println(abFile.getFileName());
        System.out.println("Element 2 is " + abFile.getName(2));
        abFile.iterator().forEachRemaining(System.out::println);

        System.out.println("Path is absolute? " + abFile.isAbsolute());
        System.out.println("Absolute path is: " + abFile.toAbsolutePath());

        Path odd = Path.of(".", "..", "JavaSE17Developer", "paths", "a", "..", "a", "b", "file-a-b.txt");

        System.out.println("Odd is: " + odd);
        System.out.println("Normalized is: " + odd.normalize());

        System.out.println("Resolve, joining paths " + cPath.resolve("d/file-c-d.txt"));
        System.out.println("To get from paths/c to file-a-b: " + cPath.relativize(abFile));

        try (var watchService = FileSystems.getDefault().newWatchService();) {
            Path pathDir = Path.of("paths");
            var registrationKey = pathDir.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            while (true) {
                var key = watchService.take();
                System.out.println("Something happened");

                for (var event : key.pollEvents()) {
                    System.out.println("Filename " + event.context());
                }

                registrationKey.reset();
            }
        }
    }
}
