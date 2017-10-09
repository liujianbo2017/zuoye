package com.itheima.wep;

import com.itheima.service.AccountService;

/*
 *  用户视图层
 *  调用业务层方法 
 */
public class AccountWep {
	public static void main(String[] args) {
		AccountService service = new AccountService();
		service.transfer("原兽平台", "楚风", 1000);
	}

}
