package module_3.lesson12_inheritance;

sealed interface Vehicle permits Car, Truck, Bycicle {
    default void add(String item) {
        System.out.println("Adding " + item + " to " + this);
    }
}

final class Car implements Vehicle {
    private int seats;

    public Car(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seats=" + seats +
                '}';
    }
}

non-sealed class Truck implements Vehicle /* permits SemiTruck */ {
    private int payload;

    public Truck(int payload) {
        this.payload = payload;
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "payload=" + payload +
                '}';
    }
}

//final class SemiTruck extends Truck {
//
//    public SemiTruck(int payload) {
//        super(payload);
//    }
//}

final class Bycicle implements Vehicle {
}

public class Main {

    public static boolean canCarry(Vehicle v, int weight) {
        boolean ok = true;
        if (v instanceof Truck t) {
            ok = t.getPayload() >= weight;
        } else if (v instanceof Car c) {
            ok = (c.getSeats() - 1) * 170 >= weight;
        } else if (v instanceof Bycicle b) {
            ok = false;
        }
        return ok;
    }

    public static void main(String[] args) {
        System.out.println("10.000 kg truck can carry 20.000 kg? " + canCarry(new Truck(10000), 20000));
        System.out.println("10.000 kg truck can carry 2.000 kg? " + canCarry(new Truck(10000), 2000));
        System.out.println("Five seat car can carry 2.000 kg? " + canCarry(new Car(5), 2000));
        System.out.println("Bycilec can carry 20 kg? " + canCarry(new Bycicle(), 20));

    }
}
