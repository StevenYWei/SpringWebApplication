<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="net.antra.sep.springassignment.entity.*" %>

<h1 align="center">This is department page!</h1>
<div align="center">Current User: <strong>${userName}</strong><br></div>

<div align="center">
	<!-- A form to add the department -->
	<strong>Please input new department information:</strong>
	<form action="addDept" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<table>
			<tr>
				<td>Department Name:</td>
				<td><input type="text" name="deptName" value="HR" required="required"/></td>
			</tr>
			<tr>
				<td>Department Email:</td>
				<td><input type="text" name="deptEmail" value="*@antra.net" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="Add Department" /></td>
				<td><input type="reset" name="action" value="Reset" /></td>
			</tr>
		</table>
	</form>
</div>
<div align="center"><a href="getDeptEmpListAtMain">Back to Main Page</a></div>

<!-- Display the department and employee information -->
<div align="center"><h3><strong>Existing Department and Employee</strong></h3></div>
<div align="center">
	<table border="1">
		<tr>
			<th>Department ID</th>
			<th>Department Name</th>
			<th>Department Email</th>
			<th>Department Employee</th>
		</tr>
		<c:forEach var="dept" items="${deptList}">
			<tr>
				<td>${dept.getDeptId()}</td>
				<td>${dept.getDeptName()}</td>
				<td>${dept.getDeptEmail()}</td>
				<td><c:forEach var="emp" items="${dept.getEmployeeList()}">
				${emp.getEmpFirstName()}${emp.getEmpLastName()};
			</c:forEach></td>
			</tr>
		</c:forEach>
	</table>
</div>
