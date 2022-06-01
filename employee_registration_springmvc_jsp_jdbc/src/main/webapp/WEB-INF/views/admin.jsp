
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page isELIgnored="false"%>
<title>Admin: Employee Info Home</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/delete.js"></script>
</head>

<body>
	<div id="EmployeeFormResponses" align="center">
		<h1>${welcomeMessage}</h1>
		<h3>
			<a href="${pageContext.request.contextPath}/admin/logout">Logout</a>
		</h3>
		<h1>
			<spring:message code="lbl.page" text="All Employees in the System" />
		</h1>
		<h3>
			<a href="${pageContext.request.contextPath}/admin/newEmployee">New
				Employee</a>
		</h3>
		<table border="1">
			<thead>
				<tr align="center">
					<th scope="col" align="center"><spring:message code="lbl.ID"
							text="ID" /></th>
					<th scope="col" align="center"><spring:message
							code="lbl.firstName" text="First Name" /></th>
					<th scope="col" align="center"><spring:message
							code="lbl.lastName" text="Last Name" /></th>
					<th scope="col" align="center"><spring:message
							code="lbl.email" text="Email" /></th>
					<th scope="col" align="center"><spring:message
							code="lbl.phone" text="Phone" /></th>
					<th scope="col" align="center"><spring:message code="lbl.age"
							text="Age" /></th>
					<th scope="col" align="center"><spring:message
							code="lbl.salary" text="Salary" /></th>
					<th scope="col" align="center"><spring:message
							code="lbl.department" text="Department" /></th>
					<th scope="col" align="center"><spring:message
							code="lbl.action" text="Action" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${employeeList}" var="employee">
     <tr>
							<th scope="row" align="center">${employee.ID}</th>
							<td align="center"><c:out value="${employee.firstName}" /></td>
							<td align="center"><c:out value="${employee.lastName}" /></td>
							<td align="center"><c:out value="${employee.email}" /></td>
							<td align="center"><c:out value="${employee.phone}" /></td>
							<td align="center"><c:out value="${employee.age}" /></td>
							<td align="center"><c:out value="${employee.salary}" /></td>
							<td align="center"><c:out
									value="${employee.department.name}" /></td>
							<td>       <a
								href="${pageContext.request.contextPath}/admin/editEmployee?ID=${employee.ID}">Edit</a>
								           &nbsp;&nbsp;&nbsp;&nbsp; <%--        <a href="${pageContext.request.contextPath}/admin/deleteEmployee?ID=${employee.ID}">Delete</a> --%>
								     <a
								href="${pageContext.request.contextPath}/admin/delete/${employee.ID}.json">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tr>
			</tbody>
		</table>
		        
	</div>
	    
</body>
</html>

