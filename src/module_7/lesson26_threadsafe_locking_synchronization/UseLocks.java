package module_7.lesson26_threadsafe_locking_synchronization;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UseLocks {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        var writeLock = reentrantReadWriteLock.writeLock();
        var condition = writeLock.newCondition();

        new Thread(() -> {
            System.out.println("Thread 1 - started, taking lock");
            writeLock.lock();

            try {
                System.out.println("Thread 1 - sleeping");
                Thread.sleep(1000);
                System.out.println("Thread 1 - starting await");
                condition.await();
                System.out.println("Thread 1 - restarted from await");
            } catch (InterruptedException exception) {
                System.out.println("Thread 1 - That shouldn't have happened...");
            } finally {
                System.out.println("Thread 1 - releasing lock");
                writeLock.unlock();
            }
        }).start();

        new Thread(() -> {
            System.out.println("Thread 2 - starting, about to go to sleep");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                System.out.println("Thread 2 - That shouldn't have happened...");
            }

            System.out.println("Thread 2 - attempting to get the lock");
            writeLock.lock();
            try {
                System.out.println("Thread 2 - sleeping");
                Thread.sleep(1000);
                condition.signal();
                System.out.println("Thread 2 - condition has been signaled");
            } catch (InterruptedException exception) {
                System.out.println("Thread 2 - That shouldn't have happened...");
            } finally {
                writeLock.unlock();
            }
        }).start();
    }
}
