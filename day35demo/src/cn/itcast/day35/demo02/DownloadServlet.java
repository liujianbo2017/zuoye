package cn.itcast.day35.demo02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

public class DownloadServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收请求,得到文件名
		String filename = req.getParameter("filename");
		//如果提交的是billgates，则转换成中文文件 名
		if( filename.equals("billgates.jpeg") ){
			filename = "比尔盖茨.jpeg";
		}
		//filename = new String(filename.getBytes("ISO-8859-1"),"UTF-8");
		//处理请求读取文件内容
		//把服务器的路径转换成绝对路径
		String realPath = getServletContext().getRealPath("/download/"+filename);
		System.out.println(realPath);
		//使用绝对路径创建字节输入流
		FileInputStream fis = new FileInputStream(realPath);
		//设置响应头：此文件名为提示的名称，和实际文件的物理文件名无关（text/html; charset=UTF-8）
		//响应头中包含中文，则会产生乱码（中文文件名）
		//URLEncoder：URL编码：用%两位16进制表示一个字节，来传递数据
		
		//判断一下用户使用的是不是火狐浏览器(从请求头中取得User-Agent)
		String agent = req.getHeader("User-Agent");
		if(agent.contains("Firefox")){
			//是，则使用Base64编码
			filename=base64EncodeFileName(filename);
		}else{
			//否则使用URLEncode编码
			filename=URLEncoder.encode(filename, "UTF-8");
		}
		System.out.println(filename);
		resp.setHeader("Content-Disposition", "attachment;filename"+filename);
		//得到响应对象的字节输出流
		ServletOutputStream os = resp.getOutputStream();
		
		int len;
		byte[] bytes = new byte[1024];
		while((len = fis.read(bytes))!=-1){
			//做出响应，把读取到的文件内容，使用响应对象的输出流发送给浏览器
			os.write(bytes, 0, len);
		}
		fis.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?"
					+ new String(base64Encoder.encode(fileName
							.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
