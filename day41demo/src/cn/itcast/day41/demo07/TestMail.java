package cn.itcast.day41.demo07;

import javax.mail.MessagingException;

public class TestMail {
	public static void main(String[] args) {
		try {
			MailUtils.sendMail("" ,"这是测试邮件主题","这是邮件内容");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
