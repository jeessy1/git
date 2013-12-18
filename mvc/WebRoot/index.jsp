<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
    
  </head>
  
  <body>
  
  <br />
  
 	<c:if test="${loginbean!=null}">
 		${loginbean.username }<a href="${pageContext.request.contextPath}/servlet/Logout">注消</a>
  	</c:if>
  
    <c:if test="${loginbean==null}">
    <a href="${pageContext.request.contextPath}/servlet/RegisterUIServlet">注册</a>
    <a href="${pageContext.request.contextPath}/servlet/LoginUIServlet">登陆</a>
  </c:if>

  </body>
</html>
