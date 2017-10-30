package cn.itcast.estore.web.servlet.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.estore.domain.Product;
import cn.itcast.estore.service.CartService;
import cn.itcast.estore.service.CategoryService;
import cn.itcast.estore.service.OrderService;
import cn.itcast.estore.service.ProductService;
import cn.itcast.estore.service.UserService;
import cn.itcast.estore.service.impl.CartServiceImpl;
import cn.itcast.estore.service.impl.CategoryServiceImpl;
import cn.itcast.estore.service.impl.OrderServiceImpl;
import cn.itcast.estore.service.impl.ProductServiceImpl;
import cn.itcast.estore.service.impl.UserServiceImpl;

//所有Servlet的基类,持有所有的Service,进行动态的方法分发,减少Servlet的数据,让一个Servlet可以处理多种请求
public class BaseServlet extends HttpServlet{

	//持有所有的Service
	protected ProductService productService = new ProductServiceImpl();
	protected UserService userService = new UserServiceImpl();
	protected CategoryService categoryService = new CategoryServiceImpl();
	protected CartService cartService = new CartServiceImpl();
	protected OrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//由页面提交额方法名,也就是说,当用户要发送一个请求时,除了本身要提交的参数为,还要多提交一个method,值为要分发的方法名
		String methodName = req.getParameter("method");
		
		if(methodName==null || "".equals(methodName)){
			//如果提交的方法名为空,则执行默认方法execute(执行)
			methodName = "execute";
		}
		//使用反射机制,得到提交的额同名方法对象,调用该方法
		//因为要得到的方法时属于子类的,本类是父类,实际运行时,当前对象this就是本类对象
		Class clazz = this.getClass();
		
		try {
			//得到的提交的方法名所对应的方法对象
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			
			//调用制定的方法,返回要跳转的页面的路径(如果需要内部转发,则此路径不是以项目名开头,如果是重定向,则此路径是以项目名开头)
			String path = (String) method.invoke(this, req,resp);
			
			if(path!=null){
				//判断返回的路径是否是以项目名开头
				if(path.startsWith(req.getContextPath())){
					//以项目名开头,使用重定向
					resp.sendRedirect(path);
				}else{
					//不是以项目名开头,使用内部转发
					req.getRequestDispatcher(path).forward(req, resp);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//默认方法,当没有提交的方法名时,执行此方法,可以被子类重写
	public String execute(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		/*//从ServletContext域中取出分类信息
		List<Category> categorys = (List<Category>)getServletContext().getAttribute("allCategory");
		//判断是否为空
		if( categorys == null || categorys.isEmpty() ){
			//如果为空，则调用业务逻辑，从关系型数据库中取得分类信息，并保存到ServletContext域中
			categorys = categoryService.findAll();
			getServletContext().setAttribute("allCategorys", categorys);
		}*/
		//调用业务逻辑,取得热门商品
		List<Product> hots = productService.findHots();
		//调用业务逻辑,取得热门商品
		List<Product> news = productService.findNews();
		
		//保存到域中
		req.setAttribute("hots", hots);
		req.setAttribute("news", news);
		//默认方法,转跳到首页
		return "/index.jsp";
	}

}
