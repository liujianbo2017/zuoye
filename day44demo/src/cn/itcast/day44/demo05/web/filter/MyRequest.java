package cn.itcast.day44.demo05.web.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper{

	public MyRequest(HttpServletRequest request) {
		super(request);
	}
	public String getParameter(String name){
		//先得到原始值,如果请求的方式是post,则直接返回原始值
		String value = super.getParameter(name);
		//判断请求方式是不是get
		if("get".equalsIgnoreCase(super.getMethod())){
			//如果当前请求方式为get,则当使用者调用parameter时,则对原始值进行重新编码
			try {
				new String(value.getBytes("ISO-8859-1"),("utf-8")).toString();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
	}

}
