<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登陆</title>
    
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/servlet/DoLogin" method="post">
    	<div>用户名<input type="text" name="username">${loginbean.map.username }</div>
    	<div>密码<input type="password" name="password">${loginbean.map.password }</div>
    	<div><input type="submit" value="登陆"></div>

  </body>
</html>
