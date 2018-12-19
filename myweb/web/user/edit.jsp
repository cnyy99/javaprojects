<%@page import="domain.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<strong>用户编辑</strong>
</div>>
<%User user = (User)request.getAttribute("user"); %>
<form action=<%=basePath%>user/save  method="post">
<label for="username">用户名:</label> <input type="text" value=<%=user.getUsername() %>>
<label for="password">密码：</label><input type="text" value=<%=user.getUsername() %>>


<div>
<input type="submit"  value="提交" />
	&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="返回" onclick="javascript:history.back();" />
</div>
	
</form>
</body>
</html>