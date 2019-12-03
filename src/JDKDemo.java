import java.util.function.Function;

public class JDKDemo {

    public void aaa(Function<Object,String> interface1) {
        System.out.println(interface1.apply("afhbhnh"));
    }
    public static void main(String[] args) {
        System.out.println("ssss");
        JDKDemo jdkDemo = new JDKDemo();
        jdkDemo.aaa(a -> a+"a");
    }
}
interface Interface1<T>{
    public abstract T a(String a);

    public default int b(int x){
        return x+1;
    }
}
