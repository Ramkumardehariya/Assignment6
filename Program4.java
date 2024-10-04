// package Assignment6;
import java.util.Arrays;
import java.util.List;

public class Program4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,4,5);

        Integer sum = list.stream()
                          .filter(n -> n%2 == 0)
                          .map(n -> n*n)
                          .reduce(0 ,Integer::sum);

        System.out.println("total sum of squres is : "+sum);

    }
}
