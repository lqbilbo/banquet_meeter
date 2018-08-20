package com.bm.kotlin.streams;

import com.google.common.collect.Lists;
import org.jetbrains.annotations.NotNull;
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

        //初始化16个Person对象
        Init init = new Init().invoke();
        //将person对象放入list中
        List<Person> list = getPersonList(init);

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

    @NotNull
    private List<Person> getPersonList(Init init) {
        Person person1 = init.getPerson1();
        Person person2 = init.getPerson2();
        Person person3 = init.getPerson3();
        Person person4 = init.getPerson4();
        Person person5 = init.getPerson5();
        Person person6 = init.getPerson6();
        Person person7 = init.getPerson7();
        Person person8 = init.getPerson8();
        Person person11 = init.getPerson11();
        Person person12 = init.getPerson12();
        Person person13 = init.getPerson13();
        Person person14 = init.getPerson14();
        Person person15 = init.getPerson15();
        Person person16 = init.getPerson16();
        Person person17 = init.getPerson17();
        Person person18 = init.getPerson18();

        return new ArrayList<>(Arrays.asList(person1,person2,person3,person4,person5,person6,
                person7,person8,person11,person12,person13,person14,person15,person16,
                person17,person18));
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


    private class Init {
        private Person person1;
        private Person person2;
        private Person person3;
        private Person person4;
        private Person person5;
        private Person person6;
        private Person person7;
        private Person person8;
        private Person person11;
        private Person person12;
        private Person person13;
        private Person person14;
        private Person person15;
        private Person person16;
        private Person person17;
        private Person person18;

        public Person getPerson1() {
            return person1;
        }

        public Person getPerson2() {
            return person2;
        }

        public Person getPerson3() {
            return person3;
        }

        public Person getPerson4() {
            return person4;
        }

        public Person getPerson5() {
            return person5;
        }

        public Person getPerson6() {
            return person6;
        }

        public Person getPerson7() {
            return person7;
        }

        public Person getPerson8() {
            return person8;
        }

        public Person getPerson11() {
            return person11;
        }

        public Person getPerson12() {
            return person12;
        }

        public Person getPerson13() {
            return person13;
        }

        public Person getPerson14() {
            return person14;
        }

        public Person getPerson15() {
            return person15;
        }

        public Person getPerson16() {
            return person16;
        }

        public Person getPerson17() {
            return person17;
        }

        public Person getPerson18() {
            return person18;
        }

        public Init invoke() {
            person1 = new Person("lixia", 18, 120.0, "女");
            person2 = new Person("wangwu", 20, 122.0, "女");
            person3 = new Person("zhangsan", 14, 133.0, "男");
            person4 = new Person("sihuang", 13, 99.0, "女");
            person5 = new Person("banao", 22, 122.0, "女");
            person6 = new Person("jiumu", 28, 150.0, "男");
            person7 = new Person("lilang", 33, 120.0, "男");
            person8 = new Person("xingfang", 38, 110.0, "女");
            person11 = new Person("banamu", 40, 190.0, "男");
            person12 = new Person("huangzhe", 11, 100.0, "女");
            person13 = new Person("zhangxiao", 23, 125.0, "女");
            person14 = new Person("mala", 22, 108.0, "男");
            person15 = new Person("dongfu", 19, 99.0, "女");
            person16 = new Person("weina", 29, 130.0, "女");
            person17 = new Person("xizi", 46, 150.0, "男");
            person18 = new Person("wanglu", 20, 109.0, "女");
            return this;
        }
    }
}