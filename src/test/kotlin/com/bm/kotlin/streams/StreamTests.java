package com.bm.kotlin.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamTests {

    @Before
    public void setUp() {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
        System.out.println("set common pool size!");
    }

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

    //测试性能
    @Test
    public void testPerformance() {

        Function<Long, Long> adder = aLong -> aLong * aLong;
        long n = 10_000_000L;

        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        System.out.println(fastest);

    }


}