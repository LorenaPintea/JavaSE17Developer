package module_5.lesson21_reduction_operations_parallelism;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
    private String name;
    private int percent;
    private List<String> courses;

    public Student(String name, int percent, String... courses) {
        this.name = name;
        this.percent = percent;
        this.courses = List.of(courses);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", percent=" + percent +
                ", courses=" + courses +
                '}';
    }
}

public class DownstreamCollecting {
    public static String letterGrade(Student s) {
        int percent = s.getPercent();

        if (percent > 89) return "A";
        if (percent > 79) return "B";
        if (percent > 69) return "C";
        return "D";

    }

    public static void main(String[] args) {
        Stream.of(new Student("Fred", 87, "Math", "Physics"),
                        new Student("Jim", 77, "Art", "Geography"),
                        new Student("Sheila", 95, "Math", "Physics", "Quantum Mechanics", "Astrology"),
                        new Student("Alice", 81, "Math", "Computing"),
                        new Student("Alin", 68, "Music", "Arts"))
                .collect(Collectors.groupingBy(DownstreamCollecting::letterGrade,
                        Collectors.mapping(Student::getName, Collectors.joining(", "))))
                .forEach((k, v) -> System.out.printf("Students with grade %s are %s\n", k, v));


    }
}
