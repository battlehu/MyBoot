<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.text.SimpleDateFormat,java.util.Date" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<%@include file="session.jsp"%>
<html>
	<head>
		<title>添加员工</title>
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
						添加员工
					</h1>
					<form action="/action/addEmp" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
									<span style="color:red">${add_error }</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									薪水:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确定添加" />
						</p>
					</form>
				</div>
			</div>
			
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
