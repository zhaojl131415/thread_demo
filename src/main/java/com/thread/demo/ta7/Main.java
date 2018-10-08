package com.thread.demo.ta7;

public class Main {
	
	public static void main(String[] args) {
		
		Tmall tmall = new Tmall();
		Tmall3 tmall3 = new Tmall3();

		PushTarget p = new PushTarget(tmall3);
		TakeTarget t = new TakeTarget(tmall3);
		
		new Thread(p).start();
		new Thread(p).start();
		new Thread(p).start();
		new Thread(p).start();
		new Thread(p).start();
		
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		
		
	}
	
}
