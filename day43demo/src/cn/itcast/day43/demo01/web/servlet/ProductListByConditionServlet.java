package cn.itcast.day43.demo01.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day43.demo01.domain.Category;
import cn.itcast.day43.demo01.domain.Product;
import cn.itcast.day43.demo01.service.CategoryService;
import cn.itcast.day43.demo01.service.ProductService;
import cn.itcast.day43.demo01.service.impl.CategoryServiceImpl;
import cn.itcast.day43.demo01.service.impl.ProductServiceImpl;
import cn.itcast.day43.demo01.utils.MyBeanUtils;

//进行条件查询的Servlet
public class ProductListByConditionServlet extends HttpServlet {

	private ProductService productService = new ProductServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//从ServletCondition中取出所有的分类,如果不存在则调用业务逻辑从数据库中取得
		@SuppressWarnings("unchecked")
		List<Category> categorys = (List<Category>) getServletContext().getAttribute("allCategorys");
		if(categorys == null || categorys.isEmpty()){
			categorys = categoryService.findAll();
			getServletContext().setAttribute("allCategorys", categorys);
		}
		
		//接受请求,得到数据并封装
		Product condition = new Product();
		MyBeanUtils.populate(condition, req.getParameterMap());
		
		//调用业务逻辑,根据查询条件,得到符合条件的商品集合List<Product>
		List<Product> list = productService.findAllCondition( condition );
		
		//把商品集合和封装了查询条件的对象保存到Request域中
		req.setAttribute("products", list);
		req.setAttribute("condition", condition);
		
		//转跳页面,/demo02/search.jsp
		req.getRequestDispatcher("/demo02/search.jsp").forward(req, resp);
	}

}
