package cn.jie.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class buyList extends HttpServlet {

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
			
			//�������վ���е���Ʒ
			PrintWriter out = response.getWriter();
			out.write("��վ��������Ʒ��<br />");
			
			Map<String,BuyBookClass> map = buyDb.getAll();
			for(Map.Entry<String, BuyBookClass> entry : map.entrySet()){
				BuyBookClass book = entry.getValue();
				out.println("<a href='/myservlet/servlet/buyShow?id="+book.getId()+"' target='_blank'>"+book.getName()+"</a><br />");
			}
			
			
			//��ʾ�û�������������Ʒ
			out.println("<br />������������<br />");
			Cookie cookies[] = request.getCookies();
			for(int i=0 ; cookies!=null && i<cookies.length;i++){
				if(cookies[i].getName().equals("bookHistory")){
					String cookieTemp = cookies[i].getValue();
					String ids[] = cookieTemp.split("\\,");	//   \\, ȷ��,Ϊ,  ��Щ������ʽ���á�
					for (String id : ids){
						BuyBookClass book = (BuyBookClass)buyDb.getAll().get(id);
						out.println("<a href='/myservlet/servlet/buyShow?id="+book.getId()+"' target='_blank'>"+book.getName()+"</a><br />");
					}
				}
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


	}

}
