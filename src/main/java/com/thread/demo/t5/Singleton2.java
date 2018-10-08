package com.thread.demo.t5;

public class Singleton2 {

    // 私有化构造方法
	private Singleton2() {}

	private static volatile Singleton2 instance ;

	/**
	 * 当第一个线程进来之后, 拿到锁开始执行, 之后的线程一直在自旋相当于while(true), 非常消耗cpu资源
	 * 所以不能在方法上加 synchronized
	 * @return
	 */
	public static synchronized Singleton2 getInstance() {
		if(instance == null){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Singleton2();
		}
		return instance;
	}

	/**
	 * 同步代码块
	 * 双重检查加锁
	 * 这种还有指令重排序的问题
	 *
	 * 理想执行顺序:
	 * 1、申请一块内存空间
	 * 2、在这块空简历实例化对象
	 * 3、instance的引用指向这块空间地址
	 *
	 * 现实可能执行顺序: 先执行1, 然后执行3, 最后执行2,
	 * 先执行3 instance已经指向了步骤1申请的内存空间, 也就是说instance不为空了, 不会执行步骤2的实例化
	 *
	 * volatile解决指令重排序问题
	 *
	 * @return
	 */
	public static Singleton2 getInstance2() {
		if(instance == null){
			synchronized (Singleton2.class) {
				// 双重检查加锁
				if (instance == null) {
					instance = new Singleton2();
				}
			}
		}

		return instance;
	}
	
	// 多线程的环境下
	// 必须有共享资源
	// 对资源进行非原子性操作
	
	
}
