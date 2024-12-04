package module_3.lesson7_class_definition;

abstract class MyRunnable2 implements Runnable {
    String message;
    MyRunnable2(String message) {this.message = message;}
}

public class MyTask2 {
    public static void main(String[] args) {
        MyRunnable2 runnable2 = new MyRunnable2("Aloha") {
            @Override
            public void run() {
                System.out.println("subclass of MyRunnable, message is " + message);
            }
        };

        runnable2.run();
    }
}
