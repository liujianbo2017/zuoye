package cn.itcast.day48.demo02;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestJedisPool {
	
	//测试使用了连接池
	public static void main(String[] args) {
		//创建连接池
		//创建连接池对象
		JedisPoolConfig config = new JedisPoolConfig();
		//设置配置信息
		config.setMaxTotal(10);//设置最大连接数
		config.setMaxIdle(3);//设置最大空闲连接的个数
		//使用配置对象创建连接池
		JedisPool pool = new JedisPool(config,"192.168.23.128",6379);
		//从连接池获取连接对象
		Jedis jedis = pool.getResource();
		//执行操作
		String str = jedis.lpop("list2");
		System.out.println(str);
		
		//关闭连接
		jedis.close();
		//关闭连接池
		pool.close();
		
	}

}
