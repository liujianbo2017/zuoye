package cn.itcast.demo01.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo01.service.ProductService;
import cn.itcast.demo01.service.impl.ProductServiceImpl;


public class ProductDeleteServlet extends HttpServlet {

	private ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求
		String id = req.getParameter("id");
		
		//调用业务层方法,处理请求
		boolean flag = productService.remove(id);
		
		//根据处理结果,设置要显示的内容,并保存域中
		String msg = flag ? "删除成功":"删除失败";
		req.setAttribute("msg", msg);
		
		//转跳页面
		req.getRequestDispatcher("/info.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
