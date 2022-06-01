<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page isELIgnored="false"%>
<title>New/Edit Employee</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Employee</h1>
		<form:form action="register" method="post" modelAttribute="employee">
			<table>
				<form:hidden path="ID" />
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><form:input type="date" path="dateOfBirth" /></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td><form:input path="salary" /></td>
				</tr>
				<tr>
					<td>Department:</td>
					<td><select name="department">
							<option value="NONE">Select a department</option>
							<c:forEach items="${listDepartment}" var="department">
								<option value="${department.ID}.${department.name}"
									<c:if test="${department.ID eq employee.department.ID}">selected="selected"</c:if>>
									${department.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>