package cn.jie.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jie.utils.WebUtils;
import cn.jie.web.form.LoginForm;

public class DoLogin extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//判断带没带参数过来。防止直接访问http://localhost:8080/mvc/servlet/DoLogin，引起错误
		Enumeration em = request.getParameterNames();
		if(!em.hasMoreElements()){
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}
		
		
		LoginForm loginbean = WebUtils.request2Bean(request, LoginForm.class);

		//判断帐号密码是否相同,不同
		if(!loginbean.validate()){
			request.setAttribute("loginbean", loginbean);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}
		
		//帐号密码相同
		request.getSession().setAttribute("loginbean", loginbean);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return;
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
