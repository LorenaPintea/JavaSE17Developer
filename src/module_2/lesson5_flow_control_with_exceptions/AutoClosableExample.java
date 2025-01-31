package module_2.lesson5_flow_control_with_exceptions;

import java.io.FileNotFoundException;

class MyResource implements AutoCloseable {
    private static int nextID = 0;
    private final int ID = nextID++;

    {
        System.out.println("Initializing MyResource ID=" + ID);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing the resource with ID=" + ID);

        if (Math.random() > 0.5) {
            System.out.println("Failed to close resource ID=" + ID);
            throw new Exception("Failing to close the resource with ID=" + ID);
        }

        System.out.println("Closing the resource with ID=" + ID + " was successful!");
    }
}

public class AutoClosableExample {
    public static void main(String[] args) {
        System.out.println("Start the program!");
        MyResource resource = new MyResource();

        try (MyResource resource1 = new MyResource();
             resource;
             MyResource resource2 = new MyResource()) {

            System.out.println("Using my resource...");

            if (Math.random() > 0.5) {
                System.out.println("Throw File Not Found in main try block");
                throw new FileNotFoundException("FNFE!");
            }
        } catch (Throwable throwable) {
            System.out.println("Primary problem: " + throwable.getMessage());

            for (Throwable suppressedThrowable : throwable.getSuppressed()) {
                System.out.println(" + suppressed: " + suppressedThrowable.getMessage());
            }
        }

        System.out.println("End of the program!");
    }
}
