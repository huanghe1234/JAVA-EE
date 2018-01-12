package com.TC25.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletDemo4 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//通过路径得到一个输入流
				String path = "E:\\作业\\作业.png";
				FileInputStream fis = new FileInputStream(path);
				//创建字节输出流
				ServletOutputStream sos = resp.getOutputStream();
				
				//得到要下载的文件名
				String filename = path.substring(path.lastIndexOf("\\")+1);
				
				//设置文件名的编码
				filename = URLEncoder.encode(filename, "UTF-8");//将不安全的文件名改为UTF-8格式
				
				//告知客户端要下载文件
				resp.setHeader("content-disposition", "attachment;filename="+filename);
				//文件下载http://tool.oschina.net/commons
				resp.setHeader("content-type", "application/x-jpg");
				
				//执行输出操作
				int len = 1;
				byte[] b = new byte[1024];
				while((len=fis.read(b))!=-1){
					sos.write(b,0,len);
				}
				
				sos.close();
				fis.close();
	}
}
