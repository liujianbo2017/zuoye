package cn.itcast.day41.demo06;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	public static void main(String[] args) {
		// 创建Timer对象
		Timer timer = new Timer();
		System.out.println("开始设置定时任务" + System.currentTimeMillis());

		// 调用方法设置任务及延迟时间及周期
		timer.scheduleAtFixedRate(new TimerTask() {
			//直接使用匿名内部类的方法创建定时器,并实现run方法
			//也就是在指定的时间内执行这段代码
			@Override
			public void run() {
				System.out.println("执行定时任务"+System.currentTimeMillis());

			}
		}, 200, //执行语句200毫秒后开始周期执行
				5 * 1000);//执行周期为5秒
	}
}
