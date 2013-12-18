<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
    
  </head>
  
  <body>
    
    	<form action="${pageContext.request.contextPath }/servlet/DoRegister" method="post">
    	
    		<div>用户名<input type="text" name="username" />${formbean.errors.username }</div>
    		<div>密码<input type="password" name="password" />${formbean.errors.password }</div>
    		<div>密码<input type="password" name="password2" />${formbean.errors.password2 }</div>
    		<div>邮箱<input type="text" name="email" />${formbean.errors.email}</div>
    		<div>生日<input type="text" name="birthday" />${formbean.errors.birthday}</div>
    		<div><input type="reset" value="清空" /><input type="submit" value="注册" /></div>
    		
    	</form>

  </body>
</html>
