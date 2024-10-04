


@FunctionalInterface
interface CalCulateSquare{
    int calCulateSquare1(int a);

    default void print(int num){
        int square = calCulateSquare1(num);
        
        System.out.println("The num is: "+ num + " The square is : " + square);
    };
}

public class Program9 {
    public static void main(String[] args) {

        CalCulateSquare calCulateSquare = a -> a*a;

        calCulateSquare.print(5);
    }
}
