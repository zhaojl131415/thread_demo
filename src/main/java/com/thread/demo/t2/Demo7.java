package com.thread.demo.t2;

import java.util.Arrays;
import java.util.List;

public class Demo7 {

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(10,20,30,40);
        int res = new Demo7().add(values);
        System.out.println("计算的结果为：" + res);


    }



    public int add (List<Integer> values) {
//		values.parallelStream().forEach(System.out :: println);
//		values.parallelStream().forEachOrdered(System.out :: println);
        return values.parallelStream().mapToInt( i -> i * 2).sum();
//        return 0;
    }

}
