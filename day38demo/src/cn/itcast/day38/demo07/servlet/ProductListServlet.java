package cn.itcast.day38.demo07.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day38.demo07.domain.Product;
import cn.itcast.day38.demo07.service.ProductService;
import cn.itcast.day38.demo07.service.impl.ProductServiceImpl;

public class ProductListServlet extends HttpServlet {
	//持有Service对象，引用类型为接口类型
	private ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("UTF-8");
		//调用业务逻辑，得到所有商品
		List<Product> list = productService.findAll();
		//把数据保存到域对象中（只显示一次的数据，选择Request域）
		req.setAttribute("products", list);
		//转跳页面
		req.getRequestDispatcher("/demo07/product_list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
