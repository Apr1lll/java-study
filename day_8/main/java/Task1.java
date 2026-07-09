import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
            "I love Java programming",
            "Python is great",
            "Java Streams are powerful",
            "JavaScript is popular",
            "Learning java",
            "C++ is fast"
        );

        String substring = "java";

        strings.stream()
            .filter(s -> s.toLowerCase().contains(substring.toLowerCase()))
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}