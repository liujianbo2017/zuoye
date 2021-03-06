package cn.itcast.demo01.web.filter;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {

	public MyRequest(HttpServletRequest request) {
		super(request);
	}
	public String getParameter(String name){
		//先得到原始值，如果提交方式为POST，则直接返回原始值
		String value = super.getParameter(name);
		//判断当前请求的提交方式为GET
		if("get".equalsIgnoreCase(super.getMethod())){
			//如果当前请求为GET方式，则当使用者调用getParameter方法时，则对原始值进行重新编码
			try {
				new String(value.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
	}
	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		if("get".equalsIgnoreCase(super.getMethod())){
			for (int i = 0; i < values.length; i++) {
				try {
					new String(values[i].getBytes("ISO-8859-1"),"UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return values;
	}
	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String,String[]> map = super.getParameterMap();
		if("get".equalsIgnoreCase(super.getMethod())){
		
		}
		return super.getParameterMap();
	}
	
}
