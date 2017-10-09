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
		req.setCharacterEncoding("UTF-8");
		Linkman lkm = new Linkman();
		MyBeanUtils.populate(lkm, req.getParameterMap());
		boolean flag = linkmanService.regist(lkm);
		req.setAttribute("linkmans", flag? "保存成功":"保存失败");
		req.getRequestDispatcher("/linkman_save.jsp").forward(req, resp);
	}
	

}
