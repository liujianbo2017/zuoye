package cn.itcast.day44.demo06.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day44.demo06.domain.Keyword;
import cn.itcast.day44.demo06.service.KeywordService;
import cn.itcast.day44.demo06.service.impl.KeywordServiceImpl;
import net.sf.json.JSONArray;

//根据异步提交的关键字搜索相关关键字,实现GoogleSuggest功能
public class KeywordServlet extends HttpServlet {

	private KeywordService keywordService = new KeywordServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求,得到关键字
		String keyword = req.getParameter("keyword");
		
		//调用业务逻辑,搜索相关关键字集合List<Keyword>
		List<Keyword> list = keywordService.findByKeyword( keyword );
		
		//把集合对象转换成JSON字符串
		String json = JSONArray.fromObject(list).toString();
		
		System.out.println(json);
		
		//把JSON发回给浏览器
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);
	}
	

}

