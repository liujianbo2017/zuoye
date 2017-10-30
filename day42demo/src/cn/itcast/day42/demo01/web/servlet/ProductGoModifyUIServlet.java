package cn.itcast.day42.demo01.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day42.demo01.damain.Product;
import cn.itcast.day42.demo01.service.ProductService;
import cn.itcast.day42.demo01.service.impl.ProductServiceImpl;

public class ProductGoModifyUIServlet extends HttpServlet{
	private ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求
		String id = req.getParameter("id");
		
		//调用业务层方法,根据商品id得到商品对象
		Product product = productService.get(id);
		
		//把商品对象保存到域中
		req.setAttribute("product",product);
		
		//转跳页面,内部转发到修改页面
		req.getRequestDispatcher("/modify.jsp").forward(req, resp);
	}

}
