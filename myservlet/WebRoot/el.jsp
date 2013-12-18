<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'el.jsp' starting page</title>
    

  </head>
  
  <body>
	<%
		request.setAttribute("name", "cj");
	%>

	${name}<br /> <%-- EL表达式，从page ,request session application中查找name的值 --%>
	
	
	<%-- 在jsp页面中，可使用el表达获取bean中的属性 --%>
	<%
		cn.jie.domain.Person person = new cn.jie.domain.Person();
		person.setAge(10);
		request.setAttribute("person", person);
	%>
	
	${person.age}<br />
	
	
	<%-- 在JSP页面中，可以用el表达式获取bean中的bean中的bean... --%>
	<%
		cn.jie.domain.Person person1 = new cn.jie.domain.Person();
		cn.jie.domain.Address address = new cn.jie.domain.Address();
		person1.setAddress(address);
	
		request.setAttribute("person1", person1);
	%>
	${person1.address.name}<br />
	
	
	<%-- 在JSP页面中，可以用el表达式获取list集合中的数据 --%>
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
	${list[0].name}<br />
	
	<%-- 在JSP页面中，可以用el表达式获取Map集合中的数据 --%>
	<%
		Map<String,String> map = new HashMap<String,String>();
		map.put("a","aaa");
		map.put("b","bbb");
		map.put("c","ccc");
		
		map.put("1","111");

		request.setAttribute("map", map);
		
	%>
	${map.a}<br />
	${map["1"]}<br /> 	<%-- 取名称为数字的写法 --%>
	
	<a href="${pageContext.request.contextPath }/el.jsp">打开本页</a>
  </body>
</html>
