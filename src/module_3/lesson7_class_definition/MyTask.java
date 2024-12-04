package module_3.lesson7_class_definition;

//class MyRunnable implements Runnable {
//
//    @Override
//    public void run() {
//        System.out.println("Hello from MyRunnable!");
//    }
//}

public class MyTask {
    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                System.out.println("Hello from MyRunnable!");
            }
        };
        r.run();
    }
}
