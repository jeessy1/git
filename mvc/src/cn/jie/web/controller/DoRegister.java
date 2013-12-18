package cn.jie.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.jie.domain.User;
import cn.jie.exception.UserExistException;
import cn.jie.service.impl.BusinessServiceImpl;
import cn.jie.utils.WebUtils;
import cn.jie.web.form.RegisterForm;

public class DoRegister extends HttpServlet {

	/**
	 * 		处理注册请求 <br>
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

			
			//1对表单字段合法性校验（formbean封装传来的表单）
			RegisterForm formbean = WebUtils.request2Bean(request, RegisterForm.class);
			boolean b = formbean.validate();
			
			//2如果校验错误，跳回表单页面，回显检验失败信息
			if(!b){
				request.setAttribute("formbean", formbean);
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
				return;
			}
			
			//3如果检验成功,调用service 处理注册请求
			User user = new User();
			WebUtils.copyBean(formbean, user);
			user.setId(WebUtils.generateID());
			
			BusinessServiceImpl service = new BusinessServiceImpl();
			try {
			//6如果处理成功，跳转到网站全局消息显示页面，显示注册成功消息
			service.register(user);
			request.setAttribute("message", "恭喜您，注册成功");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);

			} catch (UserExistException e) {
				//4如果service处理不成功，不成功原因，跳回注册页面，显示用户已存在
				formbean.getErrors().put("username", "注册的用户已存在");
				request.setAttribute("formbean", formbean);
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
				return;
			}catch(Exception e){
				//5如果service处理不成功，是其它问题的话，跳转到网站全局消息显示页面，显示友好信息
				request.setAttribute("message", "服务器出现未知错误");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				return;

			}
			
			
			
			

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

		this.doGet(request, response);
	}

}
