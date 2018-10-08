package com.thread.demo.t5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonMain {

    public static void main(String[] args) {


//        Singleton s1 = Singleton.getInstance();
//        Singleton s2 = Singleton.getInstance();
//        Singleton s3 = Singleton.getInstance();
//        Singleton s4 = Singleton.getInstance();
//
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);
//
//        Singleton2 s11 = Singleton2.getInstance();
//        Singleton2 s12 = Singleton2.getInstance();
//        Singleton2 s13 = Singleton2.getInstance();
//        Singleton2 s14 = Singleton2.getInstance();
//
//        System.out.println(s11);
//        System.out.println(s12);
//        System.out.println(s13);
//        System.out.println(s14);


        int pool_length = 20;
        ExecutorService e = Executors.newFixedThreadPool(pool_length);

        for (int i = 0; i < pool_length; i++) {
            e.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + Singleton2.getInstance2());
                }
            });
        }

//        for (int i = 0; i < pool_length; i++) {
//            e.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Singleton.getInstance());
//                }
//            });
//        }

        e.shutdown();

    }

}