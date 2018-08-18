package com.bm.kotlin.streams;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTests {

    /*@Before
    public void setUp() {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
        System.out.println("set common pool size!");
    }*/

    @Test
    public void testParallel() {

        /* 实例化列表中的对象*/
        //size = 16
        Person person1 = new Person("lixia", 18, 20.0, "女");
        Person person2 = new Person("lixia", 18, 20.0, "女");
        Person person3 = new Person("lixia", 18, 20.0, "女");
        Person person4 = new Person("lixia", 18, 20.0, "女");
        Person person5 = new Person("lixia", 18, 20.0, "女");
        Person person6 = new Person("lixia", 18, 20.0, "女");
        Person person7 = new Person("lixia", 18, 20.0, "女");
        Person person8 = new Person("lixia", 18, 20.0, "女");
        Person person11 = new Person("lixia", 18, 20.0, "女");
        Person person12 = new Person("lixia", 18, 20.0, "女");
        Person person13 = new Person("lixia", 18, 20.0, "女");
        Person person14 = new Person("lixia", 18, 20.0, "女");
        Person person15 = new Person("lixia", 18, 20.0, "女");
        Person person16 = new Person("lixia", 18, 20.0, "女");
        Person person17 = new Person("lixia", 18, 20.0, "女");
        Person person18 = new Person("lixia", 18, 20.0, "女");

        List<Person> list = new ArrayList<>(Arrays.asList(person1,person2,person3,person4,person5,person6,
                person7,person8,person11,person12,person13,person14,person15,person16,
                person17,person18));

        // 1 使用ArrayList
        List<Person> result = new ArrayList<>();
        // 2 使用SynchronizedList
//         List<Person> result = Collections.synchronizedList(new ArrayList<>());
        // 3 使用CopyOnWriteArrayList
//         List<Person> result = new CopyOnWriteArrayList<>();

        /*System.out.println("pause for 5 min...");
        Thread.sleep(5000);*/


        //同步可以吗？
        synchronized(this) {
            list.stream().parallel().forEach(e -> {
                //null判断有用吗？
                System.out.println(Thread.currentThread().getName());
                if (e != null) {
//                synchronized (e) {
                    result.add(e);
//                }
                }
            });
        }
        result.forEach(e -> System.out.println(e + ""));
        System.out.println("size: " + result.size());
    }

    class Person {

        String name;
        int age;
        double weight;
        String sex;

        public Person() {
        }

        public Person(String name, int age, double weight, String sex) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.sex = sex;
        }
    }

    @Test
    public void testParallel2() {
        Long result = Stream.iterate(1L, i -> i+1).limit(10000).parallel().reduce(0L, Long::sum);
        System.out.println(result);
    }

    //测试性能请移步lambdainaction项目

    @Test
    public void testIntermediateStateless() {
        List<String> list = Lists.newArrayList("bcd", "cde", "def", "abc");
        List<String> result = list.stream()
                .filter(e -> e.length() >= 3)
                .map(e -> String.valueOf(e.charAt(0)))
                .collect(Collectors.toList());
        System.out.println("--------------------------");
        System.out.println(result);
    }

    @Test
    public void testParallelIntermediateStateless() {
        List<String> list = Lists.newArrayList("bcd", "cde", "def", "abc");
        List<String> result = list.stream()
                .parallel()
                .filter(e -> e.length() >= 3)
                .sorted()
                .map(e -> String.valueOf(e.charAt(0)))
                .collect(Collectors.toList());
        System.out.println("--------------------------");
        System.out.println(result);
    }

    @Test
    public void testForeach() {
        List<String> list = Lists.newArrayList("bcd", "cde", "def", "abc");
        List<String> result = Lists.newArrayListWithCapacity(list.size());
        for (String str : list) {
            if (str.length() >= 3) {
                char e = str.charAt(0);
                String tempStr = String.valueOf(e);
                result.add(tempStr);
            }
        }
        System.out.println("--------------------------");
        System.out.println(result);
    }



}