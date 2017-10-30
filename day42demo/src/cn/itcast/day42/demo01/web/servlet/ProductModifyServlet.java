package cn.itcast.day42.demo01.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day42.demo01.damain.Product;
import cn.itcast.day42.demo01.service.ProductService;
import cn.itcast.day42.demo01.service.impl.ProductServiceImpl;
import cn.itcast.day42.demo01.utils.MyBeanUtils;

public class ProductModifyServlet extends HttpServlet{
	private ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求,得到商品信息,并封装在product中
		Product product = new Product();
		MyBeanUtils.populate(product, req.getParameterMap());
		
		//调用业务层方法
		boolean flag = productService.modify(product);
		
		//根据结果设置显示信息
		String msg = flag? "修改成功" : "修改失败";
		req.setAttribute("msg", msg);
		
		//转跳页面到信息页面
		req.getRequestDispatcher("/info.jsp").forward(req, resp);
		
	}

}
