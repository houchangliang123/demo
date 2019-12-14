import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Demo01Test02 {
    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
        //return pre1.test(s) && pre2.test(s);
        return pre1.and(pre2).test(s);//等价于return pre1.test(s) && pre2.test(s);
    }

    public static void main(String[] args) {
        String[] arr01 = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女"};
        final List<String> list = new ArrayList<String>();
        for (String s : arr01) {
            boolean b = checkString(s, (String str) -> {
                return str.split(",")[0].length() == 4;
            }, (String str) -> {
                return str.split(",")[1].equals("女");
            });
            if (b) {
                list.add(s);
            }
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
