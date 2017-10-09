package com.itheima.dbcputils2;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/*
 *  ������: ��ȡ�����ļ���ʽ
 *  BasicDataSourceFactory����: ����������BasicDataSource����
 *  �ô�: ͨ�������ļ�������
 *  BasicDataSourceFactory��ľ�̬����
 *    DataSource createDataSource(Properties prpo) ����ֵ��DataSource�ӿ�
 *     �ڲ�ʵ�ʷ��صľ���return new BasicDataSource()
 *     
 *   ʵ�ʲ���: 
 *      1. ���������ļ�XXX.properties
 *      2. �ļ�����洢��src��
 *           src��binĿ¼��ͬ����
 *      3. ��д�����ļ� �Ĵ���Ϣ
 *      4. ��ȡ����,��ֵ�Դ洢��Properties����
 *      5. BasicDataSourceFactory����BasicDataSource����
 */
public class DBCPUtils {
	//��Աλ��,��������
	private static DataSource dataSource;
	static{
		try{
			//��ȡ�����ļ�src�µ��ļ�
			//��·����,��ļ�������ȡ
			//�κ���,����class�ļ�����,��ȡ��ļ�����getClassLoader()
			//����������getResourceAsStream(String name)�����ֽ�������
			InputStream is = 
					DBCPUtils.class.getClassLoader().getResourceAsStream("database.properties");
				Properties prpo = new Properties();
				prpo.load(is);
				//BasicDataSourceFactory��ľ�̬����createDateSource(����)
				dataSource = BasicDataSourceFactory.createDataSource(prpo);
		}catch(Exception ex){
			throw new  RuntimeException("�ļ���ȡʧ��");
		}
	}
	public static Connection getConnection(){
		try{
			return dataSource.getConnection();
		}catch(Exception ex){
			throw new RuntimeException("���ݿ�����ʧ��");
		}
	}

}
