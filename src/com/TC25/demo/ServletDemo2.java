package com.TC25.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

public class ServletDemo2 extends HttpServlet{
	@Override
	//验证码的代码
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ValidateCode vc = new ValidateCode(120, 20, 4, 9);		
		String code = vc.getCode();
		System.out.println(code);
		vc.write(resp.getOutputStream());
	}
}
