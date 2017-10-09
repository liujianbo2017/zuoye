package com.itheima.wep;

import com.itheima.service.AccountService;

public class AccountWep {
		public static void main(String[] args) {
			AccountService service = new AccountService();
			service.transfer("原兽平台", "楚风", 1000);
		}

}
