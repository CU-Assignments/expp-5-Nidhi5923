import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class exp5b {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("John", 82),
            new Student("Emma", 74),
            new Student("Michael", 90),
            new Student("Sophia", 65),
            new Student("David", 78)
        );

        // Filter students scoring above 75%, sort by marks, and print names
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted(Comparator.comparingDouble(s -> -s.marks))
                .map(s -> s.name)
                .forEach(System.out::println);
    }
}
