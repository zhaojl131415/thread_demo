package com.thread.demo.thread;

class MyRunnable implements Runnable {

    private int ticketsCount = 50; // 一共有500张票

    @Override
    public void run() {
        while (ticketsCount > 0) {
            ticketsCount--; // 有票就接着卖一张
            System.out.println(Thread.currentThread().getName() + "卖了一张票, 剩余票数为:" +ticketsCount);
        }
    }
}

public class TicketsRunnable {
    public static void main(String[] args) {
        MyRunnable mr1 = new MyRunnable();
        MyRunnable mr2 = new MyRunnable();
        MyRunnable mr3 = new MyRunnable();
        // 创建三个线程来模拟三个售票窗口
        Thread t1 = new Thread(mr1, "售票窗口1");
        Thread t2 = new Thread(mr2, "售票窗口2");
        Thread t3 = new Thread(mr3, "售票窗口3");

        // 启动三个线程, 也就是三个售票窗口, 开始卖票
        t1.setDaemon(true);
        t1.start();
        t2.start();
        t3.start();
    }

}
