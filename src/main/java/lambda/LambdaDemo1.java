package lambda;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

/**
 * @author Kui Lian
 * @date 2022/8/14 - 11:07
 * @Description:
 */
public class LambdaDemo1   {
    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            public void run() {
//                System.out.println("lamda1....run");
//            }
//        }).start();

//        //简写
//        new Thread(()->{ System.out.println("demo"); }).start();
//        int i = calculateNum(new IntBinaryOperator() {
//            @Override
//            public int applyAsInt(int left, int right) {
//                return left + right;
//            }
//        });
//        int i = calculateNum((int left,int right)->{
//            return left + right;
//        });
//        System.out.println("i = " + i);
//        printNum((int value)->{
//            return value%2==0;
//        });
        String s1 = typeConver(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "sang";
            }
        });
        System.out.println("s1 = " + s1);
    }
    public static <R> R typeConver(Function<String,R> function){
        String str = "1235";
        R result = function.apply(str);
        return result;
    }
    public static int calculateNum(IntBinaryOperator operator){
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }
    public static void printNum(IntPredicate predicate){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            if(predicate.test(i)){
                System.out.println(i);
            }
        }
    }

}
