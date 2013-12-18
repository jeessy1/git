<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'jstl-el.jsp' starting page</title>
    

  </head>
  
  <body>
 	 
 	<!-- 用jstl+el 跌代list集合 -->
    <%
		cn.jie.domain.Person person2 = new cn.jie.domain.Person();
		person2.setName("chenjie2-list");
		
		cn.jie.domain.Person person3 = new cn.jie.domain.Person();
		person3.setName("chenjie3-list");
		
		List list = new ArrayList();
		list.add(person2);
		list.add(person3);
		
		request.setAttribute("list", list);
	%>
	
	<c:forEach var="person" items="${list}">
	${person.name}<br />
	</c:forEach>
	
	
	
	<!-- 用jstl+el 跌代map集合，SET<Map.Entry> set = map.entrySet() -->
	<%
		Map<String,String> map = new HashMap<String,String>();
		map.put("a","aaa");
		map.put("b","bbb");
		map.put("c","ccc");
		map.put("1","111");
		
		request.setAttribute("map", map);
	%>
	
	<!-- 实际上是跌代SET集合，SET<Map.Entry> set = map.entrySet() -->
	<c:forEach var="me" items="${map }">
	${me.key} = ${me.value}<br />
	</c:forEach>
	
	<!-- 用jstl的IF标签  -->
	<c:if test="${user!=null}">
			欢迎您：${username }
	</c:if>
	<c:if test="${requestuser==null}">
		<form action="">
		用户名：<input type="text" name="user">
		密码：<input type="password" name="password">
		<input type="submit" value="登陆">
		</form>
	</c:if>
		
	
  </body>
</html>
