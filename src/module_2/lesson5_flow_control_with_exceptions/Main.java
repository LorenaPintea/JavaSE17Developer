package module_2.lesson5_flow_control_with_exceptions;

import java.io.IOException;

public class Main {

    private static void tryCatchBlock() {
        try {
            System.out.println("Throwing an exception");
            throw new Exception("Feeling like throwing this exception");
        } catch (IOException ioException) {
            System.out.println("Catching an IOException!");
        } catch (Exception e) {
            System.out.println("Catching an exception of type Exception");
        } finally {
            System.out.println("The exception was cleared so this is always going to execute!!!");
        }
    }

    public static void main(String[] args) {
        tryCatchBlock();
    }
}
