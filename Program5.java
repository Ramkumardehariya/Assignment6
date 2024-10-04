// package Assignment6;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Program5 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");

        Predicate<String> predicate = a -> a.length() > 5;
        Predicate<String> predicate2 = a -> a.contains("e");
        Predicate<String> predicate3 = predicate.and(predicate2);

        List<String> list = strings.stream().filter(predicate3).collect(Collectors.toList());

        System.out.println(list);
    }
}
