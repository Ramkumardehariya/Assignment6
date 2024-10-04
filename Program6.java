import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Program6 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Anuj", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape");

        Consumer<String> consumer1 = a -> System.out.println(a.toUpperCase());

        strings.forEach(consumer1);
    }
}
