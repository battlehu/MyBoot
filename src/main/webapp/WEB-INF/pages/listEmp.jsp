<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.text.SimpleDateFormat,java.util.Date" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.example.demo.entity.Emp"%>
<%@page import="com.example.demo.mapper.EmpDao"%>
<%@page import="com.example.demo.entity.User"%>
<%@include file="session.jsp"%>
<html>
	<head>
		<title>员工列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 				
				<%@include file="head.jsp" %>
				<div id="content">
					<p id="whereami"></p>
					<h1>员工列表</h1>
					<table class="table">
						<tr class="table_header">
							<td>ID</td>
							<td>姓名</td>
							<td>薪水</td>
							<td>年龄</td>
							<td>操作</td>
						</tr>
						
					<c:forEach items="${emps}" var="emps" varStatus="varSta">
						<tr class="row${varSta.count%2+1 }">
							<td>${emps.sid }</td>
							<td>${emps.name }</td>
							<td>${emps.salary }</td>
							<td>${emps.age }</td>
							<td>
								<%-- <a href="deleteEmp.action?sid=<%=emp.getSid() %>"><button>删除员工</button></a>&nbsp;<a href="findEmp.action?sid=<%=emp.getSid() %>"><button>修改员工</button></a> --%>
								<input type="button" class="button" value="删除员工" onclick="location='/action/deleteEmp?sid=${emps.sid }'"/>&nbsp;
								<input type="button" class="button" value="修改员工" onclick="location='/action/findEmp?sid=${emps.sid }'"/>
							</td>
						</tr>
					</c:forEach>
					<tr class="table_header">
							<td>当前${sessionScope.pageBean.currentPage }/${sessionScope.pageBean.totalPage }页     &nbsp;&nbsp;</td>
  							<td><a href="/action/list?currentPage=1">首页</a></td>
  							<td><a href="/action/list?currentPage=${sessionScope.pageBean.currentPage-1}">上一页 </a></td>
  							<td><a href="/action/list?currentPage=${sessionScope.pageBean.currentPage+1}">下一页 </a></td>
  							<td><a href="/action/list?currentPage=${sessionScope.pageBean.totalPage}">末页</a></td>
						</tr>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='/redirect/addEmp'"/>
						<input type="button" class="button" value="安全退出" onclick="location='/redirect/out'"/>
					</p>
				</div>
			</div>
			
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
