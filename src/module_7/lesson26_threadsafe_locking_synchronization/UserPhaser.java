package module_7.lesson26_threadsafe_locking_synchronization;

import java.util.concurrent.Phaser;

public class UserPhaser {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(1);
        System.out.println("Registered is: " + phaser.getRegisteredParties());

        new Thread(() -> {
            phaser.register();

            for (int i = 0; i < 3; i++) {
                System.out.println("Worker about to arriveAndAwaitAdvance");
                phaser.arriveAndAwaitAdvance();
            }

            System.out.println("Worker waiting for the last time");
            phaser.arriveAndDeregister();
            System.out.println("Worker ends");
        }).start();

        while (phaser.getRegisteredParties() < 2)
            Thread.sleep(1);

        System.out.println("Worker launched and registered, registered is " + phaser.getRegisteredParties());

        while (phaser.getRegisteredParties() > 1) {
            Thread.sleep(1000);
            System.out.println("Main tick");
            phaser.arriveAndAwaitAdvance();
        }

        phaser.arriveAndDeregister();
        System.out.println("All done!");
    }
}
