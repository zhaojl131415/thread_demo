package com.thread.demo.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

        DemoService ds = ac.getBean(DemoService.class);

        ds.a();
        ds.b();
    }
}
