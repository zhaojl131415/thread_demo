package com.thread.demo.ta7;

public class TakeTarget implements Runnable {
	
	private Tmall3 tmall;
	
	public TakeTarget(Tmall3 tmall) {
		this.tmall = tmall;
	}

	@Override
	public void run() {
		while(true) {
			tmall.take();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
