<%@include file="/WEB-INF/views/includes/header.jsp"%>

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
	<table border="1" class="deptTable">
		<tr>
			<th>EmployeeID</th>
			<th>Employee FirstName</th>
			<th>Employee LastName</th>
			<th>Department</th>
			<th>Employee Age</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach var="emp" items="${empList}">
			<tr id="empRowId_${emp.getEmpId()}">
				<td>${emp.getEmpId()}</td>
				<td id="empFirstNameId_${emp.getEmpId()}">${emp.getEmpFirstName()}</td>
				<td id="empLastNameId_${emp.getEmpId()}">${emp.getEmpLastName()}</td>
				<td id="empDeptId_${emp.getEmpId()}">${emp.getDepartment().getDeptName()}</td>
				<td id="empAgeId_${emp.getEmpId()}">${emp.getEmpAge()}</td>
				<td>
					<button id="empDeleteBtnId_${emp.getEmpId()}" type="button" onclick="deleteEmp(${emp.getEmpId()})">Delete</button>
				</td>
				<td id="empUpdateCellId_${emp.getEmpId()}">
					<button type="button" onclick="updateEmpInfo(${emp.getEmpId()})">Update</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@include file="/WEB-INF/views/includes/footer.jsp"%>



