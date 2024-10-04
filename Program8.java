import java.util.function.BiFunction;

public class Program8 {
    public static void main(String[] args) {
        BiFunction<String,String,String> biFunction = (str1,str2) -> str1+" "+str2;

        String first = "Hello";
        String second = "World";

        String result = biFunction.apply(first, second);

        System.out.println(result);
    }
}
