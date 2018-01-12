package com.TC25.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//利用resp获得tomcat的响应输出流
		ServletOutputStream os=resp.getOutputStream();
		//InputStream读取本地服务器文件(输入流)
		FileInputStream is = new FileInputStream("E:/JEE教学笔记/timg.jpg");
		byte[] b = new byte[1024];
		int read = -1;
		while((read = is.read(b)) != -1){
			//在输出流上写读取的内容
			os.write(b,0,read);
		}
		is.close();
//		
//		resp.setContentType("text/html;charset=utf-8");
		//利用resp获得tomcat响应输出流
//		PrintWriter w = resp.getWriter();
		//在输出流上写内容
//		w.write("李小璐<br/>");
//		w.write("贾乃亮");
//		
		
		
	}
}
