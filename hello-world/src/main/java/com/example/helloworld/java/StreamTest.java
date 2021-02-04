package com.example.helloworld.java;

import com.example.helloworld.entity.Student;
import org.junit.Test;

import javax.xml.crypto.KeySelector;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    private static Stream<Integer> limit;

    @Test
    public void test0() {
//        List<Student> list = new ArrayList<>();
//        for(int i = 0; i < 100; i++) {
//            list.add(new Student().setAge(i).setName("小明"));
//        }
//        IntSummaryStatistics summarizing = list.stream().collect(Collectors.summarizingInt(Student::getAge));
//        System.out.println(summarizing);
//        Integer collect = list.stream().collect(Collectors.summingInt(Student::getAge));
//        System.out.println(collect);
        List<Map<Integer, String>> list = new ArrayList<>(10);
        list.forEach(System.out::println);

    }

    /**
     * 测试有状态操作和和无状态操作之间的影响
     */
    @Test
    public void test1() {
        Random random = new Random();
        List<Integer> collect = Stream.generate(random::nextInt)
                .limit(5)
                .peek(e -> System.out.println("peek1=" + e))
                .filter(e -> {
                    System.out.println("filter=" + e);
                    return true;
                })
                .sorted((a, b) -> {
                    System.out.println("sorted=" + a + ", " + b);
                    return a.compareTo(b);
                })
                .peek(e -> System.out.println("peek2=" + e))
                .peek(e -> System.out.println("peek3=" + e))
                .collect(Collectors.toList());


    }


    public static void main(String[] args) {
        limit = Stream.iterate(1, i -> i + 1).limit(1000);
        Stream<Integer> sorted = limit.peek(i -> System.out.println("aa: " + i)).sorted();
        sorted.forEach(System.out::println);
        System.out.println("=========================================================");
        //Stream.iterate(1, i -> i + 1).limit(1000).forEach(System.out::println);
        System.out.println("=========================================================");
        //Stream.generate(() -> new Random().nextInt()).limit(100).forEach(System.out::println);
        IntStream.range(1, 1000).parallel().peek(System.out::println);
    }


}
