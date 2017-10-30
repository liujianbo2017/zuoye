package cn.itcast.day49.demo07;

import sun.net.spi.nameservice.dns.DNSNameService;

public class TestClassLoader {

	public static void main(String[] args) {
		//打印应用类加载器
		System.out.println("应用类加载器: "+TestClassLoader.class.getClassLoader());
		
		//打印扩展类加载器
		System.out.println("扩展类加载器: "+DNSNameService.class.getClassLoader());
		
		//打印引导类加载器
		System.out.println("引导类加载器: "+String.class.getClassLoader());
	}
}
