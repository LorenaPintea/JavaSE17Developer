package module_8.lesson30_files_path_channel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;

public class UseFiles {
    public static void main(String[] args) throws Throwable {
//        var attribute = Files.readAttributes(
//                Path.of("."), BasicFileAttributes.class);

//        var attribute = Files.readAttributes(
//                Path.of("."), PosixFileAttributes.class);

        var attribute = Files.readAttributes(
                Path.of("."), DosFileAttributes.class);

        System.out.println(attribute);
        System.out.println(attribute.isDirectory());
        System.out.println(attribute.creationTime());
        System.out.println(attribute.isHidden());

    }
}
