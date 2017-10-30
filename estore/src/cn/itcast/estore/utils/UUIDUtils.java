package cn.itcast.estore.utils;

import java.security.MessageDigest;
import java.util.UUID;

import sun.misc.BASE64Encoder;

public class UUIDUtils {

	//生成ID的工具方法（得到一个32位的随机且唯一的字符串，当ID用）
	public static String generateID(){
		//因为36位结果中含四个减号，所以可以去掉，数据库中保存32位
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	//生成64位激活码
	public static String generateCode(){
		return generateID()+generateID();
	}
	
	//MD5加密方法
		public static String md5(String str) throws Exception{
			MessageDigest md5=MessageDigest.getInstance("MD5");
	        BASE64Encoder base64en = new BASE64Encoder();
	        //加密后的字符串
	        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
	        return newstr;
		}
}
