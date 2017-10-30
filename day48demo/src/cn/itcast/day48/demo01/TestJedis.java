package cn.itcast.day48.demo01;

import redis.clients.jedis.Jedis;

//测试单独使用Jedis，操作Redis数据库
public class TestJedis {
	public static void main(String[] args) {
		
		//取的连接
		Jedis jedis = new Jedis("192.168.23.128",6379);
		
		//进行操作
		jedis.set("hello", "大家好，这是用Jeids保存到Redis中的字符串！");
		//直接打印
		System.out.println(jedis.get("hello"));
		
		//关闭连接
		jedis.close();
		
	}

}
