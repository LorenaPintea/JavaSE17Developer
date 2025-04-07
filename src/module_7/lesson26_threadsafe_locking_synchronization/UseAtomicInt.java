package module_7.lesson26_threadsafe_locking_synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UseAtomicInt {
//    private static int anInt = 0;
//    private static volatile int anInt = 0;
    private static final AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        final int WORKERS = 4;
        List<Thread> threadList = new ArrayList<>();

        for (int t = 0; t < WORKERS; t++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 1_000_000; i++)
//                    anInt++;
                    atomicInteger.incrementAndGet();
            });
            threadList.add(thread);
            thread.start();
        }

        for (Thread t : threadList) {
            t.join();
        }

        System.out.println("Total is " +
//                anInt
                atomicInteger.get() );
    }
}
