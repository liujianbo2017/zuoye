package com.itheima.test03;

public class AccountWep {
	public static void main(String[] args) {
		AccountService service = new AccountService();
		service.transfer("Jack", "Rose", 500);
	}

}
