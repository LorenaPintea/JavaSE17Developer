package module_7.lesson26_threadsafe_locking_synchronization;

import java.util.concurrent.Semaphore;

public class LiveLock {
    private static Semaphore resources = new Semaphore(20);

    private static int obtainResources(int count) {
        if(resources.tryAcquire(count)) return count;
        else return 0;
    }

    private static void returnResources(int count) {
        resources.release(count);
    }

    private static void delay(int d) {
        try {
            Thread.sleep(d);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable task = () -> {
          while (true) {
              //delay((int) Math.random() * 50);
              if (obtainResources(4) == 4) {
                  delay(100);
                  if (obtainResources(6) == 6) {
                      System.out.println("Success!!");
                      System.exit(0);
                      delay(200);
                      returnResources(6);
                  } else {
                      System.out.println("FAILED!!");
                  }
                  returnResources(4);
              }
          }
        };

        new Thread(task).start();
        new Thread(task).start();
    }
}
