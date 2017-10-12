package cn.itcast.day41.demo08.web;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.itcast.day41.demo08.domain.User;
import cn.itcast.day41.demo08.service.UserService;
import cn.itcast.day41.demo08.service.impl.UserServiceImpl;
import cn.itcast.day41.demo08.utils.MailUtils;
//用于在项目启动时监听事件的发送生日邮件的监听器
public class BirthdayMailListener implements ServletContextListener {
	private UserService userService = new UserServiceImpl();
	//当项目启动时，触发ServletContext初始化事件，调用此方法
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//创建定时器对象
		Timer timer = new Timer();
		//对定时器设置任务、延迟、间隔时间
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				//从数据库中取得今天过生日的用户集合
				List<User> list = userService.findBybBirthday();
				//遍历此集合，给每个用户的邮箱发送生日祝福邮件
				for (User user : list) {
					try {
						MailUtils.sendMail(user.getEmail(), "祝您生日快乐", "尊敬的" + user.getName() + "您好，传智播客忠心祝福您生日快乐");
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}, 200, 24*60*60*1000);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
