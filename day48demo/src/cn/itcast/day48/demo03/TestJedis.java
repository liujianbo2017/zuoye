package cn.itcast.day48.demo03;


import java.util.Date;

import redis.clients.jedis.Jedis;

//测试单独使用Jedis,操作Redis数据库
public class TestJedis {

	public static void main(String[] args) {
		//取得连接
		Jedis jedis = new Jedis("192.168.23.128",6379);
		//进行操作,写入
		//User user = new User("guanyu" , "关羽" , true , 20000 , new Date());	
		//使用工具类把对象变成字符数组
		//byte[] data = SerializeUtil.serialize(user);
		//保存在redis中
		//jedis.set("guanyu" .getBytes(), data);
		
		//从数据库中读取出二进制数据,在恢复成对象(反序列化)
		byte[] bytes = jedis.get("guanyu" .getBytes());
		
		User user = (User) SerializeUtil.unserialize(bytes);
		
		System.out.println(user);
		
		//关闭连接
		jedis.close();
	}
}
