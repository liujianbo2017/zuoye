package com.itheima.thread;

/*
 *  ThreadLocal��洢����
 *  ��,�ǵ�ǰ�߳�,ֵ���Լ�����
 *  
 *   set()�洢ֵ
 *   get()��ȡֵ
 *   remove()�Ƴ���ֵ��
 */
public class ThreadLoacl {
	public static void main(String[] args) {
		// ����ThreadLocal�����
		ThreadLocal<String> local = new ThreadLocal<String>();
		// ���÷���set�洢�ַ���,�洢��ThreadLocal�ڲ�Map����,���ǵ�ǰ�߳�
		local.set("itheima");
		// ��ȡֵ,ʹ��get����,�����ǵ�ǰ�߳�
		String s = local.get();
		System.out.println(s);
		
		Runn r = new Runn(local);
		new Thread(r).start();
		

	}

}
