package com.example.helloworld.java;

import com.example.helloworld.entity.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void test0() {
        List<Student> list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            list.add(new Student().setAge(i).setName("小明"));
        }
        IntSummaryStatistics summarizing = list.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(summarizing);
        Integer collect = list.stream().collect(Collectors.summingInt(Student::getAge));
        System.out.println(collect);

    }

    public static void main(String[] args) {
        Stream.iterate(1, i -> i + 1).limit(1000).peek(i -> System.out.println("aa: " + i)).sorted().forEach(System.out::println);
        System.out.println("=========================================================");
        //Stream.iterate(1, i -> i + 1).limit(1000).forEach(System.out::println);
        System.out.println("=========================================================");
        //Stream.generate(() -> new Random().nextInt()).limit(100).forEach(System.out::println);
        IntStream.range(1, 1000).parallel().peek(System.out::println);
    }


}
