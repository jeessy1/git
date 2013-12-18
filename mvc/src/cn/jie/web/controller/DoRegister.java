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
	 * 		����ע������ <br>
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

			
			//1�Ա��ֶκϷ���У�飨formbean��װ�����ı���
			RegisterForm formbean = WebUtils.request2Bean(request, RegisterForm.class);
			boolean b = formbean.validate();
			
			//2���У��������ر�ҳ�棬���Լ���ʧ����Ϣ
			if(!b){
				request.setAttribute("formbean", formbean);
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
				return;
			}
			
			//3�������ɹ�,����service ����ע������
			User user = new User();
			WebUtils.copyBean(formbean, user);
			user.setId(WebUtils.generateID());
			
			BusinessServiceImpl service = new BusinessServiceImpl();
			try {
			//6�������ɹ�����ת����վȫ����Ϣ��ʾҳ�棬��ʾע��ɹ���Ϣ
			service.register(user);
			request.setAttribute("message", "��ϲ����ע��ɹ�");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);

			} catch (UserExistException e) {
				//4���service�����ɹ������ɹ�ԭ������ע��ҳ�棬��ʾ�û��Ѵ���
				formbean.getErrors().put("username", "ע����û��Ѵ���");
				request.setAttribute("formbean", formbean);
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
				return;
			}catch(Exception e){
				//5���service�����ɹ�������������Ļ�����ת����վȫ����Ϣ��ʾҳ�棬��ʾ�Ѻ���Ϣ
				request.setAttribute("message", "����������δ֪����");
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
