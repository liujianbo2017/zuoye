package cn.itcast.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.estore.domain.PageBean;
import cn.itcast.estore.domain.Product;
import cn.itcast.estore.web.servlet.base.BaseServlet;

//处理商品信息的Servlet
public class ProductServlet extends BaseServlet {

	public String showDetail(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		//接受请求,得到要显示的商品详情的PID
		String pid = req.getParameter("pid");
		
		//调用业务层逻辑,处理请求
		Product product = productService.get(pid);
		
		//保存Ruquest域中
		req.setAttribute("product", product);
		
		//转跳页面
		return "/product_info.jsp";
	}
	
	public String findByCategoryByPage(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
	
		//接受请求,得到页号,页大小 ,分类ID
		int pageNum = 1, pageSize = 12;
		try{
			pageNum = Integer.parseInt(req.getParameter("pageNum"));
		}catch(Exception e){}
		try{
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		}catch(Exception e){}
		String cid = req.getParameter("cid");
		
		//调用业务逻辑,取得指定分类下的指定页的商品并封装成pageBean
		PageBean<Product> bean = productService.findByCategoryByPage( cid , pageNum, pageSize);
		
		//保存到request域中
		req.setAttribute("productPage", bean);
		
		//转跳到product_list.jsp页面进行显示
		return "/product_list.jsp";
	}
}
