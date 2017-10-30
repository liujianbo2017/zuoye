package cn.itcast.day43.demo01.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day43.demo01.domain.PageBean;
import cn.itcast.day43.demo01.domain.Product;
import cn.itcast.day43.demo01.service.ProductService;
import cn.itcast.day43.demo01.service.impl.ProductServiceImpl;

//案列一   分页显示商品信息
public class ProductListByPageServlet extends HttpServlet {

	private ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求,得到页号,页大小
		int pageNum = 1,  pageSize = 5;
		try{
			pageNum = Integer.parseInt(req.getParameter("pageNum"));
		}catch(Exception e){}
		try{
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		}catch(Exception e){}
		
		//调用业务逻辑，得到指定页数据和其它分页信息封装成的PageBean
		PageBean<Product> pageBean = productService.findByPage( pageNum , pageSize);
		
		//把pageBean保存到request域中
		req.setAttribute("products", pageBean);
		
		//转跳页面进行显示
		req.getRequestDispatcher("/demo01/product_list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
