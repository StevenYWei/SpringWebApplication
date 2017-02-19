<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="net.antra.sep.springassignment.entity.*" %>
<%@ page import="java.util.*" %>
<%@ page errorPage="errorpage.jsp" %>

<h1 align="center">This is employee page!</h1>
<div align="center">Current User: <strong>${userName}</strong></div>

<div align="center">
	<!-- A form to add the department -->
	Please input employee information:
	<form action="addEmp" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="empFirstName" value="John" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="empLastName" value="Web" /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="number" name="empAge" value="27" /></td>
			</tr>
			<tr>
				<td>Department:</td>
				<td>
					<select name="deptSelection">
						<c:forEach var="dept" items="${deptList}">
							<option value="${dept.getDeptId()}">${dept.getDeptName()}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr><td>
				<c:if test="${empty deptList}">
					<input type="submit" name="action" value="Add Employee" disabled/>
				</c:if>
				<c:if test="${!empty deptList}">
					<input type="submit" name="action" value="Add Employee"/>
				</c:if>
			</td></tr>
		</table>
	</form>
</div>

<div align="center"><a href="getDeptEmpListAtMain">Back to Main Page</a></div>

<div align="center"><h3><strong>Existing Employee</strong></h3></div>

<!-- Display the department and employee information -->
<div align="center">
	<table border="1">
		<tr>
			<th>EmployeeID</th>
			<th>Employee FirstName</th>
			<th>Employee LastName</th>
			<th>Department</th>
			<th>Employee Age</th>
		</tr>
		<c:forEach var="emp" items="${empList}">
			<tr>
				<td>${emp.getEmpId()}</td>
				<td>${emp.getEmpFirstName()}</td>
				<td>${emp.getEmpLastName()}</td>
				<td>${emp.getDepartment().getDeptName()}</td>
				<td>${emp.getEmpAge()}</td>
			</tr>
		</c:forEach>
	</table>
</div>
