import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        String str = "my name is 007";
        /*
        使用并行流
         */
        str.chars().parallel().forEach(i -> System.out.println((char) i));
        System.out.println("_____________forEachOrdered_____________");
         /*
        使用 forEachOrdered 可以保证顺序
         */
        str.chars().parallel().forEachOrdered(i -> System.out.println((char)i));

        /*
        收集器 collect
         */
        List<String> collect = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(collect);
        /*
            使用 reduce 拼接字符串
         */

        Optional<String> reduce = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce.orElse(""));

        Integer reduce1 = Stream.of(str.split(" ")).map(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(reduce1);

        Optional<String> max = Stream.of(str.split(" ")).max((s1, s2) -> s1.length() - s2.length());
        System.out.println(max.orElse("-1"));

        OptionalInt first = new Random().ints().findFirst();
        System.out.println(first.getAsInt());
    }
}
