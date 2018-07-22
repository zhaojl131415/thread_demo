package com.thread.demo.t4;

/**
 * 饥饿与公平
 *
 * 高优先级吞噬低优先级的CPU时间片
 * 线程被永久堵塞在一个等待进入同步块的状态
 * 等待的线程永远不会被唤醒
 *
 * 线程优先级
 *
 * 如何尽量避免饥饿问题
 * 1. 设置合理的优先级
 * 2. 使用锁来代替synchronized
 */

public class Demo {

    public static void main(String[] args) {
		
		
		Thread t1 =  new Thread(new Target());
		Thread t2 =  new Thread(new Target());
		Thread t3 =  new Thread(new Target());


//		t1.setPriority(1);
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);

		t1.start();
		t2.start();
		t3.start();

		// 高优先级吞噬低优先级的CPU时间片
//		for (int i = 0; i < 15; i++) {
//			Thread t =  new Thread(new Target());
//			t.setPriority(i == 0 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY);
//			t.start();
//		}

	}

}

class Target implements Runnable {
	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + " ...");
		}
	}
}