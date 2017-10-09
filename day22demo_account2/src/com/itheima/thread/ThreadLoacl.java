package com.itheima.thread;

/*
 *  ThreadLocal类存储数据
 *  键,是当前线程,值是自己定义
 *  
 *   set()存储值
 *   get()获取值
 *   remove()移除键值对
 */
public class ThreadLoacl {
	public static void main(String[] args) {
		// 创建ThreadLocal类对象
		ThreadLocal<String> local = new ThreadLocal<String>();
		// 调用方法set存储字符串,存储到ThreadLocal内部Map集合,键是当前线程
		local.set("itheima");
		// 获取值,使用get方法,键还是当前线程
		String s = local.get();
		System.out.println(s);
		
		Runn r = new Runn(local);
		new Thread(r).start();
		

	}

}
