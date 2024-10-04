import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Program10 {

    public static Optional<Integer> findMax(List<Integer> list){
        return list.stream().max(Integer::compareTo);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,4,5,7,8,9,0,1,3,4,5,7,8,45,45,43,45,6,77,89,76,33,12,11,11,23);

        Optional<Integer> maxOptional = findMax(list);

        maxOptional.ifPresentOrElse(
        max -> System.out.println("The maximums number is: " + max), 
        () -> System.out.println("there is no any list")
        );

    }

}
