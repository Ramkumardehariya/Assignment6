// package Assignment6;

interface SumInterFace{
    int sum(int a,int b);
}

public class Problem1 {
    public static void main(String[] args) {
        SumInterFace add = (a, b) -> a+b;

        int result = add.sum(2, 4);

        System.out.println("sum is: " + result);
    }
}
