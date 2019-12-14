import org.apache.commons.collections.MapUtils;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo6 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("小王", 12, Gender.MALE, Grade.one),
                new Student("小张", 18,Gender.Girl,Grade.one),
                new Student("小刘", 19,Gender.Girl,Grade.three),
                new Student("小李", 13,Gender.MALE,Grade.two),
                new Student("小赵", 20,Gender.MALE,Grade.three),
                new Student("小钱", 11,Gender.Girl,Grade.four),
                new Student("小周", 21,Gender.Girl,Grade.five),
                new Student("小吴", 22,Gender.MALE,Grade.four),
                new Student("小郑", 17,Gender.Girl,Grade.six)
                );
        /*
        得到学生的列表
         */
        TreeSet<Integer> collect = students.parallelStream().map(Student::getAge).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect);
        /*
            统计汇总信息
         */
        IntSummaryStatistics collect1 = students.parallelStream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(collect1);
        /*
        分块
         */
        Map<Boolean, List<Student>> collect2 = students.stream().collect(Collectors.partitioningBy(s -> s.getGender() == Gender.Girl));
        MapUtils.verbosePrint(System.out, "男女学生列表", collect2);

        /*
        分组
         */
        Map<Grade, List<Student>> collect3 = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        MapUtils.verbosePrint(System.out, "班级学生分组", collect3);

        /*
        得到所有班级学生的个数
         */
        Map<Grade, Long> collect4 = students.stream().collect(Collectors.groupingBy(Student::getGrade,Collectors.counting()));
        MapUtils.verbosePrint(System.out, "分组后的个数", collect4);

    }


}

enum Gender{
    MALE,Girl
}
enum Grade{
    one,two,three,four,five,six
}

class Student{

    private String name;
    private Integer age;
    private Gender gender;
    private Grade grade;


    public Student(String name, Integer age , Gender gender,Grade grade) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", grade=" + grade +
                '}';
    }
}