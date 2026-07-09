import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private int course;

    public Student(String name, int age, int course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getCourse() { return course; }

    @Override
    public String toString() {
        return String.format("Student{name='%s', age=%d, course=%d}", name, age, course);
    }
}

public class Task2 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 20, 1),
            new Student("Bob", 22, 1),
            new Student("Charlie", 21, 2),
            new Student("David", 23, 2),
            new Student("Eve", 24, 2),
            new Student("Frank", 19, 3),
            new Student("Grace", 20, 3),
            new Student("Henry", 22, 3)
        );

        Map<Integer, Double> averageAgeByCourse = students.stream()
            .collect(Collectors.groupingBy(
                Student::getCourse,
                Collectors.averagingInt(Student::getAge)
            ));

        averageAgeByCourse.forEach((course, avgAge) -> 
            System.out.printf("Курс %d: средний возраст = %.2f%n", course, avgAge)
        );
    }
}