package cn.jie.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class buyShow extends HttpServlet {

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
		out.println("这是本商品的详细简介：<br />");
		
		//获取用户带来的id 
		String id = request.getParameter("id");
		BuyBookClass book = buyDb.getAll().get(id);
		
		//显示带过来的商品详细信息
		out.write(book.getId()+"<br />");
		out.write(book.getName()+"<br />");
		out.write(book.getAuthor()+"<br />");
		out.write(book.getDescription()+"<br />");
		
		//构建cookie
		String cookieValue = buildCookie(id,request);
		Cookie cookie = new Cookie("bookHistory",cookieValue);
		cookie.setMaxAge(1*30*24*3600);
		cookie.setPath("/myservlet");
		response.addCookie(cookie);
		
	}

	private String buildCookie(String id, HttpServletRequest request) {
		
		//用户没带任何值回来。bookHistory = null .1
		
		String bookHistory = null;
		Cookie cookies[] = request.getCookies();
		for(int i = 0;cookies!=null && i<cookies.length;i++){
			if(cookies[i].getName().equals("bookHistory")){
				bookHistory = cookies[i].getValue();
			}
		}
		//没带值，则返回id
		if(bookHistory==null){
			return id;
		}
		
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(bookHistory.split("\\,")));
		if(list.contains(id)){
			list.remove(id);
		}else{
			if(list.size()>=3){
				list.removeLast();
			}
		}
		list.addFirst(id);
		
		StringBuffer sb = new StringBuffer();
		for(String sid:list){
			sb.append(sid + ",");
		}
/*		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			sb.append(it.next()+ ",");
		}*/
		
		return sb.deleteCharAt(sb.length()-1).toString();

/*		if(list.contains(id)){
			//如果含有list,则删除当前位置，并加在第一个
			list.remove(id);
			list.addFirst(id);
		}else{
			//如果满了，则删除最后一个。添加到第一个
			if(list.size()>=3){
				list.removeLast();
				list.addFirst(id);
			}else{
				//没满直接添加
				list.addFirst(id);
			}
		}*/

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


	}

}
