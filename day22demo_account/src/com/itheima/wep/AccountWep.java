package com.itheima.wep;

import com.itheima.service.AccountService;

/*
 *  �û���ͼ��
 *  ����ҵ��㷽�� 
 */
public class AccountWep {
	public static void main(String[] args) {
		AccountService service = new AccountService();
		service.transfer("ԭ��ƽ̨", "����", 1000);
	}

}
