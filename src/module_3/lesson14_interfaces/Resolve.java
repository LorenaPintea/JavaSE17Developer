package module_3.lesson14_interfaces;

interface IV {
   default void doStuff(){};
}

interface IW {
    void doStuff();
}

class A2 implements IV, IW {
    @Override
    public void doStuff() {
        System.out.println("A2.doStuff()");
    }
}

public class Resolve {
    public static void main(String[] args) {
        new A2().doStuff();
    }
}
