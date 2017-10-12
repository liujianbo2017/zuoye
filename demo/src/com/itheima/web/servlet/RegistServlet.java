package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Linkman;
import com.itheima.service.LinkmanService;
import com.itheima.utils.MyBeanUtils;

public class RegistServlet extends HttpServlet{
	private LinkmanService linkmanService = new LinkmanService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码
		req.setCharacterEncoding("UTF-8");
		//创建Linkman对象
		Linkman lkm = new Linkman();
		//调用MyBeanUtils方法将lkm封装到Linkman中
		MyBeanUtils.populate(lkm, req.getParameterMap());
		//调用业务层方法
		boolean flag = linkmanService.regist(lkm);
		//解决中文乱码问题
		resp.setContentType("text/html; charset=UTF-8");
		//打印注册结果
		resp.getWriter().write("保存成功");
	}
	

}
