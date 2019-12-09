import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        String str = "my name is 007";
        /*
        把一个单词长度打印出来
         */
        System.out.println("--------------------filter---------------------");
        Stream.of(str.split(" ")).filter(s -> s.length()>2).forEach(System.out::println);

        /*
           flatMap A - B属性（是个集合）,最终得到的所有的A元素里面所有的B属性的集合
           instream/longStream 并不是Stream的子类,所以要进行装箱boxed
         */
        System.out.println("--------------------flatMap---------------------");
        Stream.of(str.split(" ")).flatMap( s -> s.chars().boxed()).forEach(i -> System.out.println((char)i.intValue()));


        /*
        peek 用于 debug 是一个中间操作和 forEach 是终止操作
         */
        System.out.println("--------------------peek---------------------");
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);

        /*
        limit 使用,主要用于无限
         */
        System.out.println("--------------------limit---------------------");
        List<Integer> list = new ArrayList<>();
        new Random().ints().filter(i -> i > 100 && i < 1000).limit(10).forEach(list::add);
        System.out.println(list);

    }
}
