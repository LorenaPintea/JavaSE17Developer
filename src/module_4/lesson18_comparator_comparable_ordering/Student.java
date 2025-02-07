package module_4.lesson18_comparator_comparable_ordering;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student {
    private String name;
    private int percent;

    public Student(String name, int percent) {
        this.name = name;
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public int getPercent() {
        return percent;
    }

    @Override
    public String toString() {
        return "Student: " + name + " has percentage: " + percent;
    }
}

class Ordering {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Fred", 68),
                new Student("Jim", 52),
                new Student("Sheila", 93),
                new Student("Bill", 70),
                new Student("Andy", 82),
                new Student("Fred", 88),
                new Student("Mary", 85)
        ));

        System.out.println("Original order");
        students.forEach(System.out::println);
        System.out.println("-----------------------------");

        System.out.println("Grade order");
        students.sort(Comparator.comparingInt((Student s) -> s.getPercent()));
        students.forEach(System.out::println);
        System.out.println("------------------------------------");

        System.out.println("Name order");
        students.sort(Comparator.comparing((Student s) -> s.getName()));
        students.forEach(System.out::println);
        System.out.println("------------------------------------");

        System.out.println("Name, then grade descending, order");
        students.sort(Comparator.comparing((Student s) -> s.getName()).thenComparing(s -> s.getPercent(), Comparator.reverseOrder()));
        students.forEach(System.out::println);
        System.out.println("------------------------------------");
    }
}
