package com.thread.demo.ta7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tmall3 {
	
	private int count;

	Lock lock = new ReentrantLock();
	Condition ct = lock.newCondition();
	Condition cp = lock.newCondition();

	public final int MAX_COUNT = 10;
	
	public void push () {
		lock.lock();
		while(count >= MAX_COUNT) {
			try {
				System.out.println(Thread.currentThread().getName() + " 库存数量达到上限, 生产者停止生产");
				cp.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count ++;
		System.out.println(Thread.currentThread().getName() + " 生产者生产, 当前库存为: " + count);
		ct.signal();
		lock.unlock();
	}
	
	public void take () {
		lock.lock();
		while(count <= 0) {
			try {
				System.out.println(Thread.currentThread().getName() + " 库存数量为0, 消费者等待");
				ct.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count --;
		System.out.println(Thread.currentThread().getName() + " 消费者消费, 当前库存为:" + count);
		cp.signal();
		lock.unlock();
	}

}
