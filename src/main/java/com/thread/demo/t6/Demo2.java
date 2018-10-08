package com.thread.demo.t6;

import java.util.Random;

/**
 * 多个线程执行完毕执行
 */
public class Demo2 {
	
	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {

					System.out.println(Thread.currentThread().getName()+"执行开始...");

					try {
						Thread.sleep(new Random().nextInt(2000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}


					System.out.println(Thread.currentThread().getName()+"执行结束...");
				}
			}).start();
		}


//		if(Thread.activeCount() == 1){
		while (Thread.activeCount() != 1){
			// 自旋
		}
		System.out.println("所有线程执行结束...");


	}

}