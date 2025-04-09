package module_8.lesson30_files_path_channel;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class UseChannels {
    public static void main(String[] args) throws Throwable {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        try (FileInputStream fileInputStream = new FileInputStream(
                Path.of("paths", "data.txt").toFile());
             FileChannel fileChannelIn = fileInputStream.getChannel();
             FileChannel fileChannelOut = FileChannel.open(Path.of("paths", "copy.txt"),
                     StandardOpenOption.CREATE, StandardOpenOption.WRITE);) {

            int count;

            while ((count = fileChannelIn.read(buffer)) >= 0) {
                buffer.flip();
                fileChannelOut.write(buffer);
                buffer.clear();
            }

        }
    }
}
