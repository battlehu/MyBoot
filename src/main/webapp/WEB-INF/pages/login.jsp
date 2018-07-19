<%@page import="com.example.demo.entity.User,javax.servlet.http.Cookie"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.text.SimpleDateFormat,java.util.Date" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>管理员登录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="../css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					
				<%@include file="head.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						管理员登录
					</h1>
					<form action="/action/login" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" value="<c:out value="${sessionScope.inputUsername}"></c:out>"/>
									
									<span style="color:red"><c:out value="${sessionScope.login_error}"></c:out></span>
									
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="登录 &raquo;" />&nbsp;
							<input type="button" class="button" value="注册 &raquo;" onclick="location='/redirect/regist'"/>
						</p>
					</form>
				</div>
			</div>
			
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
