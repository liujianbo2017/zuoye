package cn.itcast.demo01.utils;

import java.util.UUID;

public class UUIDUtils {
	public static String generateID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

}
