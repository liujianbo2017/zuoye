package cn.itcast.demo01.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo01.damain.Product;
import cn.itcast.demo01.service.ProductService;
import cn.itcast.demo01.service.impl.ProductServiceImpl;

public class ProductGoModifyUIServlet extends HttpServlet{

	private ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求
		String id = req.getParameter("id");
		
		//调用业务层方法,得到商品信息,并保存在域中
		Product product = productService.get(id);
		req.setAttribute("product", product);
		
		//转跳页面
		req.getRequestDispatcher("/modify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
