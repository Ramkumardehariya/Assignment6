// package Assignment6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Anuj", "Aakash", "Ram", "Shyam", "akku");

        List<String> result = list.stream().filter(a -> a.toUpperCase().startsWith("A")).collect(Collectors.toList());

        System.out.println(result);

    }
}
