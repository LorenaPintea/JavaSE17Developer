package module_7.lesson25_create_execute_threads;

public class Main {
    // If threads are sharing a value take care with the overwriting the value in a wrong way!!
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            for(i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " i is " + i);
            }
        };
        r.run();

        Thread t1 = new Thread(r, "Worker thread");
        t1.start();

        Thread t2 = new Thread(r, "Another worker thread");
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Main exit!");
    }
}
