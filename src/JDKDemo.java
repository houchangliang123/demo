import javax.print.DocFlavor;
import java.util.function.Consumer;
import java.util.function.Function;

public class JDKDemo {

    public void aaa(Function<String,Object> interface1) {
        String str = "222";

//        str = "";
        Consumer<String> stringConsumer = s -> System.out.println(s + str);

        System.out.println(interface1.apply("afhbhnh"));
    }
    public static void main(String[] args) {
        System.out.println("ssss");
        JDKDemo jdkDemo = new JDKDemo();
        Function<String,Object> interface1 = a -> a + 1234;
        /*

         */
//        jdkDemo.aaa(interface1.andThen( b -> (String)b + 1234));
        Interface1<String> interface11 = a -> a+2;

        System.out.println(interface11.a("2"));

    }
}
interface Interface1<T>{
    public abstract T a(String a);

    public default int b(int x){
        return x+1;
    }
}
