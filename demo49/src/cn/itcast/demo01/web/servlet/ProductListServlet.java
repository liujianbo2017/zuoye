package cn.itcast.demo01.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo01.damain.Product;
import cn.itcast.demo01.service.ProductService;
import cn.itcast.demo01.service.impl.ProductServiceImpl;

public class ProductListServlet extends HttpServlet {

	private ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//调用业务层方法
		List<Product> list = productService.findAll();
		
		//保存到域中
		req.setAttribute("products", list);
		
		//转跳页面
		req.getRequestDispatcher("/product.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
