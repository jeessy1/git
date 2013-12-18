<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>pagecontext</title>
    

  </head>
  
  <body>
   
   <%
		pageContext.setAttribute("data", "x22dsxxx",PageContext.SESSION_SCOPE);
//		String data = (String)session.getAttribute("data");//  效果同下面两句,取不到数据，因为pageContext.setAttribute()是向session域中存的
//		String data = (String)request.getAttribute("data");//取不到数据
//		String data = (String)pageContext.getAttribute("data", PageContext.SESSION_SCOPE);//能取到，因为指定了从session域中取
		String data = (String)pageContext.findAttribute("data"); //从pagecontxt request session servletcontext中查找
		
   %>
   <%=data %>
  </body>
</html>
