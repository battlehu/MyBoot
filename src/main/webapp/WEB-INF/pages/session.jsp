<%@page import="com.example.demo.entity.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:if test="${empty user}">
	<c:redirect url="/redirect/login"></c:redirect>
</c:if>
