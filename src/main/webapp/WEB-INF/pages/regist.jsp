<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.text.SimpleDateFormat,java.util.Date" %>

<!DOCTYPE html>
<html>
	<head>
		<title>注册</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
			    
	<body>
		<div id="wrap">
			<div id="top_content">
					
					<%@include file="head.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="/action/regist" method="post">
						<table cellpadding="0" cellspacing="0" border="0" 
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" value="${sessionScope.inputUsername }"/>
									<span style="color:red">${regist_error }</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="realname" value="${sessionScope.inputRealname }"/>
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
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="f"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="img1" src="/check/code"/>
									<a href="javascript:;" onclick="document.getElementById('img1').src='/check/code?'+Math.random();">换一张</a>
									
								</td>
								<td valign="middle" align="left">
									<input type="text" name="code"/>
									<span style="color:red">${code_error }</span>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="注册 &raquo;" />
						</p>
					</form>
				</div>
			</div>
			
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
