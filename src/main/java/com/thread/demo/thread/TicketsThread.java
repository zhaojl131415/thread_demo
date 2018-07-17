package com.thread.demo.thread;

class MyThread extends Thread {
    private int ticketsCount = 500; // 一共有500张票

    private String name; //售票点, 也就是线程的名字

    public MyThread(String name) {
//        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        while (ticketsCount > 0) {
            ticketsCount--; // 有票就接着卖一张
            System.out.println(name + "卖了一张票, 剩余票数为:" +ticketsCount);
        }
    }
}

public class TicketsThread {

    public static void main(String[] args) {

        MyThread mt1 = new MyThread("售票窗口1");
        MyThread mt2 = new MyThread("售票窗口2");
        MyThread mt3 = new MyThread("售票窗口3");

        mt1.run();
        mt2.run();
        mt3.run();
    }
}
