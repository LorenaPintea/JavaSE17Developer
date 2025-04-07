package module_7.lesson26_threadsafe_locking_synchronization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StopperOnList {
    private static List<Boolean> stop;

    static {
//        stop = new ArrayList<>();
//        stop = Collections.synchronizedList(stop);
        stop = new CopyOnWriteArrayList<>();
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (stop.isEmpty() || !stop.removeFirst())
                ;
            System.out.println("Worker stopped!");
        }).start();

        System.out.println("Worker started");

        Thread.sleep(1000);
        stop.add(true);

        System.out.println("Signal set, main exiting");
    }
}
