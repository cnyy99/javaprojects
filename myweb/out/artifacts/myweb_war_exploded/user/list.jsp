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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>userlist</title>
<script type="text/javascript">

	function search() {
		gotoPage(0);
	}

	function add() {
		location.href = "${ctx}/user/add.jsp";
	}
	
	function query(){
		var form1=document.getElementById("myForm");
        form1.submit();
	}

</script>
</head>
<body>

<form action="<%=basePath%>user/list" method="post" id="myForm" name="myForm" class="am-form" >

<label>用户管理</label>
<br/>

<%String qv="";
	 if(request.getParameter("queryValue")==null){
		 qv="";
			}else{
				qv=request.getParameter("queryValue");
				 }
			%>

<input type="text" name="queryValue" value="<%=qv%>" >
<input type="button" value="查询" onclick="query()"><input type="button" value="新增" onclick="add()">
<table>
	<thead>
		<tr>
			<th>姓名</th>
			<th>密码</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	<%
		List<User> userlist=(List<User>) request.getAttribute("list");
		for(User user:userlist){		
	%>
		<tr>
			<td><%=user.getUsername() %>&nbsp;</td>
			<td><%=user.getPassword() %>&nbsp;</td>
			<td><div>
			<a href="<%=basePath %>user/edit?id=<%=user.getId() %>">编辑</a>
			<a href="<%=basePath %>user/delete?id=<%=user.getId() %>" onclick=window.confirm("SURE TO DELETE")>删除</a>
			</div>
			</td>
		</tr>
	<%} %>	
	</tbody>
	
	
	
</table>

</form>


</body>

</html>