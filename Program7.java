import java.util.function.Function;

public class Program7 {
    public static void main(String[] args) {
        double PI = Math.PI;

        Function<Double, Double> function = radius -> PI * Math.pow(radius, 2);

        double radius = 5.0;
        double area = function.apply(radius);

        System.out.println("The radius is : "+radius+" The area is : "+area);
    }
}
