import java.util.function.Function;
/*
   级联表达式和柯里化
 */
public class CurryDemo {
    public static void main(String[] args) {
       Function<Integer,Function<Integer,Integer>> function =  x -> y -> x + y;
        System.out.println(function.apply(2).apply(3));
    }
}
