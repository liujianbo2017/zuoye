package com.itheima.test02;

public class AccountWep {
	public static void main(String[] args) {
		AccountService service = new AccountService();
		service.transfer(500, "Jack", "Rose");
	}

}
