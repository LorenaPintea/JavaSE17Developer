package module_8.lesson29_serialization;

import java.io.*;
import java.time.LocalDate;

class MoreData {
    @Override
    public String toString() {
        return "MoreData class";
    }
}

public class MyData implements Serializable {
    private String name;
    private int count;
    private LocalDate date;
    private transient MoreData moreData = new MoreData();

    public MyData(String name, int count, LocalDate localDate) {
        this.name = name;
        this.count = count;
        this.date = localDate;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", date=" + date +
                ", more data=" + moreData +
                '}';
    }

    public static void main(String[] args) throws Throwable {
        MyData myData = new MyData("Fred", 100, LocalDate.now());

        try (ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream("data.ser"));) {

            System.out.println("Writing object: " + myData);
            objectOutputStream.writeObject(myData);

            objectOutputStream.flush();
        }

        try (ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream("data.ser"));) {

            Object read = objectInputStream.readObject();
            MyData myData1 = (MyData)read;

            System.out.println("Read object: " + read);
        }
    }
}
