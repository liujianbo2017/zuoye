package cn.itcast.day44.demo04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class TestJsonLibServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//User user = new User("user001","楚风",true,2999,new Date());
		//把对象转换成JSON
		//String json = JSONObject.fromObject(user).toString();
		List<User> list = new ArrayList<User>();
		
		list.add(new User("user001","楚风",true,2999.0,new Date()));
		list.add(new User("user002","林动",true,3000.0,new Date()));
		
		String json = JSONArray.fromObject(list).toString();
		System.out.println(json);
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
