package com.thread.demo.thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

class MyDaemonThread implements Runnable {
    @Override
    public void run() {
        System.out.println("进入守护线程:" + Thread.currentThread().getName());
        try {
            writeToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("退出守护线程:" + Thread.currentThread().getName());
    }

    private void writeToFile() throws Exception{
        File file = new File("/Users/zhaojinliang/Documents/"+ "daemon.txt");
        OutputStream os = new FileOutputStream(file, true);
        int count = 0;
        while (count < 999) {
            os.write(("\r\nword:"+count).getBytes());
            System.out.println("守护线程:" + Thread.currentThread().getName() + "向文件中写入了word:" + count);
            count++;
            Thread.sleep(1000);
        }
    }
}

public class DaemonThread {

    public static void main(String[] args) {
        System.out.println("进入主线程:" + Thread.currentThread().getName());
        MyDaemonThread my = new MyDaemonThread();
        Thread t1 = new Thread(my);
        t1.setDaemon(true);
        t1.start();

        Scanner sc = new Scanner(System.in);
        sc.next();


        System.out.println("退出主线程:" + Thread.currentThread().getName());


    }

}
