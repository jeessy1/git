<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>jsp:usebean标签使用</title>
    
  </head>
  
  <body>
  
  	<%-- usebean中的标签只在创建bean中才起作用。 --%>
    <jsp:useBean id="person" class="cn.jie.domain.Person" scope="session">
    aaaaa
    </jsp:useBean>
    
    <%-- 使用setProperty为Person类中的name赋值 --%>
    <jsp:setProperty property="name" name="person" value="陈杰"/>
    <%=person.getName()%>
    
         
     <%-- 使用参数来赋值 --%>
    <jsp:setProperty property="name" name="person" param="name"/>
    <jsp:setProperty property="age" name="person" param="age"/> <!--  支持8种基本的数据类型自动转换 -->
    
	<%=person.getName()%><br />
	<%=person.getAge()%><br />
	
	
	<%-- 用所有的参数为person赋值  --%>
	<jsp:setProperty property="*" name="person"/>
	<br /><br /><%=person.getName()%><br />
	<%=person.getAge()%><br />
        
	
  </body>
</html>
