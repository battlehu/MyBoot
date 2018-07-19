<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.text.SimpleDateFormat,java.util.Date,com.example.demo.entity.Emp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<%@include file="session.jsp"%>
<html>
	<head>
		<title>修改员工</title>
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
						修改员工:
					</h1>
					
					<form action="/action/updateEmp" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									ID:
								</td>
								<input type="hidden" name="sid" value="${emp.sid }"/>
								<td valign="middle" align="left">
									${emp.sid }
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="${emp.name }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									薪水:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="${emp.salary }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="${emp.age }"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确认修改" />
						</p>
					</form>
				</div>
			</div>
			
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
