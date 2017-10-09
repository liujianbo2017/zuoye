package com.itheima.thread;

public class Runn implements Runnable{
	private ThreadLocal<String> local = new ThreadLocal<String>();

	public Runn(ThreadLocal<String> loacl) {
		this.local = loacl;
	}

	public void run() {
		String s = local.get();
		System.out.println("===" + s);
	}

}
