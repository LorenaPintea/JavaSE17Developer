package module_7.lesson25_create_execute_threads;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

class MyTask implements Callable<String> {
    private static int nextID = 0;
    private int jobID = nextID++;

    @Override
    public String call() throws Exception {
        System.out.println("Job " + jobID + " starting.");

        try {
            Thread.sleep((int)(Math.random() * 2000 + 1000));
        } catch (InterruptedException ex) {
            System.out.println("Job " + jobID + " received shutdown request");
            return "Job " + jobID + " early shutdown result.";
        }

        if (Math.random() > 0.7) {
            System.out.println("Job " + jobID + " throwing exception");
            throw new SQLException("Job " + jobID + " Database BROKE!");
        }

        System.out.println("Job " + jobID + " completed normally.");
        return "Job " + jobID + " normal result.";
    }
}

public class Example {
    public static void main(String[] args) {
        final int JOB_COUNT = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> handles = new ArrayList<>();

        //1. Submit the job
        for (int i = 0; i < JOB_COUNT; i++) {
            handles.add(executorService.submit(new MyTask()));
        }

        //6. Cancel a task that's in mid-run
        try {
            Thread.sleep(800);
            handles.get(1).cancel(true);
        } catch (InterruptedException exception) {
            System.out.println("Main thread interrupted!");
        }

        //2. Shutdown pool normally
        executorService.shutdown();

        //3. Shutdown pool forcibly
        //executorService.shutdownNow();

        //4. Wait for things to finish
//        try {
//            executorService.awaitTermination(10, TimeUnit.MINUTES);
//        } catch (InterruptedException ex) {
//            System.out.println("Main thread interrupted!");
//        }

        //5. Receive the results
        System.out.println("All jobs submitted to the pool.");
        while(!handles.isEmpty()) {
            Iterator<Future<String>> futureIterator = handles.iterator();
            while (futureIterator.hasNext()) {
                Future<String> future = futureIterator.next();
                if (future.isDone()) {
                    futureIterator.remove();
                    try {
                        String jobResult = future.get();
                        System.out.println("Got a job result: " + jobResult);
                    } catch (InterruptedException exception) {
                        System.out.println("Main Thread Interrupted!");
                    } catch (ExecutionException executionException) {
                        System.out.println("Job threw an exception: " + executionException.getCause());
                    } catch (CancellationException cancellationException) {
                        System.out.println("Job was cancelled!");
                    }
                }
            }
        }

    }
}
