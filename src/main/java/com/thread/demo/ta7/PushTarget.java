package com.thread.demo.ta7;

public class PushTarget implements Runnable {

	private Tmall3 tmall;

	public PushTarget(Tmall3 tmall) {
		this.tmall = tmall;
	}
	
	@Override
	public void run() {
		while(true) {
			tmall.push();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
