<%--
  Created by IntelliJ IDEA.
  User: 69532
  Date: 2018/12/19
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" import="java.util.*" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>this is the login page</title>
</head>
<body>
<div>
    <h1>BJFU用户管理</h1>
</div>
<div>
    <form action="<%=basePath %>login/toLogin" method="post">
        <label for="usename" >用户名:</label><input type="text" name="username" value="${username}" placeholder="请输入用户名">
        <br/>
        <label for="password">密码:</label><input type="text" name="password" value="${password}" placeholder="请输入密码">
        <%
            if(request.getAttribute("message") != null) {
        %>
        <div>
            <p>${message }</p>
        </div>
        <%
            }
        %>
        <br/>
        <input type="submit" value="登录">
    </form>

</div>

</body>
</html>
