package com.itheima.dbcputils2;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/*
 *  工具类: 读取配置文件形式
 *  BasicDataSourceFactory作用: 帮助创建出BasicDataSource对象
 *  好处: 通过配置文件来创建
 *  BasicDataSourceFactory类的静态方法
 *    DataSource createDataSource(Properties prpo) 返回值是DataSource接口
 *     内部实际返回的就是return new BasicDataSource()
 *     
 *   实际步骤: 
 *      1. 创建配置文件XXX.properties
 *      2. 文件建议存储在src下
 *           src和bin目录是同步的
 *      3. 编写配置文件 四大信息
 *      4. 读取出来,键值对存储到Properties集合
 *      5. BasicDataSourceFactory创建BasicDataSource对象
 */
public class DBCPUtils {
	//成员位置,创建变量
	private static DataSource dataSource;
	static{
		try{
			//读取配置文件src下的文件
			//类路径在,类的加载器读取
			//任何类,都有class文件对象,获取类的加载器getClassLoader()
			//加载器方法getResourceAsStream(String name)返回字节输入流
			InputStream is = 
					DBCPUtils.class.getClassLoader().getResourceAsStream("database.properties");
				Properties prpo = new Properties();
				prpo.load(is);
				//BasicDataSourceFactory类的静态方法createDateSource(集合)
				dataSource = BasicDataSourceFactory.createDataSource(prpo);
		}catch(Exception ex){
			throw new  RuntimeException("文件读取失败");
		}
	}
	public static Connection getConnection(){
		try{
			return dataSource.getConnection();
		}catch(Exception ex){
			throw new RuntimeException("数据库连接失败");
		}
	}

}
