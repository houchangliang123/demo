import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo5 {
    public static void main(String[] args) throws InterruptedException {
        /*
        调用parallel产生一个并行流
         */
//        IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count();
        /*
        调用parallel产生一个并行流,在串行
        多次调用穿行和并行（parallel/sequential）,以最后一次调用为准
         */
//        IntStream.range(1,100).parallel().peek(StreamDemo5::debug).sequential().peek(StreamDemo5::debug1).count();
        /*
            并行流使用的线程池：ForkJoinPool
            默认的线程数量 当前的cpu个数
            使用这个属性可以修改默认的线程数 java.util.concurrent.ForkJoinPool.common.parallelism
         */
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");

//        IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count();

        /*
        使用自己的线程池，不使用默认的线程池，防止任务阻塞
         */
        ForkJoinPool pool = new ForkJoinPool(20);
        pool.submit(() -> IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count());
        pool.shutdown();
        Thread.currentThread().join();
    }

    private static void debug1(int i) {

        System.out.println(" debug 2" + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void debug(int i) {
        System.out.println(Thread.currentThread().getName()+" debug " + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
