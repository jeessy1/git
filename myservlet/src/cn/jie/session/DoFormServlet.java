package cn.jie.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DoFormServlet extends HttpServlet {

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

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		boolean b = isTokenValid(request);
		if(!b){
			out.println("请不要重复提交");
			return;
		}
		
		request.getSession().removeAttribute("token");
		out.println("向数据库中注册用户");
	}


	private boolean isTokenValid(HttpServletRequest request) {
		//判断token是否有效
		
		//判断客户机带来的token是否有效
		String client_token = request.getParameter("token");	
		if(client_token == null){
			return false;
		}
		
		//判断服务器端的token是否有效
		String server_token = (String) request.getSession().getAttribute("token");
		if(server_token == null){
			return false;
		}
		
		//判断客户机与服务器端的token是否相同
		if(!client_token.equals(server_token)){
			return false;
		}
		return true;
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
