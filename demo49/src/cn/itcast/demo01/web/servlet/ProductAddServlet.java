package cn.itcast.demo01.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo01.damain.Product;
import cn.itcast.demo01.service.ProductService;
import cn.itcast.demo01.service.impl.ProductServiceImpl;
import cn.itcast.demo01.utils.MyBeanUtils;

public class ProductAddServlet extends HttpServlet{

	private ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求,并封装数据
		Product product = new Product();
		MyBeanUtils.populate(product, req.getParameterMap());
		//调用业务层方法
		boolean flag = productService.add( product );
		
		//返回添加结果
		String msg = flag ? "添加成功":"添加失败";
		req.setAttribute("msg", msg);
		
		//转跳页面
		req.getRequestDispatcher("/info.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
