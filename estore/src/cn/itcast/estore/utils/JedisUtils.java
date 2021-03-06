package cn.itcast.estore.utils;

import java.io.IOException;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {

	//持有连接池对象
		private static JedisPool pool;
		
		static{
			//读取自定义的配置文件
			Properties prop = new Properties();
			try {
				prop.load( JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties") );
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			int maxTotal = 10;
			int maxIdle = 5;
			int port = 6379;
			
			String host = prop.getProperty("host");
			
			try {
				port = Integer.parseInt(prop.getProperty("port"));
			} catch (Exception e) {}
			try {
				maxTotal = Integer.parseInt(prop.getProperty("maxTotal"));
			} catch (Exception e) {}
			try {
				maxIdle = Integer.parseInt(prop.getProperty("maxIdle"));
			} catch (Exception e) {}
			
			//创建连接池的配置对象
			JedisPoolConfig config = new JedisPoolConfig();
			
			//设置连接池的属性
			config.setMaxTotal(maxTotal);
			config.setMaxIdle(maxIdle);
			
			//使用配置对象创建爱你连接池对象
			pool = new JedisPool(config, host, port);
			
	}
		//从连接池中取得连接对象
		public static Jedis getJedis(){
			return pool.getResource();
		}
}